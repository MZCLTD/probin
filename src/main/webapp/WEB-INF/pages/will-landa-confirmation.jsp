
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
	    <li><a href="${context}/account">Home</a></li>
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


<form:form modelAttribute="customer" class="form-horizontal" enctype="multipart/form-data">
  <fieldset>
    <legend>Confirm WILLS & Letters of Administration</legend>
    <div class="form-group">
      <!-- <label class="col-lg-2 control-label">Customer Name</label> -->
      <div class="col-lg-10">
        <form:input class="form-control" path="customerName" placeholder="Customer Name" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <!-- <label class="col-lg-2 control-label">Email Address</label> -->
      <div class="col-lg-10">
        <form:input class="form-control" path="email" placeholder="Email Address" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <!-- <label class="col-lg-2 control-label">Telephone</label> -->
      <div class="col-lg-10">
        <form:input class="form-control" path="telephone" placeholder="Telephone" type="text" />
      </div>
    </div>
    
    <div class="form-group">
      <!-- <label class="col-lg-2 control-label">Contact Address</label> -->
      <div class="col-lg-10">
        <form:textarea cssClass="form-control" path="contactAddress" placeholder="Contact Address" type="text" />
      </div>
    </div>
    
    <div class="form-group">
    
    	<div class="col-lg-10">
    		<!-- <label class="col-lg-8 control-label">Upload WILL / L&A</label> -->
            Upload Scanned WILL / Letter of administration &nbsp;  <form:input cssClass="form-control" type="file" path="scannedWillillLAndAMpf" />
    	</div>
    
    </div>
    
    <p>
    <button type="submit" Class="btn btn-primary ">Upload Your WILL / L&A for confirmation</button>
    <a Class="btn btn-primary " href="welcome">Cancel</a>
    </p>
    <!-- <div class="form-group">
      <div class="col-lg-2 control-label">
        <button type="reset" class="btn btn-default">Cancel</button> 
        <button type="submit" class="btn btn-default ">Submit</button>
      </div>
    </div> -->
  </fieldset>
</form:form>
  
</div>


</div>

</tiles:putAttribute>

</tiles:insertDefinition>

