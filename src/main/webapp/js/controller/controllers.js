'use strict';

module.controller('BienvenidoController', function ($scope) {
    $scope.textoBienvenida = 'Bienvenido a Test App';
});

module.controller('ContactController', function ($scope, ContactService) {
    
    ContactService.getAll(function(results) {
        $scope.contacts = results;
    });
    
 
    $scope.saveContact = function () {
        var contacto = $scope.newcontact;
        if(contacto.name != null && contacto.email != null && contacto.phone != null){
            ContactService.addContact(function(results) {
                if(results == "ok"){
                    ContactService.getAll(function(results) {
                        $scope.contacts = results;
                    });
                    $scope.newcontact = {};
                }else{
                    console.log("err: " + results);
                }
            },contacto);
        }
    };
    
    $scope.delete = function (id) {
        ContactService.deleteContact(function(results) {
            ContactService.getAll(function(results) {
                $scope.contacts = results;
            });
            $scope.newcontact = {};
        },id);
    };
    
    $scope.edit = function (id) {
        ContactService.findContact(function(results) {
            console.log(results);
            $scope.newcontact = angular.copy(results);
        },id);
    };
});

