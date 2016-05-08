<script src="resources/angularjs/controllers/stateCtrl.js"></script>
<script src="resources/angularjs/services/state_service.js"></script>


<div class="modal fade" id="modalOrganization" ng-app="cleanSolutionApp">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title">Organization:</h4>
			</div>

			<form name="frmOrganization" ng-submit="save(organizationSel, frmOrganization)"
				novalidate="novalidate">

				<div class="modal-body">

					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							placeholder="Name ..." ng-model="organizationSel.name" required>
					</div>

					<div class="form-group">
						<label>Nis</label> <input type="text" class="form-control"
							placeholder="Nis ..." ng-model="organizationSel.nis" required>
					</div>
					
					<div class="form-group">
						<label>Teléfono</label> <input type="text" class="form-control"
							placeholder="Teléfono ..." ng-model="organizationSel.phone">
					</div>
					
					<div class="form-group">
						<label>Celular</label> <input type="text" class="form-control"
							placeholder="Celular ..." ng-model="organizationSel.cel">
					</div>
					
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							placeholder="Email ..." ng-model="organizationSel.email">
					</div>
					
					<div class="form-group">
						<label>Website</label> <input type="text" class="form-control"
							placeholder="Website ..." ng-model="organizationSel.website">
					</div>
					
					<div class="form-group">
						<label>Tax Federal</label> <input type="text" class="form-control"
							placeholder="Tax Federal ..." ng-model="organizationSel.txFed">
					</div>
					
					<div class="form-group">
						<label>Tax Provincial</label> <input type="text" class="form-control"
							placeholder="Tax Provincial ..." ng-model="organizationSel.txProv">
					</div>

					<div  ng-controller="countryCtrl">
						<label>Pais</label>
						 <select placeholder="Pais ..." name="country" id="countryId" ng-model="organizationSel.countryId">
							<option ng-repeat="country in countries.allCountries" value="{{country.countryId}}">{{country.nameEn}}</option>													
						</select>
					</div>	
					
					<div ng-controller="stateCtrl">
						<label>Provincia</label>
						 <select placeholder="Provincia ..." name="state" id="stateId" ng-model="organizationSel.stateId">
							<option ng-repeat="state in states.statesByCountry" value="{{state.stateId}}">{{state.name}}</option>													
						</select>
					</div>
					
					<div ng-controller="cityCtrl">
						<label>Ciudad</label>
						 <select placeholder="Provincia ..." name="state" id="stateId" ng-model="organizationSel.cityId">
							<option ng-repeat="city in cities.citiesByState" value="{{city.cityId}}">{{city.name}}</option>													
						</select>
					</div>				

					<div class="form-group">
						<label>Codigo postal</label> <input type="text"
							class="form-control" placeholder="Codigo postal ..."
							ng-model="organizationSel.postalCode">
					</div>

					<div class="form-group">
						<label>Direccion</label>
						<textarea type="text" class="form-control"
							placeholder="Direccion ..." ng-model="organizationSel.civicAddress"></textarea>
					</div>

				</div>

				<div class="modal-footer">

					<button type="submit" class="btn btn-primary">
						<i class="fa fa-save"></i> Guardar
					</button>
				</div>

			</form>

		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
