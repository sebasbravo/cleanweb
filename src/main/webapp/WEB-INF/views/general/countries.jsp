

<ol class="breadcrumb animated fadeIn fast">
	<li><a href="${pageContext.request.contextPath}/"><i
			class="fa fa-dashboard"></i> Dashboard</a></li>
	<li class="active">Countries</li>
</ol>


<div class="row" ng-app="cleanSolutionApp" ng-controller="countryCtrl">
	<div class="col-md-11">
		<div class="box">

			<div class="box-header with-border">
				<h3 class="box-title">Countries</h3>

				<div class="box-tools" align="right">
					<div class="input-group" style="width: 150px;">
						<a ng-click="" class="btn btn-primary"><i class="fa fa-plus"></i>
							Country</a>
					</div>
				</div>

			</div>
			<!-- /.box-header -->

			<div class="box-body">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>#</th>
							<th>Code</th>
							<th>Alpha 2</th>
							<th>Alpha3</th>
							<th>Name En</th>
							<th>Name Fr</th>
						</tr>
					</thead>
					<tbody>
						<tr
							dir-paginate="country in countries.allCountries | filter:q | itemsPerPage: 10"
							current-page="currentPage">

							<td>{{country.countryId}}</td>
							<td>{{country.code}}</td>
							<td>{{country.alpha2}}</td>
							<td>{{country.alpha3}}</td>
							<td>{{country.nameEn}}</td>
							<td>{{country.nameFr}}</td>

							<td><a ng-click="" href=""><i class="fa fa-edit"></i></a></td>
						</tr>
					</tbody>
				</table>
				<dir-pagination-controls max-size="5" direction-links="true"
					boundary-links="true"
					template-url="resources/angularjs/templates/dirPagination.tpl.html"
					align="center"> 
				</dir-pagination-controls>
			</div>
		</div>

	</div>
</div>


