var app = angular.module('cleanSolutionApp.organization', []);

app.factory('Organizations', ['$http','$q', function ($http, $q) {
	
	var self = {
			
			'allOrganizations':[],
			
			loadPage: function(){
				
				var d = $q.defer();
				
				$http.get('allOrganizations').success(function(data){
					
				self.allOrganizations = data;
					
					return d.resolve();
				});
				
				
				return d.promise;
			}


	};

	return self ;
}])