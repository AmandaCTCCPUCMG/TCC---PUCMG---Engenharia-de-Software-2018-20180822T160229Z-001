angular.module('app').config(function ($routeProvider) {

//Definição das rotas utilizadas no sistema.    

    $routeProvider

        .when('/', {

            templateUrl: './view/autenticacao.html',

            controller: 'EmailController'

    })
    .when("/cadastro", {
        templateUrl : "./view/cadastro.html"
    })
    .when("/autenticacao", {
        templateUrl : "./view/autenticacao.html"
    })
    .when("/menuCliente", {
        templateUrl : "./view/menuCliente.html"
    })
    .when("/gestaoCliente", {
        templateUrl : "./view/gestaoCliente.html"
    })
    .when("/alterarDadosUsuario", {
        templateUrl : "./view/alterar.html"
    })
    
});
