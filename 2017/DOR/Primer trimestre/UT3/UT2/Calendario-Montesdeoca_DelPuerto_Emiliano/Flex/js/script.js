var a = document.querySelectorAll('.dia');
const monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
  "Julio", "Agosto", "Septiembre", "Octube", "Noviembre", "Diciembre"
];

function getCalendario() {

  document.getElementById('calendario').className = "contenedor show";
  /// Limpia todos las clases
  for (var i = 0; i < a.length; i++) {
    a[i].className = "dia";
  }

  /// Pillar datos
  var dia = 1;
  var mes = document.getElementById('inputMes').value;
  var anio = document.getElementById('inputAnio').value;
  var lastDayMonth = 0;

  /// Nombre de mes
  if (parseInt(mes) > 12) {
    document.getElementById('nombre').innerHTML = monthNames[parseInt(mes) - 12 - 1];
  } else {
    document.getElementById('nombre').innerHTML = monthNames[parseInt(mes) - 1];
  }

  /// Objeto date con los valores introducdos
  var d = new Date();
  d.setFullYear(anio, parseInt(mes) - 1, dia);

  /// Ultimo dia de mes
  lastDayMonth = new Date(anio, parseInt(mes), 0).getDate();

  /// Primer dia de la semana
  var firstDayWeekNumber = d.getDay();

  /// Arreglo para dia 0
  if (firstDayWeekNumber == 0) {
    i = 6;
  } else {
    i = firstDayWeekNumber - 1;
  }

  /// Para agregar los dias anteriores
  var cookie = d;
  d.setDate(d.getDate() - i);

  for (var c = d.getDate(), e = 0; e < i;) {
    a[e].innerHTML = c;
    a[e].className += " diaGris";
    e++;
    c++;
  }

  var setDiaGrises = false;

  /// Agregar los dias del mes
  for (j = 1; i < 42; i++) {
    a[i].innerHTML = j;
    j++;
    if (setDiaGrises) {
      a[i].className += " diaGris";
    }

    /// Empezar de nuevo si se complen los dias del mes
    if (j - 1 == lastDayMonth) {
      j = 1;
      setDiaGrises = true;
    }
  }
}
