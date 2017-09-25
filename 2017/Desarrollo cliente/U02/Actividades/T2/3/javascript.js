/*Repetir el ejercicio 1 con cuatro valores enteros y tres valores reales.
En este caso, los números deben ser almacenados en una única variable,
deben ser todos positivos y se debe mostrar un mensaje de “Aprobado”
cuando la media supere el 5. Si la media es menor a 5 saldrá el mensaje
"Ponte las pilas".*/
function mainEjercicio3() {


  var numbers = [];

  function validate(n) {
    if (isNaN(n) || n == '' || n < 0) {
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

  /// Array sum
  var total = 0;
  for (var i in numbers) {
    total += parseInt(numbers[i]);
  }

  /// If
  if ((total / numbers.length).toFixed(2) >= 5) {
    alert("Aprobado");
  } else {
    alert("Ponte las pilas");
  }

}
