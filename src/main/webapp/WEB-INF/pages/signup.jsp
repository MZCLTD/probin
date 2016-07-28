
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/includes.jsp"%>

<tiles:insertDefinition name="temp">

<tiles:putAttribute name="side-bar">&nbsp;</tiles:putAttribute>

<tiles:putAttribute name="content">

<div class="container jumbotron">

<form:form modelAttribute="ua" class="form-horizontal">

 <legend>Create your profile</legend>
   
  <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Title</label>
      <div class="col-lg-10">
        <form:select path="titleId">
			<form:option value="-1" label="What are you addressed as? Please select" /> 
			<form:option value="1" label="Mr" />
			<form:option value="2" label="Mrs" />
				<%-- <c:forEach items="${titleList}" var = "item"> 
            <form:option value="${item.id}" >${item.title}</form:option> 
                </c:forEach> --%>
		</form:select>

      </div>
    </div> 
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">First name</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="firstName" placeholder="First name" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Gender</label>
      <div class="col-lg-10">
        <form:select path="genderId">
			<form:option value="-1" label="Male or Female? Please select" />
			<form:option value="1" label="Male" /> 
			<form:option value="2" label="Female" /> 
				<%-- <c:forEach items="${genderList}" var = "item"> 
            		<form:option value="${item.id}" >${item.gender}</form:option> 
                </c:forEach> --%>
		</form:select>
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Email</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="email" placeholder="Email" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Telephone Number</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="telephoneNumber" placeholder="Telephone Number" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Contact Address</label>
      <div class="col-lg-10">
        <form:textarea class="form-control" path="contactAddress" placeholder="Contact Address" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Username</label>
      <div class="col-lg-10">
        <form:textarea class="form-control" path="username" placeholder="Username" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Password</label>
      <div class="col-lg-10">
        <form:password class="form-control" path="password" placeholder="Password"  />
      </div>
    </div>
    
    <div class="col-lg-10">
        <input type="submit" name = "submit" value="Create account" class="btn btn-primary"/>
   		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
      </div>  
    
</form:form>


</div>

</tiles:putAttribute>

</tiles:insertDefinition>

