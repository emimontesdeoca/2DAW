/**
 * Funcion que devuelve un valor random entre 10 y 0
 */
function getRandom() {
    return Math.floor(Math.random() * (10 - 1 + 1)) + 1;
}

String.prototype.replaceAt = function(index, replacement) {
    return this.substr(0, index) + replacement + this.substr(index + replacement.length);
}