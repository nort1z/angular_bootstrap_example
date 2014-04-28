'use strict';

module.factory('ContactService', function ($http) {
    return {
        getAll: function(callback) {
          $http.get('contacto/getAllContactos').success(callback);
        },
        addContact: function(callback,contact) {
            if (contact.id == null) {
                $http.post('contacto/addContacto',contact).success(callback);
            }
        }
    }; 
});


