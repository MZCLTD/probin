package com.mz.probin.web.controllers;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mz.probin.constants.Constants;
import com.mz.probin.dao.GenericDao;
import com.mz.probin.dto.Customer;
import com.mz.probin.entities.Transactionz;
import com.mz.probin.mfiles.classes.Lookup;
import com.mz.probin.mfiles.classes.MFileDataType;
import com.mz.probin.mfiles.classes.ObjType;
import com.mz.probin.mfiles.classes.ObjectClass;
import com.mz.probin.mfiles.classes.ObjectCreationInfo;
import com.mz.probin.mfiles.classes.ObjectVersion;
import com.mz.probin.mfiles.classes.PropertyValue;
import com.mz.probin.mfiles.classes.Results;
import com.mz.probin.mfiles.classes.TypedValue;
import com.mz.probin.mfiles.classes.UploadInfo;
import com.mz.probin.mfiles.web.rest.MFilesHttpComponentsRestTemplate;
import com.mz.probin.util.AuthenticationUtils;
import com.mz.probin.util.TimeUtils;


@Controller
public class ConfirmWillAndLandAController {
    @Autowired
    private MFilesHttpComponentsRestTemplate mfilesHttpComponentsRestTemplate;
    
    @Autowired
	private GenericDao genericDao;

    @RequestMapping(value = "/document-upload", method = RequestMethod.GET)
    public String signup( Model model, HttpServletRequest request,
			HttpServletResponse response ) {
    	
    	Customer customer = new Customer();
    	model.addAttribute("customer", customer);
    	
        return "will-landa-confirmation";
    }

   // @ResponseBody
    @RequestMapping(value = "/document-upload", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute Customer customer, Authentication authentication, MultipartHttpServletRequest request) throws Exception {
       //TODO Check if the uploaded file is empty

        String token = AuthenticationUtils.getAuthenticationToken();

        /*ObjType[] objTypes = this.mfilesRestTemplate.getObjectTypes(token, "both");

        for (ObjType objType : objTypes) {
            System.out.println(buildObjectTypeString(objType));
        }*/

       /* System.out.println("===============================================");
        System.out.println("==============Class Groups ====================");
        System.out.println("===============================================");


        for (ClassGroup classGroup : this.mfilesRestTemplate.getClassGroups(token)) {

        }*/

        System.out.println("===============================================");
        System.out.println("============== Object Classes==================");
        System.out.println("===============================================");

        for (ObjectClass objectClass : this.mfilesHttpComponentsRestTemplate.getObjectClasses(token, null)) {
            System.out.println(buildObjectClassString(objectClass));
        }

        System.out.println("===============================================");
        System.out.println("============== Object Types==================");
        System.out.println("===============================================");

        for (ObjType objectType : this.mfilesHttpComponentsRestTemplate.getObjectTypes(token, null)) {
            System.out.println(buildObjectTypeString(objectType));
        }

        /*UploadInfo uploadInfo = this.mfilesRestTemplate.getUploadInfo(token, file.getBytes(), file.getOriginalFilename());

        System.out.println("UploadId: " + uploadInfo.getUploadId());
        System.out.println("Title: " + uploadInfo.getTitle());
        System.out.println("Extension: " + uploadInfo.getExtension());*/

        System.out.println("===============================================");
        System.out.println("============== Object Version==================");
        System.out.println("===============================================");
        Results<ObjectVersion> results = this.mfilesHttpComponentsRestTemplate.getAllObjects(token);
        if (results.getItems() != null && results.getItems().length > 0) {
            for (ObjectVersion objectVersion : results.getItems()) {
                System.out.println(buildObjectVersion(objectVersion));
            }
        }


        Random rand = new Random();
        int  id = rand.nextInt(1000000000) + 1;
        String applicationId = "WLA/"+ customer.getCustomerName() + "/"+ id;
        
        List<UploadInfo> uploadInfos = this.mfilesHttpComponentsRestTemplate.multipartFormDataPostTemplate(token, Constants.UPLOAD_URL,
                request.getFileMap().values(), UploadInfo.class);

        if (uploadInfos != null && uploadInfos.size() > 0) {
        	
        	// Proposal Title
            PropertyValue propValue1 = new PropertyValue();
            propValue1.setPropertyDef(0);
            propValue1.setTypedValue(new TypedValue(MFileDataType.Text.value(), "WILLS L&A Confirmation for "+customer.getCustomerName()));

            // Date of Enquiry
            PropertyValue propValue2 = new PropertyValue();
            propValue2.setPropertyDef(1047);
            propValue2.setTypedValue(new TypedValue(MFileDataType.Date.value(), TimeUtils.getTodaysDate()));
            
            // Name of enquirer
            PropertyValue propValue3 = new PropertyValue();
            propValue3.setPropertyDef(1043);
            propValue3.setTypedValue(new TypedValue(MFileDataType.Text.value(), customer.getCustomerName()));
            
            // Email
            PropertyValue propValue4 = new PropertyValue();
            propValue4.setPropertyDef(1044);
            propValue4.setTypedValue(new TypedValue(MFileDataType.Text.value(), customer.getEmail()));
            
            // Telephone
            PropertyValue propValue5 = new PropertyValue();
            propValue5.setPropertyDef(1045);
            propValue5.setTypedValue(new TypedValue(MFileDataType.Text.value(), customer.getTelephone()));
            
            // Contact Address
            PropertyValue propValue6 = new PropertyValue();
            propValue6.setPropertyDef(1046);
            propValue6.setTypedValue(new TypedValue(MFileDataType.MultiLineText.value(), customer.getContactAddress()));
            
            // Status
            PropertyValue propValue7 = new PropertyValue();
            propValue7.setPropertyDef(1050);
            propValue7.setTypedValue(new TypedValue(MFileDataType.Text.value(), "Confirmation in progress"));
            
            // Verified
            PropertyValue propValue8 = new PropertyValue();
            propValue8.setPropertyDef(1049);
            propValue8.setTypedValue(new TypedValue(MFileDataType.Boolean.value(), Boolean.FALSE));
            
            // Confirmation Id
            PropertyValue propValue10 = new PropertyValue();
            propValue10.setPropertyDef(1060);
            propValue10.setTypedValue(new TypedValue(MFileDataType.Text.value(), applicationId));
            
            Lookup lookup = new Lookup();
            lookup.setItem(10);
            
            TypedValue tv = new TypedValue();
            tv.setLookup(lookup);
            tv.setDataType(MFileDataType.Lookup.value());
            
            //For Class Type (Proposal)
            PropertyValue propValue9 = new PropertyValue();
            propValue9.setPropertyDef(100);
            //5 is Proposal (Object Class).
            propValue9.setTypedValue(tv);
            

            /*//For Class Type
            PropertyValue propertyValue3 = new PropertyValue();
            propertyValue3.setPropertyDef(100);
            //5 is Proposal (Object Class).
            propertyValue3.setTypedValue(new TypedValue(MFileDataType.Lookup.value(), new Lookup(93)));

            //Document Date
            PropertyValue propertyValue4 = new PropertyValue();
            propertyValue4.setPropertyDef(1002);
            propertyValue4.setTypedValue(new TypedValue(MFileDataType.Date.value(), new Date()));*/

            PropertyValue[] propertyValues = new PropertyValue[] {
                    propValue1, propValue2, propValue3 , propValue4, propValue5, 
                    	propValue6, propValue7, propValue8, propValue9, propValue10 };

            ObjectCreationInfo objectCreationInfo =
                    new ObjectCreationInfo(propertyValues, uploadInfos.toArray(new UploadInfo[0]));

           // objectCreationInfo.setObjectClass(15);

            ObjectVersion objectVersion = this.mfilesHttpComponentsRestTemplate
                    .createObjectInfo(token, objectCreationInfo, 0);

            if (objectVersion.isHasErrors()) {
                System.out.println("Has errors...");
            }

            System.out.println("ObjectVersion: Title -> " + objectVersion.getTitle() + ", "
            		+ "ObjectClass: " + objectVersion.getObjectClass()+", Object Id:"+objectVersion.getDisplayId()+", "
            				+ "Object Version :"+objectVersion.getObjVer().getVersion());
            
            Transactionz transactions = new Transactionz();
	        transactions.setTransactionDateTime(TimeUtils.getTodaysDate());
	        transactions.setTransactionId(applicationId);
	        transactions.setObjectVersion(objectVersion.getObjVer().getVersion());
	        transactions.setObjectId(objectVersion.getDisplayId());
	        transactions.setObjectType(0);
	        transactions.setUsername(authentication.getName());
	        
	        logTransaction(transactions);
        }

        return "redirect:confirmWILLAndLASuccess?applicationId="+applicationId;

    }
    
