'use strict';

module.factory('ContactService', function ($http) {
    return {
        getAll: function(callback) {
          $http.get('contacto/getAllContactos.json').success(callback);
        },
        addContact: function(callback,contact) {
            $http.post('contacto/addContacto.json',contact).success(callback);
        },
        deleteContact: function(callback,id) {
            if (id != null) {
                $http.post('contacto/removeContacto.json',id).success(callback);
            }
        },
        findContact: function(callback,id) {
            if (id != null) {
                $http.post('contacto/findContacto.json',id).success(callback);
            }
        }
    }; 
});


