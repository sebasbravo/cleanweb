var app = angular.module('cleanSolutionApp.states', []);

app.factory('States', [
		'$http',
		'$q',
		function($http, $q) {

			var self = {

				'statesByCountry' : [],

				loadPageSates : function(countryId) {
					var d = $q.defer();
					$http.get('statesByCountry?countryId=' + countryId)
							.success(function(data) {
								self.statesByCountry = data;
								return d.resolve();
							})
					return d.promise;
				}
			};
			return self;
		} ])