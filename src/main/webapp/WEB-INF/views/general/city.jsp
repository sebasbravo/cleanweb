

<ol class="breadcrumb animated fadeIn fast">
     <li><a href="${pageContext.request.contextPath}/"><i class="fa fa-dashboard"></i> Dashboard</a></li>
     <li class="active">City</li>
</ol>


<div class="row" ng-app="cleanSolutionApp" ng-controller="cityCtrl">
<div class="col-md-10">
    <div class="box">
                
        <div class="box-header with-border">
            <h3 class="box-title">Cities</h3>

            <div class="box-tools" align="right">
                <div class="input-group" style="width: 150px;">
                    <a ng-click="" class="btn btn-primary"><i class="fa fa-plus"></i> City</a>
                </div>
            </div>

        </div><!-- /.box-header -->

        <div class="box-body">
         	<table class="table table-bordered">
         		<thead>
         			<tr>
         				<th>#</th>
         				<th>Name</th>
         				<th>Abbreviation</th>
         				<th>state</th>
         			</tr>
         		</thead>
         		<tbody>
         			<tr ng-repeat="city in cities">
         				<td>{{city.id}}</td>
         				<td>{{city.name}}</td>
         				<td>{{city.abbr}}</td>
         				<td>{{city.state}}</td>
         				
         				<td><a ng-click="" href=""><i class="fa fa-edit"></i> Editar</a></td>
         			</tr>
         		</tbody>
            </table>

        </div>
    </div>

</div>	
</div>


