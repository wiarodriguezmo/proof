'use strict';

var app = angular.module('beitech', ['ngSanitize', 'ui.select']);

app.controller('beitechCtrl', function ($http, $q) {
  var vm = this;

    vm.products = [
        { productId: "1",   name: 'Product A'},
        { productId: "2",   name: 'Product B'},
        { productId: "3",   name: 'Product C'},
        { productId: "4",   name: 'Praoduct D'},
        { productId: "5",   name: 'Prsoduct B'},
        { productId: "6",   name: 'Preoduct C'},
        { productId: "7",   name: 'Progduct D'}
    ];
    vm.id = "1";
    vm.selectedProducts = [{"productId":"4","name":"Product D"},{"productId":"3","name":"Product C"}];
    
    vm.setProducts = function () {
    var data= JSON.stringify(vm.selectedProducts);
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

    vm.setProducts();
});
