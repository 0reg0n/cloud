angular.module('linkbox0.core')
    .filter('binary', function () {
        return function (input) {
            return unitPrefixed(input, true);
        };
    });
