/*Crear una función que reciba un caracter (por ejemplo el *) y un número.
Esta función debe escribir un triángulo formado por esa letra, que tenga
como anchura inicial la que se ha indicado en el número. Por ejemplo, si
la letra es * y la anchura es 4, debería mostrar lo siguiente:

****
 ***
 **
 *
 */


for (var i = 5; i > 0; i--) {
  var a = "";
  for (var j = 0; j < i; j++) {
    a += "* "
  }

  console.log(a);
}
