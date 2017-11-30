var a = document.querySelectorAll(
  "div:not(.header):not(.calendario):not(.mes):not(.Nombre):not(.DS)"
);

var divs = 42;
var i = 0;
var dia = 1;

var lastDayMonth = 0;

function getCalendario() {
  for (let t = 0; t < 12; t++, divs += 42) {
    /// Objeto date con los valores introducdos
    var d = new Date();
    var anio = parseInt(document.getElementById("anioInput").value);
    d.setFullYear(anio, t, dia);

    /// Ultimo dia de mes
    lastDayMonth = new Date(anio, t + 1, 0).getDate();

    /// Primer dia de la semana
    var firstDayWeekNumber = d.getDay();

    /// Arreglo para dia 0
    if (firstDayWeekNumber == 0) {
      i += 6;
    } else {
      i += firstDayWeekNumber - 1;
    }

    /// Agregar los dias del mes
    for (j = 1; i < divs; i++) {
      a[i].innerHTML = j;
      j++;

      /// Empezar de nuevo si se complen los dias del mes
      if (j - 1 == lastDayMonth) {
        break;
      }
    }

    i = divs;
  }
}
