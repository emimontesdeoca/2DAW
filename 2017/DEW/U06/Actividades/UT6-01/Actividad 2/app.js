function checkText(text) {
  if (text == null || text.length == 0 || /^\s+$/.test(text) || !isNaN(text)) {
    return false;
  } else {
    return true;
  }
}
function checkTextNumbers(text) {
  if (text == null || text.length == 0 || /^\s+$/.test(text)) {
    return false;
  } else {
    return true;
  }
}
function checkNumber(text) {
  if (isNaN(text) || text.length == 0) {
    return false;
  } else {
    return true;
  }
}

function checkTelefono(telefono) {
  // var a = /[0-9]{9}/;
  if (/[0-9]{9}/.test(telefono) && telefono.length == 9) {
    return true;
  } else {
    return false;
  }
}
function checkEmail(text, nombre) {
  if (text.match(nombre) && text.length != 0) {
    return true;
  } else {
    return false;
  }
}

function checkFormulario() {
  var usuario = document.getElementById("usuario").value;
  var nombreapellidos = document.getElementById("nombreapellidos").value;
  var direccion = document.getElementById("direccion").value;
  var telefono = document.getElementById("telefono").value;
  var correoelectronico = document.getElementById("correoelectronico").value;
  var sugerencias = document.getElementById("sugerencias").value;
  var foto = document.getElementById("foto").value;

  var eusuario = document.getElementById("eusuario");
  var enombreapellidos = document.getElementById("enombreapellidos");
  var edireccion = document.getElementById("edireccion");
  var etelefono = document.getElementById("etelefono");
  var ecorreoelectronico = document.getElementById("ecorreoelectronico");
  var esugerencias = document.getElementById("esugerencias");
  var efoto = document.getElementById("efoto");

  var enviar = document.getElementById("enviar");

  var i = 0;

  if (!checkText(usuario)) {
    eusuario.innerHTML = "Error en este campo";
    i++;
  } else {
    eusuario.innerHTML = "Perfecto!";
  }

  if (!checkText(nombreapellidos)) {
    enombreapellidos.innerHTML = "Error en este campo";
    i++;
  } else {
    enombreapellidos.innerHTML = "Perfecto!";
  }

  if (!checkText(direccion)) {
    edireccion.innerHTML = "Error en este campo";
    i++;
  } else {
    edireccion.innerHTML = "Perfecto!";
  }

  if (checkTelefono(telefono)) {
    etelefono.innerHTML = "Perfecto!";
  } else {
    etelefono.innerHTML = "Error en este campo";
    i++;
  }
  if (checkEmail(correoelectronico, usuario)) {
    ecorreoelectronico.innerHTML = "Perfecto!";
  } else {
    ecorreoelectronico.innerHTML = "Error en este campo";
    i++;
  }

  if (!checkTextNumbers(sugerencias)) {
    esugerencias.innerHTML = "Error en este campo";
    i++;
  } else {
    esugerencias.innerHTML = "Perfecto!";
  }
  var file = document.getElementById("foto").files[0];
  if (file.size < 1000000 && file.name.match(/.(png|gif)$/i)) {
    efoto.innerHTML = "Perfecto!";
  } else {
    efoto.innerHTML = "Error en este campo";
    i++;
  }

  if (i > 0) {
    enviar.disabled = true;
  } else {
    enviar.disabled = false;
  }
}
