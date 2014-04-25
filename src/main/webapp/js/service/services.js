'use strict';

module.factory('ContactService', function ($http) {
    
   //simply returns the contacts list
       var list;
        $http.get('contacto/contactosList.json').then(function(data){
            console.log(data);
            list =  data;
        });
        return {
            all:function(){
                return list;
            }
        };
});


