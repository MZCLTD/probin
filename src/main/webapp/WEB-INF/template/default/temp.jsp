<!DOCTYPE html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html lang="en">

<tiles:insertAttribute name="head"/>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <tiles:insertAttribute name="nav-bar-header"/>
            <!-- /.navbar-header -->

            <tiles:insertAttribute name="nav-bar-top-links"/>
            <!-- /.navbar-top-links -->

            <tiles:insertAttribute name="side-bar"/>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <tiles:insertAttribute name="content"/>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <tiles:insertAttribute name="js"/>

</body>

</html>
