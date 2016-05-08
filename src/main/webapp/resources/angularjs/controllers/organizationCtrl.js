var app = angular.module('cleanSolutionApp.organizationCtrl',[]);

app.controller('organizationCtrl',  ['$scope', 'Organizations','Countries', function ($scope, Organizations, Countries ) {
	
	$scope.organizations = [];
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	Organizations.loadPage().then(function(){		
		$scope.organizations = Organizations;		
	})
	
	
	//Show modal
	$scope.showModal = function(){
		$("#modalOrganization").modal();
	}

}]);