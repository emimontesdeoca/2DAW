/*Solicitar por teclado mediante prompt un número positivo y mostrar un
mensaje indicando el número de dígitos que contiene y la suma de cada
uno de sus dígitos. Por ejemplo: 125, tendría tres dígitos y la suma
de estos sería 8.*/

function mainEjercicio5() {


function validate(n) {
  if (isNaN(n) || n == '') {
    alert("Wrong values.")
    return false;
  } else {
    return true;
  }
}

function askValue() {
  do {
    var a = prompt("Enter a number:")
  } while (!validate(a));
  return a;
}
/// Ask value
var a = askValue();

/// Split
var split = a.split('');

/// Array sum
var total = 0;
for (var i = 0; i < split.length; i++) {
  total += parseInt(split[i]);
}
/// Show total
alert(total);
}
