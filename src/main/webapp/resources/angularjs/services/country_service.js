var app = angular.module('cleanSolutionApp.countries', []);

app.factory('Countries', ['$http','$q', function ($http, $q) {
	
	var self = {
			
			'allCountries':[],
			
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