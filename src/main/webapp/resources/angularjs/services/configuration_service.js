var app = angular.module('cleanSolutionApp.configuration', []);

app.factory('Configuration', ['$http','$q', function ($http, $q) {
	
	var self = {

		config:{},
		charge: function(){

			var d = $q.defer();

			$http.get('resources/angularjs/configuration.json').success(function(data){

				self.config = data;
				d.resolve();

			}).error(function(){
				d.reject();
				console.error("No se puedo cargara el archivo de configuracion");
			});

			return d.promise;
		}


	};

	return self ;
}])