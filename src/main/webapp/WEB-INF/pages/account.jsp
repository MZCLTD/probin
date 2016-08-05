
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

<%-- <tiles:putAttribute name="side-bar">&nbsp;</tiles:putAttribute>  --%>

<tiles:putAttribute name="content">

<div class="container">

  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    

  <div class="jumbotron center">
  <p><b>What would you like to do?</b></p>
  <p><a href="applicationForLetterOfAdministration"><span class="label label-info">Application for letter of administration</span></a> </p>
  <p><a href="applicationForProbate"> <span class="label label-info">Request for a probate</span></a> </p>
   <p><a href="document-upload"><span class="label label-info">Confirm a probate / Letter of admin</span></a></p>
  
  <h2>Wills, Probate and Inheritance !</h2>
  
  <blockquote class="blockquote">
  <p>When someone dies, you'll need to get the legal right to deal with their property, money and possessions (their 'estate').</p>
  
  <p> With this PORTAL, you will be able to apply for your <i><b>letter of administration</b>, <b>Probate</b> <b>and their confirmations</b> </i></p>
  <!-- <p><a class="btn btn-primary btn-lg">Learn how to</a></p> -->
  <!-- <small>Someone famous in <cite title="Source Title">Source Title</cite></small> -->
</blockquote>
  

</div>
  
</div>

</div>

</tiles:putAttribute>

</tiles:insertDefinition>

