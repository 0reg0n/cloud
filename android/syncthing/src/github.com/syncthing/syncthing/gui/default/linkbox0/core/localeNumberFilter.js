angular.module('linkbox0.core')
    .filter('localeNumber', function () {
        return function (input) {
            return input.toLocaleString();
        };
    });
