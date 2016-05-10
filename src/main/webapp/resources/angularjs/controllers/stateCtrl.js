var app = angular.module('cleanSolutionApp.stateCtrl',[]);

app.controller('stateCtrl',  ['$scope', 'States', function ($scope, States ) {
	
	$scope.states = [];
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	States.loadPageSates(countryId).then(function(){					
		$scope.states = States;
		})
	
}]);