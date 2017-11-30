/** Ejercicio 1 */

var text = ["Enlace <a href=\"#\">generado desde JS un texto con distintos formatos</a>",
  "Con un tamaño de fuente de 5px <span style=\font-size:5px\">generado desde JS un texto con distintos formatos.</span>",
  "Escriben superíndices <sup>generado desde JS un texto con distintos formatos.</sup>",
  "Escriben subíndices <sub>generado desde JS un texto con distintos formatos.</sub>",
  "Le damos formato cursiva <em>generado desde JS un texto con distintos formatos.</em>",
  "y por ultimo algo de color <span style=\"color:red\">generado desde JS un texto con distintos formatos.</span>",
  "y por ultimo algo de color <span style=\"color:red\"><em>generado desde JS un texto con distintos formatos.</em></span>"
];

var line = "";
for (var i = 0; i < text.length; i++) {
  line += text[i] + "<br>";
}

document.getElementById("act").innerHTML = line;

/* Ejercicio 2 */

function act2() {
  var a = window.open('views/padre.html', 'Padre', 'titlebar=1,width=600,height=600');
}

function act3() {
  var b = prompt("Introduzca un color en formato hexadecimal");

  var re = new RegExp("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");

  ///^#[0-9a-f]{3,6}$/i
  if (re.test(b)) {
    document.getElementsByTagName("body")[0].style = "background-color:" + b;
    document.getElementById("h1act3").innerHTML = "Este es el color elegido";
  } else {
    document.getElementsByTagName("body")[0].style = "background-color: white";
    document.getElementById("h1act3").innerHTML = "El color elegido no está controlado";
  }
}

function act4() {
  var a = window.open('views/act4.html');
}

function act5() {
  var view1 = window.open('views/act5_1.html', "", "width=600, height=600");

  setTimeout(function abrirSegunda() {
    var view2 = window.open('views/act5_2.html', "", "width=600, height=600");

    setTimeout(() => view1.close(), 5000)
  }, 2000);
}

function act6() {
  var now = new Date();
  var hour = now.getHours();
  var minute = now.getMinutes();
  var second = now.getSeconds();
  if (minute < 10) {
    minute = "0" + minute;
  }
  if (second < 10) {
    second = "0" + second;
  }
  var time = hour +
    ':' +
    minute +
    ':' +
    second
  document.getElementById('reloj').innerHTML = time;

  if (hour > 5 && hour < 12) {
    document.getElementById("mensaje").innerHTML = "Buenos dias!"
    document.getElementById("img").src = "https://www.autosvivo.com/blog/wp-content/uploads/2017/04/3-puesta-de-sol-menorca.jpg";
  } else if (hour > 12 && hour < 15) {
    document.getElementById("mensaje").innerHTML = "Mediodía!"
    document.getElementById("img").src = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Bocadillo_Espa%C3%B1ol.jpg/240px-Bocadillo_Espa%C3%B1ol.jpg";
  } else if (hour > 18 && hour < 22) {
    document.getElementById("mensaje").innerHTML = "Hora de Cenar!"
    document.getElementById("img").src = "https://hombresconestilo.com/wp-content/uploads/2015/01/cena.jpg";
  } else {
    document.getElementById("mensaje").innerHTML = "A currar!"
  }
}

function loadReloj() {
  setInterval('act6()', 1000);
};
