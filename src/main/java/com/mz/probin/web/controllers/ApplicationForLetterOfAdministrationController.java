package com.mz.probin.web.controllers;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mz.probin.constants.Constants;
import com.mz.probin.dao.GenericDao;
import com.mz.probin.entities.ApplicationForLetterOfAdministration;
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
//@RequestMapping(value = "/applicationForGrant")
public class ApplicationForLetterOfAdministrationController {
	
	@Autowired
    private MFilesHttpComponentsRestTemplate mfilesHttpComponentsRestTemplate;
	
	@Autowired
	private GenericDao genericDao;
	
	@RequestMapping(value="/applicationForLetterOfAdministration", method = RequestMethod.GET)
	public String signup(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
		
		model.addAttribute("ga", ga);
		
		return "application-for-letter-of-administration";
		
}
	
	//@ResponseBody
    @RequestMapping(value = "/applicationForLetterOfAdministration", method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute ApplicationForLetterOfAdministration ga) throws Exception {
    	
    	Random rand = new Random();
    	int  id = rand.nextInt(1000);
    	
    	String titlez = id+"-"+TimeUtils.getTodaysDate();
    	
        String nameOfOwnerOfEstate = ga.getNameOfOwnerOfEstate();
        String occupationOfTheDesased = ga.getOccupationOfTheDesased();
        String relationshipWithTheDeasesed = ga.getRelationshipWithTheDeasesed();
        String valueOfTheProperties = ga.getValueOfTheProperties();
        String jurisdictionOfWhichHighCourt = ga.getJurisdictionOfWhichHighCourt();
        String title = nameOfOwnerOfEstate+"-"+titlez;
        
        // TODO Create an object in MFiles for this case
		return "redirect:uploadAdministrationWithoutWillForm?"
				+ "nooe="+nameOfOwnerOfEstate+"&ood="+occupationOfTheDesased+
				"&rwd="+relationshipWithTheDeasesed+"&vop="+valueOfTheProperties+"&johc="+jurisdictionOfWhichHighCourt+"&title="+title;
 }
    
    
    // 1 START upload administration of bond without WILL form
	@RequestMapping(value="/uploadAdministrationWithoutWillForm", method = RequestMethod.GET)
	public String uploadAdministrationWithoutWillForm(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
		
		String nameOfOwnerOfEstate = ServletRequestUtils.getStringParameter(request, "nooe");
		String occupatiuonOfDeseased = ServletRequestUtils.getStringParameter(request, "ood");
		String relationshipWithDeseased = ServletRequestUtils.getStringParameter(request, "rwd");
		String valueOfProperties = ServletRequestUtils.getStringParameter(request, "vop");
		String jurisdictionOfHighCourt = ServletRequestUtils.getStringParameter(request, "johc");
		String title = ServletRequestUtils.getStringParameter(request, "title");
		
		ga.setNameOfOwnerOfEstate(nameOfOwnerOfEstate);
		ga.setOccupationOfTheDesased(occupatiuonOfDeseased);
		ga.setRelationshipWithTheDeasesed(relationshipWithDeseased);
		ga.setValueOfTheProperties(valueOfProperties);
		ga.setJurisdictionOfWhichHighCourt(jurisdictionOfHighCourt);
        ga.setTitle(title);
        
        System.err.println("Name of owner of estate:"+ga.getNameOfOwnerOfEstate());
        System.err.println("Title:"+ga.getTitle());
		
		model.addAttribute("ga", ga);
		
		return "upload-administration-withoutwill-form";
		
    }
	
	@RequestMapping(value = "/uploadAdministrationWithoutWillForm", method = RequestMethod.POST)
    public String uploadAdministrationWithoutWillForm( @ModelAttribute ApplicationForLetterOfAdministration ga, MultipartHttpServletRequest request ) throws Exception {
		
        String nameOfOwnerOfEstate = ga.getNameOfOwnerOfEstate();
        String occupationOfTheDesased = ga.getOccupationOfTheDesased();
        String relationshipWithTheDeasesed = ga.getRelationshipWithTheDeasesed();
        String valueOfTheProperties = ga.getValueOfTheProperties();
        String jurisdictionOfWhichHighCourt = ga.getJurisdictionOfWhichHighCourt();
        String title = ga.getTitle();
        
        System.err.println("Name of owner of estate:"+ga.getNameOfOwnerOfEstate());
        System.err.println("Title:"+ga.getTitle());
        
        uploadfile( ga, request );
        
        
		return "redirect:uploadDeclarationAsToNextOfKinForm?"
				+ "nooe="+nameOfOwnerOfEstate+"&ood="+occupationOfTheDesased+
				"&rwd="+relationshipWithTheDeasesed+"&vop="+valueOfTheProperties+"&johc="+jurisdictionOfWhichHighCourt+"&title="+title;
       }
	
