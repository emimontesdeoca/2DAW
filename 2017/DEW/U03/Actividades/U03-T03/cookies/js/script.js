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

function setCookieMaxAge(name, value, maxAgeSeconds) {
  var maxAge = "; max-age=" + maxAgeSeconds;
  document.cookie = encodeURI(name) + "=" + encodeURI(value) + maxAge;
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
  hora = new Date();
  setCookie("hora", hora, 30);

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
var color = getCookie("color");
document.getElementById('coloract2').innerHTML += color;
document.getElementById('coloract2').style.color = color;


function crearCookieAct4() {

  var cadu = getCookie("caduCookie");

  if (cadu == null) {
    hora = new Date();
    setCookieMaxAge("caduCookie", hora, 60);
    alert("Cookie creada!");
  } else {
    alert("La cookie ya existe!");
  }
}

function act4() {

  var cadu = getCookie("caduCookie");
  if (cadu == null) {
    alert("La cookie no existe o esta caducada!");
  } else {
    alert("La cookie existe, no esta caducada!");
  }
}

function act5() {

  var cookie = getCookie("color");

  if (cookie == null) {
    alert("La cookie no existe!");
  } else {
    setCookieMaxAge("color", "red", 1);
    alert("Cookie actualizada con 1 segundo de vida!");
  }
}
