/*Crear una función que reciba un caracter (por ejemplo el *) y un número.
Esta función debe escribir un triángulo formado por esa letra, que tenga
como anchura inicial la que se ha indicado en el número. Por ejemplo, si
la letra es * y la anchura es 4, debería mostrar lo siguiente:

****
 ***
 **
 *
 */

function mainEjercicio9() {

var e = 0;
var rows  = prompt("Tamaño?");
var fuera = prompt("Contorno?");
var fuera = prompt("Interior?");


for (var i = rows; i > 0; i--) {
  var a = "";

  for (var c = 0; c < e; c++) {
    a += " ";
  }

  for (var j = 0; j < i; j++) {
    if (i == rows) {
      a += fuera  ;
    } else {
      if (j == 0 || j == i - 1) {
        a += fuera;
      } else {
        a += interior;
      }
    }
  }

  e++;
  console.log(a);
}

}
