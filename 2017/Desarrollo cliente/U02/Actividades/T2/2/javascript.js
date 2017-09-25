/*Solicitar al usuario un número entero a través de una ventana de diálogo.
Multiplicar ese número por 2.5 y sumarle 100. Mostrar el resultado en otra ventana de diálogo.*/
function mainEjercicio2() {

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

var a = askValue();
a = (parseInt((a*2.5)) + 100).toFixed(2);

alert(a);
}
