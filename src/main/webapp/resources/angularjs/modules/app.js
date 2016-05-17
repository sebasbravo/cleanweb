var app = angular.module('cleanSolutionApp', [
                          'ngRoute','jcs-autoValidate',
                          'angularUtils.directives.dirPagination',
                          'cleanSolutionApp.configuration',
                          'cleanSolutionApp.messages',
                          'cleanSolutionApp.notifications',
                          'cleanSolutionApp.cities',
                          'cleanSolutionApp.countries',
                          'cleanSolutionApp.states',
                          'cleanSolutionApp.organization',
                          'cleanSolutionApp.cityCtrl',
                          'cleanSolutionApp.countryCtrl',
                          'cleanSolutionApp.organizationCtrl',
                          'cleanSolutionApp.stateCtrl'
                          ]);

angular.module('jcs-autoValidate')
.run([
    'defaultErrorMessageResolver',
    function (defaultErrorMessageResolver) {
        defaultErrorMessageResolver.setI18nFileRootPath('resources/angularjs/lib');
        defaultErrorMessageResolver.setCulture('es-co');
    }
]);

app.controller('mainCtrl',['$scope','Configuration','Messages','Notifications',function($scope, Configuration, Messages,Notifications) {
	
	$scope.config = {};
	$scope.messages = Messages.messages;
	$scope.notifications = Notifications.notifications;
	
	$scope.user = {
			name:"Sebastian Bravo"
	};
	
	Configuration.charge().then(function(){
		$scope.config = Configuration.config;
	});
	
	
	//Global functions
	$scope.active = function(menu, submenu, title, subtitle){
		
		$scope.title = title;
		$scope.subtitle = subtitle;
		$scope.mDashboard  = "";
		$scope.mCity = "";

		$scope[menu] = 'active';
		
	};
	
}]);

