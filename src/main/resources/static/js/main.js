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
      delete user.original;
      user.edit = false;
      toast('user saved successfully');
    }, function () {
      toast('there was an issue during user save');
    });
  };

  vm.edit = function (user) {
    user.original = angular.copy(user);
    user.edit = true;
  }

  vm.cancel = function (user) {
    angular.merge(user, user.original);
    delete user.original;
    user.edit = false;
  }

  function toast(message) {
    if (state.lastTimeout) {
      $timeout.cancel(state.lastTimeout);
    }
    vm.footerMessage = message;
    state.lastTimeout = $timeout(function () { vm.footerMessage = '' }, 3000);
  }
});