    @RequestMapping(value = "/confirmWILLAndLASuccess", method = RequestMethod.GET)
    public String confirmWillAndLandASuccess(HttpServletRequest request, Model model) throws Exception{
    	
    	String applicationId = ServletRequestUtils.getStringParameter(request, "applicationId");
    	
    	Customer customer = new Customer();
    	customer.setApplicationId(applicationId);
    	
    	System.err.println("Application Id "+customer.getApplicationId());
    	
    	model.addAttribute("customer", customer);
    	
    	
    	return "confirmWillLandASuccess";
    }

    private String buildObjectTypeString(ObjType objType) {
        return new StringBuilder("Object Type -> [ID: ").append(objType.getId())
                .append(", Name: ").append(objType.getName())
                .append(", Names Plural: ").append(objType.getNamePlural())
                .append("]").toString();
    }


    private String buildObjectClassString(ObjectClass objectClass) {
        return new StringBuilder("Object Class - > [ID: " + objectClass.getId())
                    .append(", Name: ").append(objectClass.getName())
                    .append(", ObjType: ").append(objectClass.getObjType()).append(" ]")
                .toString();
    }

    private String buildObjectVersion(ObjectVersion version) {
        return new StringBuilder("Object Version -> [DisplayId: " + version.getDisplayId())
                    .append(", Title: ").append(version.getTitle())
                    .append(", Version: [version ->").append(version.getObjVer().getVersion())
                .append(", ID ->").append(version.getObjVer().getId())
                .append(", type ->").append(version.getObjVer().getType()).append("] ]")
                .toString();
    }
    
    private void logTransaction(Transactionz trans){
		 
		 genericDao.persist(trans);
		 
	 }
}