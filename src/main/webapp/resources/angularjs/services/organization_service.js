var app = angular.module('cleanSolutionApp.organization', []);

app.factory('Organizations', [ '$http', '$q', function($http, $q) {
	
	var self = {
			
		'allOrganizations' : [],
		
		
		saveOrganization: function(organization){
			
			console.log("organization: "+organization.name);
			var d = $q.defer();
			
			$http.post('createOrganization', organization).success(function(response){
				console.log(response);
				
				d.resolve();
				
			})
			
			return d.promise;
			
		},

		loadPage : function() {
			var d = $q.defer();
			$http.get('allOrganizations').success(function(data) {
				console.log(data);
				self.allOrganizations = data;
				return d.resolve();
			});
			return d.promise;
		}
	};
	return self;
} ])