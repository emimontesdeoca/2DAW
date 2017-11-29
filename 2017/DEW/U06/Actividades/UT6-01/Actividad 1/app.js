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
function checkFormulario() {
  var primero = document.getElementById("primero").value;
  var segundo = document.getElementById("segundo").value;
  var tercero = document.getElementById("tercero").value;

  var errorprimero = document.getElementById("errorprimero");
  var errorsegundo = document.getElementById("errorsegundo");
  var errortercero = document.getElementById("errortercero");

  var enviar = document.getElementById("enviar");

  var i = 0;
  
  if (!checkText(primero)) {
    errorprimero.innerHTML = "Error en este campo";
    i++;
  } else {
    errorprimero.innerHTML = "Perfecto!";
  }
  if (!checkNumber(segundo)) {
    errorsegundo.innerHTML = "Error en este campo";
    i++;
  } else {
    errorsegundo.innerHTML = "Perfecto!";
  }
  if (!checkTextNumbers(tercero)) {
    errortercero.innerHTML = "Error en este campo";
    i++;
  } else {
    errortercero.innerHTML = "Perfecto!";
  }

  if (i > 0) {
    enviar.disabled = true;
  } else {
    envar.disabled = false;
  }
}
