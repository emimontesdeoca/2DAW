/// Variable global para segundos
var sec = 0;
/// Variable global para intentos
var int = 0;
/// Variable timer para controler el setInterval del cronometro
var timer;

function comenzar() {
  /// Segundos a cero
  sec = 0;

  /// Subimos intento
  int++;

  /// SetInteveal para cada segundo
  timer = setInterval(function() {

    /// Un segundo más al cronometro.
    sec++;
  }, 1000);

}

function terminar() {
  /// Para el timer
  clearInterval(timer);

  /// Guardar el último número
  var item = sec;

  /// String para número de intento
  var itemName = 'intento' + int;

  /// Guardar item en localStorage
  localStorage.setItem(itemName, item);
}
