var app = angular.module('cleanSolutionApp.organizationCtrl', []);

app.controller('organizationCtrl', [ '$scope', 'Organizations', 'Countries',
		'States', 'Cities',
		function($scope, Organizations, Countries, States, Cities) {

			$scope.organizations = [];
			$scope.currentPage = 1;
			$scope.pageSize = 10;

			$scope.countries = [];
			$scope.states = [];
			$scope.cities = [];

			Organizations.loadPage().then(function() {
				$scope.organizations = Organizations;
			})

			// Show modal
			$scope.showModal = function() {
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
				console.log(stateId);
				Cities.loadCitiesByState(stateId).then(function(){					
				$scope.cities = Cities;
				console.log(Cities);
				})	
			}

		} ]);