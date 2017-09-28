var displayClosure = function() {
    var count = 0;
    return function () {
        return ++count;
    };
}
var inc = displayClosure();
inc(); // devuelve 1
inc(); // devuelve 2
inc(); // devuelve 3
