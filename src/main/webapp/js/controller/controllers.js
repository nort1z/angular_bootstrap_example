'use strict';

module.controller('BienvenidoController', function ($scope) {
    $scope.textoBienvenida = 'Bienvenido a Test App';
});

module.controller('ContactController', function ($scope, ContactService) {
    
    var lista = ContactService.all();
    console.log("cantidad: " + JSON.stringify(lista));
    $scope.contacts = lista;
});

