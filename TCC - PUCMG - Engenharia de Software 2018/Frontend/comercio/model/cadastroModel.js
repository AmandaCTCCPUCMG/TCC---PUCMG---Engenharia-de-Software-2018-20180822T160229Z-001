angular.module('app').controller("cadUsuario", function($scope, $http) {

//insert - Pega os dados informados pelo usuário através do objeto Ocorrencia e envia para o BackEnd 
//para a função add. Caso o dado seja inserido corretamente, uma mensagem é exibida e o usuário e redirecionado
//para a página de Login. Caso contrário uma mensagem de Erro é exibida e o erro mostrado no console.    
    
    $scope.insert = function(Ocorrencia) {

        if(Ocorrencia.email != null){

            var postData = JSON.stringify(Ocorrencia);
            var url = "http://localhost:8080/ServiceRest/app/service/add/";
            var headers = 'Content-Type:application/json'; 

            $http.post(url, postData,headers).then(function(response) {
    	         alert('Usuário cadastrado com sucesso!');
    	         window.location.replace("#!autenticacao");
    	        // todo retorno que damos no BackEnd vem dentro do atributo 'data' da response.
    	    })                                             
    	    .catch(function(response) {
    	        alert('**Erro ao cadastrar!!');
    	        console.log(response); 
                // aqui conseguimos o status da requisição (código http)
    	    }); 

        }else{
          alert('**Erro no e-mail!!');  
        }
    }


//getAllUsuarios - Pegamos todos os usuários, com seus dados, cadastrados no sistema através 
//da função no BackEnd find-all    

    $scope.getAllUsuarios = function(){
    	var url = "http://localhost:8080/ServiceRest/app/service/find-all";
    	$http.get(url);
    }


//cadastroExistente - No momemnto do cadastro de um novo usuário, validamos os dados verificando se
//já não existe um outro usuário igual no Banco de Dados. O objeto Ocorrencia é passado para a função
//valida-cadastro no BackEnd e este retorna True ou False. Caso true, um alerta é emitido e o usuário
//redirecionado a página de Login.    


    $scope.cadastroExistente = function(Ocorrencia){

    	var url = "http://localhost:8080/ServiceRest/app/service/valida-cadastro/";
    	var postData = JSON.stringify(Ocorrencia);

        var headers = 'Content-Type:application/json'; 

        $http.post(url, postData,headers).then(function(response) {
             if(response.data == true){

              alert('ALERTA! Usuário já cadastrado no sistema!');
              window.location.replace("#!autenticacao");
             }

	     })
    }

});