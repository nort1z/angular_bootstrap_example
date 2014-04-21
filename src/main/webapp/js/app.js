'use strict';

var module = angular.module('app', ['ngRoute']);

module.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/contacto', {
        templateUrl: 'contacto.html',
        controller: 'ContactController'
      }).
      when('/bienvenido', {
        templateUrl: 'bienvenido.html',
        controller: 'BienvenidoController'
      }).
      otherwise({
        redirectTo: '/bienvenido'
      });
  }]);
  