	// END upload administration without WILL form 
	
	
	// 2 START UPLOAD DECLARATION AS TO NEXT OF KIN FORM
	@RequestMapping(value="/uploadDeclarationAsToNextOfKinForm", method = RequestMethod.GET)
	public String uploadDeclarationAsToNextOfKinForm(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
		
		String nameOfOwnerOfEstate = ServletRequestUtils.getStringParameter(request, "nooe");
		String occupatiuonOfDeseased = ServletRequestUtils.getStringParameter(request, "ood");
		String relationshipWithDeseased = ServletRequestUtils.getStringParameter(request, "rwd");
		String valueOfProperties = ServletRequestUtils.getStringParameter(request, "vop");
		String jurisdictionOfHighCourt = ServletRequestUtils.getStringParameter(request, "johc");
		String title = ServletRequestUtils.getStringParameter(request, "title");
		
		ga.setNameOfOwnerOfEstate(nameOfOwnerOfEstate);
		ga.setOccupationOfTheDesased(occupatiuonOfDeseased);
		ga.setRelationshipWithTheDeasesed(relationshipWithDeseased);
		ga.setValueOfTheProperties(valueOfProperties);
		ga.setJurisdictionOfWhichHighCourt(jurisdictionOfHighCourt);
        ga.setTitle(title);
		
		model.addAttribute("ga", ga);
		
		return "uploadDeclarationAsToNextOfKinForm";
		
    }
	
	
	@RequestMapping(value = "/uploadDeclarationAsToNextOfKinForm", method = RequestMethod.POST)
    public String uploadDeclarationAsToNextOfKinForm( @ModelAttribute ApplicationForLetterOfAdministration ga, MultipartHttpServletRequest request ) throws Exception {
		
        String nameOfOwnerOfEstate = ga.getNameOfOwnerOfEstate();
        String occupationOfTheDesased = ga.getOccupationOfTheDesased();
        String relationshipWithTheDeasesed = ga.getRelationshipWithTheDeasesed();
        String valueOfTheProperties = ga.getValueOfTheProperties();
        String jurisdictionOfWhichHighCourt = ga.getJurisdictionOfWhichHighCourt();
        String title = ga.getTitle();
        
        System.err.println("Name of owner of estate:"+ga.getNameOfOwnerOfEstate());
        System.err.println("Title:"+ga.getTitle());
        
        uploadfile( ga, request );
        
        
		return "redirect:uploadInventoryForm?"
				+ "nooe="+nameOfOwnerOfEstate+"&ood="+occupationOfTheDesased+
				"&rwd="+relationshipWithTheDeasesed+"&vop="+valueOfTheProperties+"&johc="+jurisdictionOfWhichHighCourt+"&title="+title;
       }
	// END UPLOAD DECLARATION AS TO NEXT OF KIN FORM
	
	
	
	// 3 START UPLOAD INVENTORY FORM
		@RequestMapping(value="/uploadInventoryForm", method = RequestMethod.GET)
		public String uploadInventoryForm(Model model, HttpServletRequest request,
				HttpServletResponse response) throws Exception{
			
			ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
			
			String nameOfOwnerOfEstate = ServletRequestUtils.getStringParameter(request, "nooe");
			String occupatiuonOfDeseased = ServletRequestUtils.getStringParameter(request, "ood");
			String relationshipWithDeseased = ServletRequestUtils.getStringParameter(request, "rwd");
			String valueOfProperties = ServletRequestUtils.getStringParameter(request, "vop");
			String jurisdictionOfHighCourt = ServletRequestUtils.getStringParameter(request, "johc");
			String title = ServletRequestUtils.getStringParameter(request, "title");
			
			ga.setNameOfOwnerOfEstate(nameOfOwnerOfEstate);
			ga.setOccupationOfTheDesased(occupatiuonOfDeseased);
			ga.setRelationshipWithTheDeasesed(relationshipWithDeseased);
			ga.setValueOfTheProperties(valueOfProperties);
			ga.setJurisdictionOfWhichHighCourt(jurisdictionOfHighCourt);
	        ga.setTitle(title);
	        
			
			model.addAttribute("ga", ga);
			
			return "uploadInventoryForm";
			
	    }
		
		
		@RequestMapping(value = "/uploadInventoryForm", method = RequestMethod.POST)
	    public String uploadInventoryForm( @ModelAttribute ApplicationForLetterOfAdministration ga, MultipartHttpServletRequest request ) throws Exception {
			
	        String nameOfOwnerOfEstate = ga.getNameOfOwnerOfEstate();
	        String occupationOfTheDesased = ga.getOccupationOfTheDesased();
	        String relationshipWithTheDeasesed = ga.getRelationshipWithTheDeasesed();
	        String valueOfTheProperties = ga.getValueOfTheProperties();
	        String jurisdictionOfWhichHighCourt = ga.getJurisdictionOfWhichHighCourt();
	        String title = ga.getTitle();
	        
	        
	        uploadfile( ga, request );
	        
	        
			return "redirect:uploadScheduleOfDebtAndFuneralExpensesForm?"
					+ "nooe="+nameOfOwnerOfEstate+"&ood="+occupationOfTheDesased+
					"&rwd="+relationshipWithTheDeasesed+"&vop="+valueOfTheProperties+"&johc="+jurisdictionOfWhichHighCourt+"&title="+title;
	       }
		// END UPLOAD INVENTORY FORM
		
