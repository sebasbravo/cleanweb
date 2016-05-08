
<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar">
	
	<!-- Sidebar user panel -->
	<div class="user-panel">
		<div class="pull-left image">
			<img src="resources/adminLTE/dist/img/user2.jpg" class="img-circle"
				alt="User Image">
		</div>
		<div class="pull-left info">
			<p>{{user.name}}</p>
			<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
		</div>
	</div>
	
	<!-- search form -->
	<form action="#" method="get" class="sidebar-form">
		<div class="input-group">
			<input type="text" id="search" ng-model="q" class="form-control"
				placeholder="Search..."> <span class="input-group-btn">
				<button type="submit" name="search" id="search-btn"
					class="btn btn-flat">
					<i class="fa fa-search"></i>
				</button>
			</span>
		</div>
	</form>
	
	<!-- /.search form -->
	<!-- sidebar menu: : style can be found in sidebar.less -->
	<ul class="sidebar-menu">
		<li class="header">Opciones</li>
		<li ng-class="mDashboard"><a href="#"> <i class="fa fa-link"></i><span>Dashboard</span></i></a></li>
		<li><a href="#"> <i class="fa fa-link"></i><span>Admin</span></a>
				<ul class="treeview-menu">
					<li ng-class="mCity"><a href="${pageContext.request.contextPath}/organization"><i class="fa fa-link"></i> Organization</a></li>
					<li ng-class="mCountry"><a href="${pageContext.request.contextPath}/countries"><i class="fa fa-link"></i> Paises</a></li>
					
			</ul>
			</li>
			
		
	</ul>
</section>
<!-- /.sidebar -->