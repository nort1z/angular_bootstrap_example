'use strict';

module.service('ContactService', function ($http) {
    
   //simply returns the contacts list
    this.list = function () {
        var lista;
       
        $http.get('contacto/contactosList.json').success(function(rsList){
            lista = rsList;
        });
       
        return lista;
    }
});


