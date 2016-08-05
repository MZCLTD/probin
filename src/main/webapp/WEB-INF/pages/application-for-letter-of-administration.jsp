
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/includes.jsp"%>
<c:set var="context" value="${ pageContext.request.contextPath }" />
<c:url value="/logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

<tiles:insertDefinition name="temp">


<tiles:putAttribute name="navbar">

	<div class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
	    <a class="navbar-brand" href="welcome"><img src="images/probin-logo.png" alt="logo" ></a>
	    <ul class="nav navbar-nav">
	    <li><a class="active" href="${context}/account">Home</a></li>
	     <li><a href="about-probin">About Probin</a></li> 
	     <li><a href="how-it-works">How it works</a></li>
	      
	      <li><a href="faq">FAQ's</a></li>
	    
	    <li><a href="contacts">Contact Us</a></li>
	      
	    </ul>
	     <ul class="nav navbar-nav navbar-right">
	      <!-- <li><a href="signup.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
	      <li><!-- <a href="login.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a> -->
	      		<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					<a class="glyphicon glyphicon-log-out" href="javascript:formSubmit()"> Logout</a>
					
				</c:if>
	      </li>
	    </ul>
	  </div>
	</div>

</tiles:putAttribute>  

<tiles:putAttribute name="side-bar">&nbsp;</tiles:putAttribute> 

<tiles:putAttribute name="content">

<div class="container">

<div class="jumbotron">

<form:form modelAttribute="ga" class="form-horizontal" >

 <legend>Application For Grant</legend>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="nameOfOwnerOfEstate" placeholder="Name of owner of Estate" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="occupationOfTheDesased" placeholder="Occupation of the deseased" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="relationshipWithTheDeasesed" placeholder="Relationship with the deseased" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="valueOfTheProperties" placeholder="Value of properties" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="jurisdictionOfWhichHighCourt" placeholder="Jurisdiction with high court" type="text" />
      </div>
    </div>
    
   
    <%-- <div class="form-group well">
    
    	<i><p>Upload the following Items needed for your application approval</p></i>
    
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Administration Without WILL   <form:input cssClass="form-control" type="file" path="multipartFile1" /> <br/>
    	</div>
    	
    	
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Administration of bond without WILL   <form:input cssClass="form-control" type="file" path="multipartFile2" /> <br/>
    	</div>
    	
    	
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Declaration as to next of kin form  <form:input cssClass="form-control" type="file" path="multipartFile3" /> <br/>
    	</div>
    	
    	
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Inventory  <form:input cssClass="form-control" type="file" path="multipartFile4" /> <br/>
    	</div>
    	
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Schedule of debts and funeral expenses   <form:input cssClass="form-control" type="file" path="multipartFile5" /> <br/>
    	</div>
    	
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
           Form "R" (Particulars of Realty)  <form:input cssClass="form-control" type="file" path="multipartFile6" /> <br/>
    	</div> 
    
    </div> --%>
    
    
    
   <!-- <a class="popup" href="#">Try it out</a> -->
   
   
    
    <div class="col-lg-10">
        <!-- <input type="submit" name = "submit" value="Create account" class="btn btn-primary"/> -->
        <div>
        	<input class="btn btn-primary" id="start-button" type="submit" value="Continue"/>
        	<input class="btn btn-primary"  type="submit" value="Close"/>
        </div>
   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
   		
      </div> 
      
    
</form:form>

</div>

</div>

</tiles:putAttribute>

</tiles:insertDefinition>
