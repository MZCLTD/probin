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
   		<span id="status">Not connected</span>
      </div> 
      
    
</form:form>


</div>

</tiles:putAttribute>

</tiles:insertDefinition>


<script>
	
   // TODO: configure these to match your setup.
				// NOTE! In real life applications, always use HTTPS to avoid sending clear-text credentials accross the network!
				//var host = 'http://192.168.2.135/REST';
				var vault = '{DC7C04CA-C4AE-4256-9295-C8094D063EB8}';
				var username = 'JohnS';
				var password = 'password';

				// Register the connect() function below as click handler for the Start button.
				$('#start-button').click(connect);
	
				// Connects (authenticates) to a vault with the username & password given by the user via the HTML
				// input fields.
				// Connects (authenticates) to a vault with the username & password given by the user via the HTML
				// input fields.
				function connect() {
					// E.g. "http://localhost/M-Files/REST/server/authenticationtokens"
					$.post('http://192.168.2.135/REST/server/authenticationtokens.aspx', JSON.stringify({ 
						//Username: $('#username').val(),				// From user input, e.g. "Test1"
						//Password: $('#password').val(),				// From user input, e.g. "Test1"
						Username: username,				// From user input, e.g. "Test1"
						Password: password,				// From user input, e.g. "Test1"
						VaultGuid: vault 
					}))
					.done(processToken)		// All good, process the authentication token
					.fail(processError);	// Error occurred, process the error
				}
				
				function processToken(token) {
				alert("processing token")
					// AuthenticationUtils token received successfully, store it for later use (the
					// header will be added to all subsequent REST calls made with jQuery).
					$.ajaxSetup({ headers: { 'X-Authentication' : token.Value } });
					
					// Update UI to show correct status:
					$('#status').text('Connected, token received');
					
					// Continue by fetching e.g. the files in the specified document (notice how the
					// file ID will be different from document ID):
					var createObject = function () {

			    // Post the object data.
			    $.ajax({
			        url: "http://192.168.2.135/REST/objects/0",
			        type: "POST",
			        dataType: "json",
			        contentType: "application/json",
			        data: JSON.stringify({
			            PropertyValues: [{
			                    // Document name
			                    PropertyDef: 0,
			                    TypedValue: { DataType: 1, Value: "Invoice" }
			                }, {
			                    // "Single File" property
			                    PropertyDef: 22,
			                    TypedValue: { DataType: 8, Value: false }
			                }, {
			                    // Class.
			                    PropertyDef: 100,
			                    TypedValue: { DataType: 9, Lookup: { Item: 0 } }
			                }],
			            Files: []
			        }),
			        success: processDocument
			    });
};
				}
				
				function processError(err) {
				alert("processing error token")
					$('#status').text('Error occurred, please see the browser\'s developer console for details!');
					console.log('jQuery error object:');	
					console.log(err);
				}
     
 
</script>