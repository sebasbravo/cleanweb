var app = angular.module('cleanSolutionApp.countryCtrl',[]);

app.controller('countryCtrl',  ['$scope', 'Countries', function ($scope, Countries ) {
	
	$scope.countries = [];
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	Countries.loadPage().then(function(){
		
		$scope.countries = Countries;
		
	})

}]);