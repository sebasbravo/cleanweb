<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html ng-app="cleanSolutionApp" ng-controller="mainCtrl">
<head>
<meta charset="UTF-8">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="stylecss" />
</head>

<body class="hold-transition skin-green sidebar-mini">
	<tiles:insertAttribute name="header" />

	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<tiles:insertAttribute name="menu" />
	</aside>
	
	 <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>{{ titulo }} <small>{{ subtitulo}}</small>
          </h1>         
        </section>

        <!-- Main content -->
       
       <section class="content">
         	<tiles:insertAttribute name="body"/>

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

	<tiles:insertAttribute name="footer" />
	<tiles:insertAttribute name="scriptjs" />
</body>

</html>