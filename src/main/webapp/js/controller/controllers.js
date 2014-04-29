'use strict';

module.controller('BienvenidoController', function ($scope) {
    $scope.textoBienvenida = 'Bienvenido a Test App';
});

module.controller('ContactController', function ($scope, ContactService) {
    
    ContactService.getAll(function(results) {
        $scope.contacts = results;
    });
    
 
    $scope.saveContact = function () {
        ContactService.addContact(function(results) {
            if(results == "ok"){
                ContactService.getAll(function(results) {
                    $scope.contacts = results;
                });
                $scope.newcontact = {};
            }
        },$scope.newcontact);
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