		// 4 START SCHEDULE OF DEBT & FUNERAL EXPENSES FORM
				@RequestMapping(value="/uploadScheduleOfDebtAndFuneralExpensesForm", method = RequestMethod.GET)
				public String uploadSchedulOfDebtAndFuneralExpensesForm(Model model, HttpServletRequest request,
						HttpServletResponse response) throws Exception{
					
					ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
					
					String nameOfOwnerOfEstate = ServletRequestUtils.getStringParameter(request, "nooe");
					String occupatiuonOfDeseased = ServletRequestUtils.getStringParameter(request, "ood");
					String relationshipWithDeseased = ServletRequestUtils.getStringParameter(request, "rwd");
					String valueOfProperties = ServletRequestUtils.getStringParameter(request, "vop");
					String jurisdictionOfHighCourt = ServletRequestUtils.getStringParameter(request, "johc");
					String title = ServletRequestUtils.getStringParameter(request, "title");
					
					ga.setNameOfOwnerOfEstate(nameOfOwnerOfEstate);
					ga.setOccupationOfTheDesased(occupatiuonOfDeseased);
					ga.setRelationshipWithTheDeasesed(relationshipWithDeseased);
					ga.setValueOfTheProperties(valueOfProperties);
					ga.setJurisdictionOfWhichHighCourt(jurisdictionOfHighCourt);
			        ga.setTitle(title);
			        
					
					model.addAttribute("ga", ga);
					
					return "uploadScheduleOfDebtAndFuneralExpensesForm";
					
			    }
				
				
				@RequestMapping(value = "/uploadScheduleOfDebtAndFuneralExpensesForm", method = RequestMethod.POST)
			    public String uploadSchedulOfDebtAndFuneralExpensesForm( @ModelAttribute ApplicationForLetterOfAdministration ga, MultipartHttpServletRequest request ) throws Exception {
					
			        String nameOfOwnerOfEstate = ga.getNameOfOwnerOfEstate();
			        String occupationOfTheDesased = ga.getOccupationOfTheDesased();
			        String relationshipWithTheDeasesed = ga.getRelationshipWithTheDeasesed();
			        String valueOfTheProperties = ga.getValueOfTheProperties();
			        String jurisdictionOfWhichHighCourt = ga.getJurisdictionOfWhichHighCourt();
			        String title = ga.getTitle();
			        
			        
			        uploadfile( ga, request );
			        
			        
					return "redirect:formR?"
							+ "nooe="+nameOfOwnerOfEstate+"&ood="+occupationOfTheDesased+
							"&rwd="+relationshipWithTheDeasesed+"&vop="+valueOfTheProperties+"&johc="+jurisdictionOfWhichHighCourt+"&title="+title;
			       }
				// END SCHEDULE OF DEBT & FUNERAL EXPENSES FORM
				
				
				// 5 START FORM R
				@RequestMapping(value="/formR", method = RequestMethod.GET)
				public String uploadFormR(Model model, HttpServletRequest request,
						HttpServletResponse response) throws Exception{
					
					ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
					
					String nameOfOwnerOfEstate = ServletRequestUtils.getStringParameter(request, "nooe");
					String occupatiuonOfDeseased = ServletRequestUtils.getStringParameter(request, "ood");
					String relationshipWithDeseased = ServletRequestUtils.getStringParameter(request, "rwd");
					String valueOfProperties = ServletRequestUtils.getStringParameter(request, "vop");
					String jurisdictionOfHighCourt = ServletRequestUtils.getStringParameter(request, "johc");
					String title = ServletRequestUtils.getStringParameter(request, "title");
					
					ga.setNameOfOwnerOfEstate(nameOfOwnerOfEstate);
					ga.setOccupationOfTheDesased(occupatiuonOfDeseased);
					ga.setRelationshipWithTheDeasesed(relationshipWithDeseased);
					ga.setValueOfTheProperties(valueOfProperties);
					ga.setJurisdictionOfWhichHighCourt(jurisdictionOfHighCourt);
			        ga.setTitle(title);
			        
					
					model.addAttribute("ga", ga);
					
					return "formR";
					
			    }
				
				
				@RequestMapping(value = "/formR", method = RequestMethod.POST)
			    public String uploadFormR( @ModelAttribute ApplicationForLetterOfAdministration ga, Authentication authentication, MultipartHttpServletRequest request ) throws Exception {
					
					System.err.println("Title at form R: "+ga.getTitle());
					
					uploadfile( ga, request );
					
					ga.setTitle(ga.getTitle());
			        ga.setStatus("APPLICATION SUBMITTED");
			        ga.setApplicationId(ga.getTitle());
			        ga.setDateOfApplication(TimeUtils.getTodaysDate());
			        ga.setFullnameOfApplicant(ga.getNameOfOwnerOfEstate());
			        
			        ObjectVersion objectVersion = createIndexObjectForGrantApplication( ga );
			        
			        /*System.err.println("Object Class: "+objectVersion.getObjectClass());
			        System.err.println("Object Id/DisplayId used: "+objectVersion.getDisplayId());
			        System.err.println("Object version: "+objectVersion.getObjVer().getVersion());*/
			        
			        Transactionz transactions = new Transactionz();
			        transactions.setTransactionDateTime(TimeUtils.getTodaysDate());
			        transactions.setTransactionId(ga.getApplicationId());
			        transactions.setUsername(authentication.getName());
			        transactions.setObjectId(objectVersion.getDisplayId());
			        transactions.setObjectVersion(objectVersion.getObjVer().getVersion());
			       
			        logTransaction(transactions);
					
					return "redirect:completeApplicationForGrant?title="+ga.getTitle()
							+"&status="+ga.getStatus()+"&appId="+ga.getApplicationId()
							+"&dateOfApp="+ga.getDateOfApplication()+"&fullNameOfApplicant="
							+ga.getFullnameOfApplicant();
					
			       }
				// END FORM R
				
