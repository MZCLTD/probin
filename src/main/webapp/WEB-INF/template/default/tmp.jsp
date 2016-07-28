<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html lang="en">
	<tiles:insertAttribute name="head"/>
	<body>
 
<tiles:insertAttribute name="navbar"/>

<tiles:insertAttribute name="side-bar"/>

<tiles:insertAttribute name="content"/> <!-- /container -->
	<!-- script references -->
		<tiles:insertAttribute name="js"/>
	</body>
</html>