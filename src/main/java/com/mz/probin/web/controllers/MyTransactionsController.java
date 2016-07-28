package com.mz.probin.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mz.probin.dao.GenericDao;
import com.mz.probin.entities.Transactionz;
import com.mz.probin.mfiles.classes.ObjectWorkflowState;
import com.mz.probin.mfiles.web.rest.MFilesHttpComponentsRestTemplate;
import com.mz.probin.util.AuthenticationUtils;

@Controller
public class MyTransactionsController {
	
	@Autowired
	private GenericDao genericDao;
	
	@Autowired
    private MFilesHttpComponentsRestTemplate mfilesHttpComponentsRestTemplate;
	
	@RequestMapping( value="/myTransactions", method = RequestMethod.GET)
	public String loadMyTransactions( Model model, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		
		/*String token = AuthenticationUtils.getAuthenticationToken();
		
		String objectId = String.valueOf(362);
		
		ObjectWorkflowState wfs = mfilesHttpComponentsRestTemplate.getObjectWorkflow(token, objectId, 2);
		
		System.err.println("WORKFLOW :"+wfs.getWorkflow());
		System.err.println("WORKFLOW STATE :"+wfs.getWorkflowName());*/
		
		
		String username = ServletRequestUtils.getStringParameter(request, "username");
		
		List<Transactionz> transactionsList = genericDao.getEntityListByStringValue("username", username, Transactionz.class);
		
		model.addAttribute("transactionsList", transactionsList);
		
		System.out.println("Transactions List :"+transactionsList.size());
		
		
		return "myTransactions";
	}
	
	@RequestMapping( value="/getStatus", method = RequestMethod.GET )
	public String getWorkflowState(  Model model, HttpServletRequest request, HttpServletResponse response ) throws Exception{
		
		String transactionId = ServletRequestUtils.getStringParameter(request, "transId");
		Transactionz transactions = genericDao.getEntityListByStringValue("transactionId", transactionId, Transactionz.class).get(0);
		
		ObjectWorkflowState objectworkflowState = new ObjectWorkflowState();
		
		int objectType = transactions.getObjectType();
		int objectVersion = transactions.getObjectVersion();
		String objectId = transactions.getObjectId();
		
		System.err.println("Object Id: "+transactions.getObjectId());
		System.err.println("Object Version: "+transactions.getObjectVersion());
		System.err.println("Object Type: "+transactions.getObjectType());
		
		String token = AuthenticationUtils.getAuthenticationToken();
		objectworkflowState = mfilesHttpComponentsRestTemplate.getObjectWorkflow(token, objectType, objectId, objectVersion);
		
		System.err.println("----------------------------------------------------------");
		System.err.println("-------------------Workflow : "+objectworkflowState.getWorkflow());
		System.err.println("-------------------Workflow name : "+objectworkflowState.getWorkflowName());
		System.err.println("----------------------------------------------------------");
		
		model.addAttribute("objectWorkflowState", objectworkflowState);
		
		
		return "workflowState";
	}

}
