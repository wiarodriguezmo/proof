'use strict';

var app = angular.module('beitech', ['ngSanitize', 'ui.select']);

app.controller('beitechCtrl', function ($http, $q) {
  var vm = this;

    vm.products = [
        { productId: 1,   name: 'Product A'},
        { productId: 2,   name: 'Product B'},
        { productId: 3,   name: 'Product C'},
        { productId: 4,   name: 'Praoduct D'},
        { productId: 5,   name: 'Prsoduct B'},
        { productId: 6,   name: 'Preoduct C'},
        { productId: 7,   name: 'Progduct D'}
    ];
    vm.id = 1;
    vm.selectedProducts = [{"productId":4,"name":"Product D"},{"productId":3,"name":"Product C"}];
    
    vm.setProducts = function () {
        var toSend = {
            id: vm.id,
            selectedProducts: vm.selectedProducts
        };
    var data= JSON.stringify(toSend);
    var d = $q.defer();
    $http({
        method: "POST",
        url: "webresources/orders/create",
        data: data,
        headers: {'Content-Type': 'text/plain'}
      })
    .success(function (response) {
        d.resolve(response);
    })
    .error(function (response) {
        d.reject(response);
    });

    return d.promise;
    };
    
    $http({
        method: 'GET',
        url: 'webresources/customers/list',
        headers: {'Content-Type': 'text/plain'}
      }).then(function successCallback(response) {
          vm.people = response.data;
        }, function errorCallback(response) {
          console.log(response)
    });
    
    vm.getList = function(){
        var uri = "?customerId=" + vm.personSelected.customerId + "&before=" + vm.before.getTime()/1000 + "&after=" + vm.after.getTime()/1000;
        $http({
            method: 'GET',
            url: 'webresources/orders/list' + uri,
            headers: {'Content-Type': 'text/plain'}
          }).then(function successCallback(response) {
              vm.orders = response.data;
            }, function errorCallback(response) {
              console.log(response)
        });
    }
});