				@RequestMapping(value="/completeApplicationForGrant", method = RequestMethod.GET)
				public String loadGrantApplicationComplete(HttpServletRequest request, Model model) throws Exception {
					
					String title = ServletRequestUtils.getStringParameter(request, "title");
					String status = ServletRequestUtils.getStringParameter(request, "status");
					String applicationId = ServletRequestUtils.getStringParameter(request, "appId");
					String dateOfApplication = ServletRequestUtils.getStringParameter(request, "dateOfApp");
					String fullnameofApplicant = ServletRequestUtils.getStringParameter(request, "fullNameOfApplicant");
					
					ApplicationForLetterOfAdministration ga = new ApplicationForLetterOfAdministration();
					ga.setTitle(title);
					ga.setStatus(status);
					ga.setApplicationId(applicationId);
					ga.setDateOfApplication(dateOfApplication);
					ga.setFullnameOfApplicant(fullnameofApplicant);
					
					model.addAttribute("ga", ga);
					
					return "grantApplicationComplete";
				}
	 
	 
	 
	 private void uploadfile(ApplicationForLetterOfAdministration ga, MultipartHttpServletRequest request) throws Exception{
		 
		 String token = AuthenticationUtils.getAuthenticationToken();
	        
	        List<UploadInfo> uploadInfos = this.mfilesHttpComponentsRestTemplate.multipartFormDataPostTemplate(token, Constants.UPLOAD_URL,
	        		request.getFileMap().values(), UploadInfo.class);
		 
		 if(uploadInfos != null && uploadInfos.size() > 0 ){
	        	System.out.println("Upload info size :"+uploadInfos.size());
	        		
	        		PropertyValue propValue1 = new PropertyValue();
	                propValue1.setPropertyDef(0);
	                propValue1.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getTitle()));
	                
