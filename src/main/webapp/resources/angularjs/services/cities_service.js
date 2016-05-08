var app = angular.module('cleanSolutionApp.cities', []);

app.factory('Cities', ['$http','$q', function ($http, $q) {
	
	var self = {
			'charge': false,
			'err': false,
			'number':0,
			'cities':[],
			'pag_prev':1,
			'pag_next':1,
			'total_pag':1,
			'pages':[],
			
			loadPage: function(){
				
				var d = $q.defer();
				
				$http.get('city/').success(function(data){
					
					console.log(data);
					
					return d.resolve();
				});
				
				
				return d.promise;
			}


	};

	return self ;
}])