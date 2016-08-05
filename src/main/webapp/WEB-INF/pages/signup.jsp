
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/includes.jsp"%>

<tiles:insertDefinition name="temp">

<tiles:putAttribute name="side-bar">&nbsp;</tiles:putAttribute>

<tiles:putAttribute name="content">

<div class="container jumbotron">

<form:form modelAttribute="au" class="form-horizontal">

 <legend>Create your profile</legend>
 
 
 	<c:if test="${ au.message != null }">
 	<div class="alert alert-dismissible alert-danger">
 		${ au.message }
 		</div>
 	</c:if>
 
 	<div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Email</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="username" placeholder="Email" type="text" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Password</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="password"  placeholder="Enter Your Password" type="password" />
      </div>
    </div>
    
    <div class="form-group">
     <label for="inputEmail" class="col-lg-2 control-label">Confirm Password</label>
      <div class="col-lg-10">
        <form:input class="form-control" path="rePassword" placeholder="Confirm Password" type="password" />
      </div>
    </div>
    
    <div class="form-group">
    <label for="inputEmail" class="col-lg-2 control-label">&nbsp;&nbsp;</label>
    	<div class="col-lg-10">
        <input type="submit" name = "submit" value="Create account" class="btn btn-primary"/>
        <!-- <input type="submit" name = "submit" value="Close" class="btn btn-primary"/> -->
   		</div>
   		</div>
    
</form:form>
</div>

</tiles:putAttribute>

</tiles:insertDefinition>

