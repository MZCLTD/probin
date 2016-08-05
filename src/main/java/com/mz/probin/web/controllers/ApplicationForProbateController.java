package com.mz.probin.web.controllers;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mz.probin.constants.Constants;
import com.mz.probin.dao.GenericDao;
import com.mz.probin.dto.Customer;
import com.mz.probin.entities.ApplicationForLetterOfAdministration;
import com.mz.probin.entities.ApplicationForProbate;
import com.mz.probin.entities.Transactionz;
import com.mz.probin.mfiles.classes.Lookup;
import com.mz.probin.mfiles.classes.MFileDataType;
import com.mz.probin.mfiles.classes.ObjectCreationInfo;
import com.mz.probin.mfiles.classes.ObjectVersion;
import com.mz.probin.mfiles.classes.PropertyValue;
import com.mz.probin.mfiles.classes.TypedValue;
import com.mz.probin.mfiles.classes.UploadInfo;
import com.mz.probin.mfiles.web.rest.MFilesHttpComponentsRestTemplate;
import com.mz.probin.util.AuthenticationUtils;
import com.mz.probin.util.TimeUtils;

@Controller
public class ApplicationForProbateController {
	
	@Autowired
    private MFilesHttpComponentsRestTemplate mfilesHttpComponentsRestTemplate;
	
	@Autowired
	private GenericDao genericDao;
	
	@RequestMapping(value = "/applicationForProbate", method = RequestMethod.GET)
	public String startApplicationForProbate(Model model, HttpServletRequest request){
		
		ApplicationForProbate appForProbate = new ApplicationForProbate();
		
		model.addAttribute("ap", appForProbate);
		
		return "probate-application";
		
	}
	
	@RequestMapping(value = "/applicationForProbate", method = RequestMethod.POST)
	public String processApplicationForProbate( @ModelAttribute ApplicationForProbate ap, 
						Authentication authentication, MultipartHttpServletRequest request ) throws Exception{
		
		String token = AuthenticationUtils.getAuthenticationToken();
		
		Random rand = new Random();
        int  id = rand.nextInt(1000000000) + 1;
        String applicationId = "AFP/"+ ap.getNameOfApplicat() + "/"+ id;
        
        List<UploadInfo> uploadInfos = this.mfilesHttpComponentsRestTemplate.multipartFormDataPostTemplate(token, Constants.UPLOAD_URL,
                request.getFileMap().values(), UploadInfo.class);

        if (uploadInfos != null && uploadInfos.size() > 0) {
        	
        	// Proposal Title
            PropertyValue propValue1 = new PropertyValue();
            propValue1.setPropertyDef(0);
            propValue1.setTypedValue(new TypedValue(MFileDataType.Text.value(), "AFP - "+ap.getNameOfApplicat()+"- "+TimeUtils.getTodaysDate()));
            
            // Application Id
            PropertyValue propValue2 = new PropertyValue();
            propValue2.setPropertyDef(1059);
            propValue2.setTypedValue(new TypedValue(MFileDataType.Text.value(), applicationId));
            
            // Date of application
            PropertyValue propValue3 = new PropertyValue();
            propValue3.setPropertyDef(1058);
            propValue3.setTypedValue(new TypedValue(MFileDataType.Date.value(), TimeUtils.getTodaysDate()));
            
            Lookup lookup = new Lookup();
            lookup.setItem(13);
            
            TypedValue tv = new TypedValue();
            tv.setLookup(lookup);
            tv.setDataType(MFileDataType.Lookup.value());
            
            //For Class Type (Proposal)
            PropertyValue propValue4 = new PropertyValue();
            propValue4.setPropertyDef(100);
            //5 is Proposal (Object Class).
            propValue4.setTypedValue(tv);
            
            PropertyValue[] propertyValues = new PropertyValue[] {
                    propValue1, propValue2, propValue3 , propValue4 };
            
            ObjectCreationInfo objectCreationInfo =
                    new ObjectCreationInfo(propertyValues, uploadInfos.toArray(new UploadInfo[0]));
            
            ObjectVersion objectVersion = this.mfilesHttpComponentsRestTemplate
                    .createObjectInfo(token, objectCreationInfo, 0);
            
            if (objectVersion.isHasErrors()) {
                System.out.println("Has errors...");
            }

            System.out.println("ObjectVersion: Title -> " + objectVersion.getTitle() + ", "
            		+ "ObjectClass: " + objectVersion.getObjectClass()+", Object Id:"+objectVersion.getDisplayId()+", "
            				+ "Object Version :"+objectVersion.getObjVer().getVersion());
            
            ap.setApplicationId(applicationId);
            ap.setDateOfApplication(TimeUtils.getTodaysDate());
            
            createIndexObjectForGrantApplication(ap);
            
            Transactionz transactions = new Transactionz();
	        transactions.setTransactionDateTime(TimeUtils.getTodaysDate());
	        transactions.setTransactionId(applicationId);
	        transactions.setObjectVersion(objectVersion.getObjVer().getVersion());
	        transactions.setObjectId(objectVersion.getDisplayId());
	        transactions.setObjectType(0);
	        transactions.setUsername(authentication.getName());
	        
	        logTransaction(transactions);
        	
        }
		
		
		return "redirect:application-success?noa="+ap.getNameOfApplicat()+"&appId="+applicationId+"&dateOfApp="+TimeUtils.getTodaysDate();
		
	}
	
