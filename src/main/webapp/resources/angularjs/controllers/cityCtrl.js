var app = angular.module('cleanSolutionApp.cityCtrl',[]);

app.controller('cityCtrl',  ['$scope', 'Cities', function ($scope, Cities ) {

	Cities.loadPage();

}]);