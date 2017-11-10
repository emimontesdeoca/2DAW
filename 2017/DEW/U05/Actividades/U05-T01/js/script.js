var luck = [];
const imgArray = ['3debastos.png', '3deespadas.png', '8decopas.png'];
var score = 100;
var won = 1;
var apostado = 0;

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

  apostado = parseInt(document.getElementById('dinero').value);

  /// Si no es un numero no hace nada
  if (isNaN(apostado)) {
    alert("Hay que apostar!!");
    return false;
  }

  if (apostado <= 0) {
    alert("VAS DE LISTILLO EH!!");
    return false;
  }

  if (score <= 0) {
    alert("Estas en bancarrota, pero Emi365 te da credito!!");
    score = 100;
    document.getElementById('score').innerHTML = "Tu dinero actual es: " + score + "€";
    return false;
  }

  /// Comprobador para que ninguna carta se pueda cambiar luego de darle a una
  /// Probablemente se pueda refactorizar utilizando el map
  var c = 0;
  for (var i = 0; i < 3; i++) {
    var a = document.getElementById(i).src.split('/');
    if (a[a.length - 1] == "back.png") {
      c++;
    }
  }
  if (c != 3) {
    return false;
  }

  /// Id del elemento
  var id = this.id;

  /// Split para la ruta de la imagen
  var a = this.src.split('/');

  /// Ultimo es el src final
  if (a[a.length - 1] == "back.png") {
    /// Si es 1 es la ganadora, cambiar el SRC
    if (id == "1") {
      document.getElementById(id).src = "img/Asdeoros.png";
      var dineroganado = apostado * won;
      score += dineroganado;
      won++;

    } else {
      /// Gestion de puntuacion
      score -= apostado;
      won = 1;
      /// Si no mostrar una carta random
      document.getElementById(id).src = "img/" + imgArray[Math.floor(Math.random() * imgArray.length)];
      setTimeout(() => document.getElementById("1").src = "img/Asdeoros.png", 500);
    }
    document.getElementById('score').innerHTML = "Tu dinero actual es: " + score + "€";
    document.getElementById('mult').innerHTML = "El multiplicador actual es: x" + won;
    /// Interval para desactivar el boton
    setTimeout(() => document.getElementById('otravezbtn').removeAttribute("disabled"), 500);
  }
}

function generarTitulo() {
  /// Creando titulo
  var input = document.createElement("h1");
  input.innerHTML = "Emi365 - Trileros";
  document.getElementById('header').appendChild(input);
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

function generarPanel() {
  /// Creando br
  var br = document.createElement("br");
  document.getElementById('panel').appendChild(br);

  /// Creando label
  var label = document.createElement("label");
  label.innerHTML = "Apostar dinero: ";

  document.getElementById('panel').appendChild(label);

  /// Creando input para apostar
  var txtbox = document.createElement("input");
  txtbox.type = "number";
  txtbox.id = "dinero";

  document.getElementById('panel').appendChild(txtbox);

  /// Creando h2 con puntuacion
  var input = document.createElement("h2");
  input.innerHTML = "Tu dinero actual es: " + score + "€";
  input.id = "score";

  document.getElementById('panel').appendChild(input);

  /// Creando h2 con puntuacion
  var input = document.createElement("h3");
  input.innerHTML = "El multiplicador actual es: x" + won;
  input.id = "mult";


  document.getElementById('panel').appendChild(input);

  /// Creando boton de otra vez
  var inputbtn = document.createElement("input");
  inputbtn.type = "button";
  inputbtn.id = "otravezbtn";
  inputbtn.value = "Otra vez!"
  inputbtn.disabled = true;
  inputbtn.addEventListener('click', generarJuego, false);

  document.getElementById('panel').appendChild(inputbtn);

}

function generarJuego() {
  /// Poner el boton a disabled, en un trycatch porque cuando se inicia juego no se ha generado el boton todavia
  try {
    document.getElementById('otravezbtn').setAttribute("disabled", "disabled");
  } catch (e) {}

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


generarTitulo();
generarJuego();
generarPanel();
