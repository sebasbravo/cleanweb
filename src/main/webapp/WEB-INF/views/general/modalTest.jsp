<div class="modal fade" id="modalOrganization">
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
						<label>Pais</label> <select type="text" class="form-control"
							placeholder="Pais ..." ng-model="clienteSel.pais">
							<option value="Costa Rica">Costa Rica</option>
							<option value="Cuba">Cuba</option>
							<option value="Canada">Canada</option>
							<option value="Portugal">Portugal</option>
						</select>
					</div>

					<div class="form-group">
						<label>Teléfono 1</label> <input type="text" class="form-control"
							placeholder="Teléfono 1 ..." ng-model="clienteSel.telefono1">
					</div>

					<div class="form-group">
						<label>Teléfono 2</label> <input type="text" class="form-control"
							placeholder="Teléfono 2 ..." ng-model="clienteSel.telefono2">
					</div>

					<div class="form-group">
						<label>Codigo postal</label> <input type="text"
							class="form-control" placeholder="Codigo postal ..."
							ng-model="clienteSel.zip">
					</div>

					<div class="form-group">
						<label>Direccion</label>
						<textarea type="text" class="form-control"
							placeholder="Direccion ..." ng-model="clienteSel.direccion"></textarea>
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
