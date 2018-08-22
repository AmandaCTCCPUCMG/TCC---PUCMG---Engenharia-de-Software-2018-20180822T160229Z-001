 angular.module('app').controller('EmailController', ['$scope', function($scope) {
	      Ocorrencia.email = {
	        text: 'me@example.com'
	      };
}]);

//Definição de máscara para o perfil dos e-mails no input. Devem ter um @ e .com para validação ou
//será enviado como null