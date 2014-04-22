'use strict';

module.controller('BienvenidoController', function ($scope) {
    $scope.textoBienvenida = 'Bienvenido a Test App';
});

module.controller('ContactController', function ($scope, ContactService) {

    $scope.contacts = ContactService.list();
});

