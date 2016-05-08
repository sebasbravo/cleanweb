var app = angular.module('cleanSolutionApp.notifications', []);

app.factory('Notifications', ['$http','$q', function ($http, $q) {
	
	var self = {

		notifications:[{
			icon: "fa-user",
			description:"Nuevo usuario registrado"

		},
		{
			icon: "fa-save",
			description:"Nuevo ingreso al inventario"

		}]
	};

	return self ;
}])