	private void logTransaction(Transactionz trans){
		 
		 genericDao.persist(trans);
		 
	 }
	
	public ObjectVersion createIndexObjectForGrantApplication( ApplicationForProbate ap ) throws Exception{
		
		System.err.println("E Reach here ooo!");
		 
		 String token = AuthenticationUtils.getAuthenticationToken();
		 
		 PropertyValue propValue1 = new PropertyValue();
        propValue1.setPropertyDef(0);
        propValue1.setTypedValue(new TypedValue(MFileDataType.Text.value(), ap.getNameOfApplicat()+" - "+ap.getApplicationId() + " - "+TimeUtils.getTodaysDate()));
        
        PropertyValue propValue2 = new PropertyValue();
        propValue2.setPropertyDef(1059);
        propValue2.setTypedValue(new TypedValue(MFileDataType.Text.value(), ap.getApplicationId()));
        
        PropertyValue propValue3 = new PropertyValue();
        propValue3.setPropertyDef(1058);
        propValue3.setTypedValue(new TypedValue(MFileDataType.Date.value(), ap.getDateOfApplication()));
        
        Lookup lookup = new Lookup();
           lookup.setItem(14);
           
           TypedValue tv = new TypedValue();
           tv.setLookup(lookup);
           tv.setDataType(MFileDataType.Lookup.value());
           
           //For Class Type (Proposal)
           PropertyValue propValue4 = new PropertyValue();
           propValue4.setPropertyDef(100);
           //5 is Proposal (Object Class).
           propValue4.setTypedValue(tv);
           
           PropertyValue[] propertyValues = new PropertyValue[] { propValue1, propValue2, propValue3, propValue4  };
           
           ObjectCreationInfo objectCreationInfo = new ObjectCreationInfo(propertyValues );
           
           ObjectVersion objectVersion = this.mfilesHttpComponentsRestTemplate
                   .createObjectInfo(token, objectCreationInfo, 107);
           

           if (objectVersion.isHasErrors()) {
               System.out.println("Has errors...");
           }

           System.err.println("ObjectVersion: Title -> " + objectVersion.getTitle() + ", ObjectClass: " + objectVersion.getObjectClass());
		 
           return objectVersion;
	 }
	
	@RequestMapping(value="/application-success", method = RequestMethod.GET)
	public String appilicationSuccess( Model model, HttpServletRequest request ) throws ServletRequestBindingException{
		
		String nameOfApplicant = ServletRequestUtils.getStringParameter(request, "noa");
		String appId = ServletRequestUtils.getStringParameter(request, "appId");
		String dateOfApp = ServletRequestUtils.getStringParameter(request, "dateOfApp");
		
		ApplicationForProbate ap = new ApplicationForProbate();
		ap.setNameOfApplicat(nameOfApplicant);
		ap.setApplicationId(appId);
		ap.setDateOfApplication(dateOfApp);
		
		model.addAttribute("ap", ap);
		
		
		return "application-for-probate-success";
	}

}
