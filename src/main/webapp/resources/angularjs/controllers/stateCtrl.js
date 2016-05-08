var app = angular.module('cleanSolutionApp.stateCtrl',[]);

app.controller('stateCtrl',  ['$scope', 'States', function ($scope, States ) {

	States.loadPage();

}]);