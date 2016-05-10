var app = angular.module('cleanSolutionApp.cities', []);

app.factory('Cities', [ '$http', '$q', function($http, $q) {

	var self = {

		'cities' : [],

		loadAllCities : function() {
			var d = $q.defer();
			$http.get('allCities').success(function(data) {
				self.cities = data;
				return d.resolve();
			});
			return d.promise;
		},
	
	loadCitiesByState : function() {
		var d = $q.defer();
		$http.get('citiesByState?stateId='+stateId).success(function(data) {
			self.cities = data;
			return d.resolve();
		});
		return d.promise;
	}

	};

	return self;
} ])