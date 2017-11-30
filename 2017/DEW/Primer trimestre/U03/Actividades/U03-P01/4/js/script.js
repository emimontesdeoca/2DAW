function realizarEjercicio() {
  /// Preguntar por el valor
  var a = prompt("Introduzca un número");

  /// Para darle la vuelta hacemos split
  var splitOfString = a.split("");

  /// Variable para el nuevo valor

  var cookie = "";
  /// Empezando desde atras asignamos el valor a la nueva variable
  for (var i = splitOfString.length - 1; i >= 0; i--) {
    cookie += splitOfString[i];
  }

  /// Parseamos para conseguir los numeros nuevos
  var parseA = parseInt(a);
  var parseCookie = parseInt(cookie);

  /// Si se ha introducido 0, significa que quiere salir o si ha introducido palabras esta mal introducido
  if (parseA != 0 && !isNaN(a)) {
    /// Si la suma de los numeros es impar y el length de los numeros es el mismo es reversible
    if (((parseA + parseCookie) % 2) != 0 && parseA.toString().length == parseCookie.toString().length) {
      alert("SI es reversible");
    } else {
      alert("NO es reversible");
    }
  }
}
