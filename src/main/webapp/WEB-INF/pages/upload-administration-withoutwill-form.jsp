
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

<form:form modelAttribute="ga" class="form-horizontal" enctype="multipart/form-data">

 <legend>(1) UPLOAD ADMINISTRATION OF BOND WITHOUT WILL FORM</legend>
    
    <div class="form-group well">
    
   <%--  <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="title" placeholder="Application Without WILL Form" type="hidden" />
      </div>
    </div> --%>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="nameOfOwnerOfEstate" placeholder="Name of owner of Estate" type="hidden" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="occupationOfTheDesased" placeholder="Occupation of the deseased" type="hidden" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="relationshipWithTheDeasesed" placeholder="Relationship with the deseased" type="hidden" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="valueOfTheProperties" placeholder="Value of properties" type="hidden" />
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="jurisdictionOfWhichHighCourt" placeholder="Jurisdiction with high court" type="hidden" />
      </div>
    </div>
    
    	<i><p>UPLOAD ADMINISTRATION OF BOND WITHOUT WILL FORM</p></i>
    
    	<div class="col-lg-10">
           ADMINISTRATION OF BOND WITHOUT WILL FORM  <form:input cssClass="form-control" type="file" path="multipartFile" /> <br/>
    	</div>
    	
    </div>
    
    <div class="col-lg-10">
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
