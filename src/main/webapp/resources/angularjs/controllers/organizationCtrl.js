var app = angular.module('cleanSolutionApp.organizationCtrl', []);

app.controller('organizationCtrl', [ '$scope', 'Organizations', 'Countries',
		'States', 'Cities',
		function($scope, Organizations, Countries, States, Cities) {

			$scope.organizations = [];
			$scope.organizationSel = {};
			$scope.currentPage = 1;
			$scope.pageSize = 10;

			$scope.countries = [];
			$scope.states = [];
			$scope.cities = [];

			Organizations.loadPage().then(function() {
				$scope.organizations = Organizations;
			})

			// Show modal
			$scope.showModal = function( organization) {
				
				angular.copy(organization, $scope.organizationSel)
				
				$("#modalOrganization").modal();
			}

			Countries.loadPage().then(function() {
				$scope.countries = Countries;
			})

			$scope.showStates = function() {				
				countryId= $scope.organizationSel.countryId;
				States.loadPageSates(countryId).then(function(){					
				$scope.states = States;
				})	
			}
			
			$scope.showCities = function() {				
				stateId= $scope.organizationSel.stateId;
				Cities.loadCitiesByState(stateId).then(function(){					
				$scope.cities = Cities;
				})	
			}
			
			//Save function
			$scope.saveOrganizationFrm = function(organizationSel, frmOrganization){
				
				Organizations.saveOrganization(organizationSel).then(function(){
					$("#modalOrganization").modal('hide');
					$scope.organizationSel = {};
					frmOrganization.autoValidateFormOptions.resetForm();
				});
				
			}

		} ]);