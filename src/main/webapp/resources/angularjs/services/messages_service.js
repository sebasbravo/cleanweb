var app = angular.module('cleanSolutionApp.messages', []);

app.factory('Messages', ['$http','$q', function ($http, $q) {
	
	var self = {

		messages:[{
			img: 'resources/adminLTE/dist/img/user1.jpg',
			name: "Sebastian Bravo",
			message:'Bienvenido al servicio de Inventario',
			date:'5-marzo'

		},
		{
			img: 'resources/adminLTE/dist/img/user2.jpg',
			name: "Carlos Perez",
			message:'Bienvenido al servicio de Control',
			date:'6-marzo'

		},
		{
			img: 'resources/adminLTE/dist/img/user3.jpg',
			name: "Juliana Varela",
			message:'Bienvenido al servicio de Facturacion',
			date:'7-marzo'

		}]
	


	};

	return self ;
}])