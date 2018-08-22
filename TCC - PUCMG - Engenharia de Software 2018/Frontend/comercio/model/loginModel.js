
angular.module('app').controller("loginController", function($scope, $http,$rootScope) {

//verificaLogin - Pega o e-mail e a senha informado no menu Autenticação aytravés do objeto Login
//e envia para o BackEnd check-user-login onde é verificado se existe ou não o usuário e se os dados
//correspondem. Se sim uma mensagem é exibida e o usuário redirecionado para o Menu Cliente, caso contrário
// uma mensagem de erro é exibida e o usuário redirecionado novamente a página de autenticação.

  $scope.verificaLogin = function(Login) {
    var postData = JSON.stringify(Login);
    var jsonObj = postData;
    var url = "http://localhost:8080/ServiceRest/app/service/check-user-login";

    var headers = 'Content-Type:application/json'; 
    
    $http.post(url, postData,headers).then(
      function(response) {
        if(response.data){
        setCookies(Login);     
       
         alert('Autenticação realizada com sucesso!');
             window.location.replace("#!menuCliente");
            }else{

             alert('**Erro ao autenticar!!');  
             window.location.replace("#!autenticacao");
           }            
    });
  }


//setCookies e getCookies - Pega os dados do usuário logado para ser definido e enviado como 
//cookies nos cabeçalhos. 

 function setCookies(dados) {
   document.cookie='UserCookies={"email":"'+dados.usuario.email+'","senha":"'+dados.usuario.senha+'"}';
 }

 function getCookies(){
  var result = document.cookie.split(';')[0].split('=')[1];
  return JSON.parse(result);
 }

//removeCookies - Deleta os cookies salvos na sessão e redireciona o usuário para a página de
//autenticação 

 function removeCookies(){
  document.cookie = 'UserCookies=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
  window.location.replace("#!autenticacao");
 }
 
});