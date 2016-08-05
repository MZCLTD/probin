
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

	<p>Your application for PROBATE has been done successfully. Your application Id is <b>${ap.applicationId}</b>, 
	Please keep this number, it will be used to track the status of your application </p>
	
	<p><a href="javascript:window.print()">Print this confirmation</a></p>

</div>

</div>

</tiles:putAttribute>

</tiles:insertDefinition>
