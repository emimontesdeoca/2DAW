var luck = [];
const imgArray = ['3debastos.png', '3deespadas.png', '8decopas.png'];

function crearCarta(id) {
  /// Crear elemento input
  var input = document.createElement("img");

  /// Asignar id y imagen inicial
  input.id = id;
  input.src = "img/back.png";

  /// Agrega la misma funcion a todos
  input.addEventListener('click', comprobarCarta, false);

  /// Append dude
  document.getElementById('container').appendChild(input);
}

function comprobarCarta(e) {
  /// Id del elemento
  var id = e.path[0].attributes['id'].value;

  /// Split para la ruta de la imagen
  var a = document.getElementById(id).src.split('/');

  /// Ultimo es el src final
  if (a[a.length - 1] == "back.png") {
    /// Si es 1 es la ganadora, cambiar el SRC
    if (id == "1") {
      document.getElementById(id).src = "img/Asdeoros.png";
    } else {
      /// Si no mostrar una carta random
      document.getElementById(id).src = "img/" + imgArray[Math.floor(Math.random() * imgArray.length)];
      setTimeout(() => document.getElementById("1").src = "img/Asdeoros.png", 500);
    }
  }
}

function crearTitulo(){
  var input = document.createElement("h2");
  input.innerHTML = "Trilero";
  document.getElementById('container').appendChild(input);

}

function generarSuerte() {
  /// Regenerar la suerte
  luck = [];
  do {
    /// Crear un array random de valores que no se puedan repetir hasta 3 veces
    var item = Math.floor(Math.random() * 3);
    /// Comprobar si existe el numero random
    if (luck.indexOf(item) === -1) luck.push(item);
  } while (luck.length != 3);
}

function inciarJuego() {
  /// Borrar todo lo que hay en el nodo de container
  var myNode = document.getElementById('container');
  while (myNode.firstChild) {
    myNode.removeChild(myNode.firstChild);
  }

  /// Generar la suerte
  generarSuerte();
  for (var i = 0; i < luck.length; i++) {
    /// Generar la carta
    crearCarta(luck[i]);
  }

}


crearTitulo();
inciarJuego();
