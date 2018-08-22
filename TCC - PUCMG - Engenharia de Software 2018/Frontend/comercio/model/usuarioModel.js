angular.module('app').controller("gestaoCliente", function($scope, $http) {

  $scope.UserLogin=null;
  getDadosAtualizado();


//removeUsuario - No momento que o usuário seleciona a opção de excluir o objeto Id é enviado para
//a função removeUsuario. Na função é perguntado ao usuário se ele realmente deseja excluir o seu perfil
// Se sim, o id é enviado para o backend e um alerta de sucesso é mostrado na tela, os cookies são deletados
// e o usuário é redirecionado para a página de autenticação. Caso a resposta seja Não, o usuário permanece
// na página.

    $scope.removeUsuario = function(id){
        
        var url = "http://localhost:8080/ServiceRest/app/service/remove/";

        var confirmacao = confirm('Deseja realmente excluir o seu perfil?');

        if(confirmacao){
           $http.delete(url+id);
           alert('**Cadastro deletado!!');  
           $scope.removeCookies();
           window.location.replace("#!autenticacao");
        }        
    } 


//updateUsuario - Na página de atualização o usuário realiza as alterações necessárias e clica na opção
//  alterar. Neste momento, o objeto contendo todos os novos dados é enviado para a função updateUsuario
// que envia para o backend onde são atualizados. O array de dados UserLogin e limpo e a função
//getDadosAtualizado é chamada para atualizar os dados na página de visualização. Um alerta de sucesso
//é exibida e a página redirecionada para o Menu Gestão Cliente.

    $scope.updateUsuario = function(user){

        var url = "http://localhost:8080/ServiceRest/app/service/update";
        var headers = 'Content-Type:application/json'; 

        $http.put(url, user,headers);
        $scope.UserLogin=null;
        getDadosAtualizado();

        alert('Atualização realizada com sucesso!');
        window.location.href = '#!gestaoCliente';
    }   


//getDadosAtualizado - Através do cookies, pega todos os dados do usuário e envia para o array
// UserLogin para posterior utilização       
    
    function getDadosAtualizado(){        
       var sesionUser =  getCookies();
       var url = 'http://localhost:8080/ServiceRest/app/service/get-user-login?email='+sesionUser.email+'&senha='+sesionUser.senha;
        
        $http.get(url).then((valor)=>{
      
       $scope.UserLogin=null;
            $scope.UserLogin={
                'id':valor.data.id,
                'nome':valor.data.nome,
                'cpf':valor.data.cpf,
                'email':valor.data.email,
                'telefone':valor.data.telefone,
                'senha':valor.data.senha,
                'municipio':valor.data.municipio,
                'estado':valor.data.estado,
                'endereco':valor.data.endereco
            }
       });
    }


//getCookies - Pega os dados do usuário logado para ser definido e enviado como 
//cookies nos cabeçalhos.     

  function getCookies(){
  var result = document.cookie.split(';')[0].split('=')[1];
  return JSON.parse(result);
 }

//removeCookies - Deleta os cookies salvos na sessão e redireciona o usuário para a página de
//autenticação 

 $scope.removeCookies = function(){
  document.cookie = 'UserCookies=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  window.location.replace("#!autenticacao");
 }
 
});





