/*Realizar un programa que pida al usuario mediante prompt 6 valores
enteros que serán almacenados en 6 variables distintas.
Una vez introducidos se deberá mostrar un mensaje que indique
el número mayor, el menor, la suma de los enteros introducidos
y la diferencia entre el mayor y el menor.*/

function mainEjercicio1() {

  var numbers = [];

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

  /// Add values to numbers[]
  for (var i = 0; i < 6; i++) {
    numbers.push(askValue());

  }
  console.error(Math.max(numbers));
  /// Numbers[]
  var p = document.getElementById("array").innerHTML = "Numbers[] = " + numbers;

  /// Highest
  var h = numbers.sort(function(a, b) {
    return b - a
  })[0];
  var p = document.getElementById("mayor").innerHTML = "Highest = " + h[0];

  /// Lowest
  var l = numbers.sort(function(a, b) {
    return a - b
  })[0];
  var p = document.getElementById("menor").innerHTML = "Lowest = " + l;

  /// Sum
  var total = 0;
  for (var i in numbers) {
    total += parseInt(numbers[i]);
  }

  var p = document.getElementById("suma").innerHTML = "Sum = " + total;

  /// Highest - Lowest
  var p = document.getElementById("diferencia").innerHTML = "Highest - Lowest = ";

}
