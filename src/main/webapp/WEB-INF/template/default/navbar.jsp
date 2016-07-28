<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/includes/includes.jsp"%>
<c:set var="context" value="${ pageContext.request.contextPath }" />
<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <a class="navbar-brand" href="${context}/welcome"><img src="images/probin-logo.png" alt="logo" ></a>
    <ul class="nav navbar-nav">
    <li><a href="${context}/account">Home</a></li>
      <li><a href="about-probin">About Probin</a></li>
      <li><a href="how-it-works">How it works</a></li>
      <li><a href="account">My Account</a></li>
      
      <li><a href="faq">FAQ's</a></li>
    
    <li><a href="contacts">Contact Us</a></li>
      
    </ul>
     <ul class="nav navbar-nav navbar-right">
      <li><a href="signup.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <!-- <li><a href="login.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
    </ul>
  </div>
</div>