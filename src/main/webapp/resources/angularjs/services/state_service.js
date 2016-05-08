var app = angular.module('cleanSolutionApp.states', []);

app.factory('States', ['$http','$q', function ($http, $q) {
	
	var self = {
			
			'statesByCountryId':[],
			
			loadPage: function(){
				
				var d = $q.defer();
				
				$http.get('allCountries').success(function(data){
					
				self.allCountries = data;
					
					return d.resolve();
				});
				
				
				return d.promise;
			}


	};

	return self ;
}])