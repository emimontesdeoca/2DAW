function setCookie(nombre, value, dias) {
  var expdate = new Date();
  expdate.setTime(expdate.getTime() + dias * 24 * 60 * 60 * 1000);
  document.cookie = nombre + "=" + encodeURIComponent(value) + "; expires=" + expdate.toUTCString();
}

function getCookie(nombre) {
  var index = document.cookie.indexOf(nombre + "=");
  if (index == -1)
    return null;
  index = document.cookie.indexOf("=", index) + 1;
  var endstr = document.cookie.indexOf(";", index);
  if (endstr == -1)
    endstr = document.cookie.length;
  return decodeURIComponent(document.cookie.substring(index, endstr));
}

function comprobar() {
  var cont = getCookie("contador");
  if (cont == null) {
    cont = 1;
    setCookie("contador", cont, 30);
  } else {
    cont++;
    setCookie("contador", cont, 30);
  }

  var hora = getCookie("hora");

  if (hora == null) {
    hora = new Date();
    setCookie("hora", hora, 30);
  } else {
    setCookie("hora", hora, 30);
  }

  document.getElementById('contador').innerHTML += cont;
  document.getElementById('hora').innerHTML += hora;
}

comprobar();

function act2() {

  var cookie = getCookie("color");
  if (cookie == null) {
    var color = prompt("Introduzca color");
    setCookie("color", color, 30);
  }

}
var color = getCookie("color");;
document.getElementById('coloract2').innerHTML += color;
document.getElementById('coloract2').style.color = color;
