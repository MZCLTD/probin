<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Simple Login Form</title>
<meta charset="UTF-8" />
<meta name="Designer" content="PremiumPixels.com">
<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
<link rel="stylesheet" type="text/css" href="login_resources/login_css/reset.css">
<link rel="stylesheet" type="text/css" href="login_resources/login_css/structure.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootswatch.less" rel="stylesheet">
<link href="css/variables.less" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>

		<%-- <c:out value="${SPRING_SECURITY_LAST_EXCEPTION}" /> --%>
			

		<form name= "loginForm" class="box login" action="<c:url value='/login' />" method='POST'>
		
		<c:if test="${not empty error}">
				  <div class="alert alert-dismissible alert-danger">
					<div class="error">${error}</div>
					</div>
				</c:if>
				<c:if test="${not empty msg}">
				<div class="alert alert-dismissible alert-success">
					<div class="msg">${msg}</div>
					</div>
				</c:if>
		
			<div id="login-box">
			
			<div align="center"><img src="images/probin-logo.png" alt="logo" ></div>
		
			<fieldset class="boxBody">
			  <label>Username</label>
			  <input type="text" name="username" tabindex="1" placeholder="Enter user name" required>
			  <label><a href="#" class="rLink" tabindex="5">Forget your password?</a>Password</label>
			  <input type="password" name = "password" tabindex="2" required>
			  
			</fieldset>
			<footer>
			<input type="submit" class="btnLogin" value="Login" tabindex="6">
			  <label><input type="checkbox" tabindex="3">Keep me logged in</label>
			</footer>
			<!-- <p><a href="welcome">Continue browsing</a></p> -->
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
			
			<label><input type="checkbox" tabindex="3"><a href="welcome">Go to website</a></label>
			
		</form>

</body>
</html>