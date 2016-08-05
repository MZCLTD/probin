<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/includes.jsp"%>

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
	    <a class="navbar-brand" href="#">Probin</a>
	    <ul class="nav navbar-nav">
	      
	    </ul>
	     <ul class="nav navbar-nav navbar-right">
	     
	      <li>
	      		<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					<a class="glyphicon glyphicon-log-out" href="javascript:formSubmit()"> Logout</a>
					
				</c:if>
	      </li>
	    </ul>
	  </div>
	</div>

</tiles:putAttribute> 

<tiles:putAttribute name="navbar">

	<div class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
	    <a class="navbar-brand" href="#">Probin</a>
	    <ul class="nav navbar-nav">
	      		<c:if test="${pageContext.request.userPrincipal.name != null}">
					
					<a class="glyphicon glyphicon-log-in" href="javascript:formSubmit()"> Logout</a>
					
				</c:if>
	      </li>
	    </ul>
	  </div>
	</div>

</tiles:putAttribute> 

<tiles:putAttribute name="side-bar">&nbsp;</tiles:putAttribute> 

<tiles:putAttribute name="content">

<div class="container">

<form:form modelAttribute="ga" class="form-horizontal">

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
    
    <div class="form-group">
      <div class="col-lg-10">
        <form:input class="form-control" path="datez" placeholder="Date" type="text" />
      </div>
    </div>
    
   <!-- <a class="popup" href="#">Try it out</a> -->
   
   
    
    <div class="col-lg-10">
        <!-- <input type="submit" name = "submit" value="Create account" class="btn btn-primary"/> -->
        <div>
        	<input class="btn btn-primary" id="start-button" type="button" value="Apply"/>
        	<input class="btn btn-primary"  type="submit" value="Close"/>
        </div>
   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
   		<!-- <span id="status">Not connected</span> -->
      </div> 
      
    
</form:form>


</div>

</tiles:putAttribute>

</tiles:insertDefinition>


