<ol class="breadcrumb animated fadeIn fast">
	<li><a href="${pageContext.request.contextPath}/"><i
			class="fa fa-dashboard"></i> Dashboard</a></li>
	<li class="active">Organization</li>
</ol>


<div class="row" ng-app="cleanSolutionApp" ng-controller="organizationCtrl">
	<div class="col-md-12">
		<div class="box">

			<div class="box-header with-border">
				<h3 class="box-title">Organization</h3>

				<div class="box-tools" align="right">
					<div class="input-group" style="width: 150px;">
						<a ng-click="showModal()" class="btn btn-primary"><i class="fa fa-plus"></i>
							Organization</a>
					</div>
				</div>

			</div>
			<!-- /.box-header -->

			<div class="box-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Nis</th>
							<th>Tx Fed</th>
							<th>Tx Prov</th>
							<th>Phone</th>
							<th>Cel</th>
							<th>Website</th>
							<th>Address</th>
							<th>status</th>
							
						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="organization in organizations.allOrganizations | filter:q | itemsPerPage: 10"
							current-page="currentPage">

							<td>{{organization.name}}</td>
							<td>{{organization.nis}}</td>
							<td>{{organization.phone}}</td>
							<td>{{organization.cel}}</td>
							<td>{{organization.website}}</td>
							<td>{{organization.address}}</td>
							<td>{{organization.status}}</td>

							<td><a ng-click="showModal()" href=""><i class="fa fa-edit"></i></a></td>
						</tr>
					</tbody>
				</table>
				<dir-pagination-controls max-size="5" direction-links="true"
					boundary-links="true"
					template-url="resources/angularjs/templates/dirPagination.tpl.html"
					align="center"> </dir-pagination-controls>
			</div>
		</div>

	</div>
</div>

<div ng-include="'resources/angularjs/templates/modalOrganization.jsp'">
</div>