	                PropertyValue propValue2 = new PropertyValue();
	                propValue2.setPropertyDef(1039);
	                propValue2.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getOccupationOfTheDesased()));
	                
	                PropertyValue propValue3 = new PropertyValue();
	                propValue3.setPropertyDef(1038);
	                propValue3.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getRelationshipWithTheDeasesed())); // Relationship with deseased
	                
	                PropertyValue propValue4 = new PropertyValue();
	                propValue4.setPropertyDef(1052);
	                propValue4.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getNameOfOwnerOfEstate())); // name of estate
	                
	                PropertyValue propValue5 = new PropertyValue();
	                propValue5.setPropertyDef(1040);
	                propValue5.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getValueOfTheProperties()));
	                
	                PropertyValue propValue6 = new PropertyValue();
	                propValue6.setPropertyDef(1053);
	                propValue6.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getJurisdictionOfWhichHighCourt()));
	                
	                PropertyValue propValue7 = new PropertyValue();
	                propValue7.setPropertyDef(1054);
	                propValue7.setTypedValue(new TypedValue(MFileDataType.Date.value(), TimeUtils.getTodaysDate()));
	                
	                Lookup lookup = new Lookup();
	                lookup.setItem(9);
	                
	                TypedValue tv = new TypedValue();
	                tv.setLookup(lookup);
	                tv.setDataType(MFileDataType.Lookup.value());
	                
	                //For Class Type (Proposal)
	                PropertyValue propValue8 = new PropertyValue();
	                propValue8.setPropertyDef(100);
	                //5 is Proposal (Object Class).
	                propValue8.setTypedValue(tv);
	                
	                PropertyValue[] propertyValues = new PropertyValue[] {
	                        propValue1, propValue2, propValue3 , propValue4, propValue5, propValue6, propValue7, propValue8 };
	                
	                ObjectCreationInfo objectCreationInfo =
	                        new ObjectCreationInfo(propertyValues, uploadInfos.toArray(new UploadInfo[0]));

	               //objectCreationInfo.setObjectClass(15);

	                ObjectVersion objectVersion = this.mfilesHttpComponentsRestTemplate
	                        .createObjectInfo(token, objectCreationInfo, 0);

	                if (objectVersion.isHasErrors()) {
	                    System.out.println("Has errors...");
	                }

	                System.out.println("ObjectVersion: Title -> " + objectVersion.getTitle() + ", ObjectClass: " + objectVersion.getObjectClass());
	        	}
     	
     }
	 
	 
			 public ObjectVersion createIndexObjectForGrantApplication( ApplicationForLetterOfAdministration ga ) throws Exception{
				 
				 String token = AuthenticationUtils.getAuthenticationToken();
				 
				 PropertyValue propValue1 = new PropertyValue();
	             propValue1.setPropertyDef(0);
	             propValue1.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getTitle()));
	             
	             PropertyValue propValue2 = new PropertyValue();
	             propValue2.setPropertyDef(1050);
	             propValue2.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getStatus()));
	             
	             PropertyValue propValue3 = new PropertyValue();
	             propValue3.setPropertyDef(1051);
	             propValue3.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getApplicationId()));
	             
	             PropertyValue propValue4 = new PropertyValue();
	             propValue4.setPropertyDef(1058);
	             propValue4.setTypedValue(new TypedValue(MFileDataType.Date.value(), ga.getDateOfApplication()));
	             
	             PropertyValue propValue5 = new PropertyValue();
	             propValue5.setPropertyDef(1057);
	             propValue5.setTypedValue(new TypedValue(MFileDataType.Text.value(), ga.getFullnameOfApplicant()));
	             
	             Lookup lookup = new Lookup();
	                lookup.setItem(11);
	                
	                TypedValue tv = new TypedValue();
	                tv.setLookup(lookup);
	                tv.setDataType(MFileDataType.Lookup.value());
	                
	                //For Class Type (Proposal)
	                PropertyValue propValue6 = new PropertyValue();
	                propValue6.setPropertyDef(100);
	                //5 is Proposal (Object Class).
	                propValue6.setTypedValue(tv);
	                
	                PropertyValue[] propertyValues = new PropertyValue[] { propValue1, propValue2, propValue3 , propValue4, propValue5, propValue6 };
	                
	                ObjectCreationInfo objectCreationInfo = new ObjectCreationInfo(propertyValues );
	                
	                ObjectVersion objectVersion = this.mfilesHttpComponentsRestTemplate
	                        .createObjectInfo(token, objectCreationInfo, 106);
	                

	                if (objectVersion.isHasErrors()) {
	                    System.out.println("Has errors...");
	                }

	                System.err.println("ObjectVersion: Title -> " + objectVersion.getTitle() + ", ObjectClass: " + objectVersion.getObjectClass());
				 
	                return objectVersion;
			 }
			 
			 
			 private void logTransaction(Transactionz trans){
				 
				 genericDao.persist(trans);
				 
			 }
	 
	 
	 
	 
	 
	 
}
