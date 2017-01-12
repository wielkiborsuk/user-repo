var app = angular.module('user-repo', []);

app.controller('UserController', function ($http, $timeout) {
  var vm = this;
  var state = { lastTimeout: null };

  vm.userList = [];

  $http.get('/user/').then(function (response) {
    vm.userList = response.data;
  });

  vm.save = function (user) {
    $http.put('/user/' + user.id, user).then(function (response) {
      user.edit = false;
      toast('user saved successfully');
    }, function () {
      toast('there was an issue during user save');
    });
  };

  function toast(message) {
    if (state.lastTimeout) {
      $timeout.cancel(state.lastTimeout);
    }
    vm.footerMessage = message;
    state.lastTimeout = $timeout(function () { vm.footerMessage = '' }, 3000);
  }
});
