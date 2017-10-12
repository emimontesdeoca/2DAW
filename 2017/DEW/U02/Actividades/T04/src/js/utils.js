/**
 * Funcion que devuelve un valor random entre 10 y 0
 */
function getRandom() {
    return Math.floor(Math.random() * (10 - 1 + 1)) + 1;
}

/// Funcion arrow para cambiar el valor de un elemento
var updateInt = (element, int) => document.getElementById(element).innerHTML = int;