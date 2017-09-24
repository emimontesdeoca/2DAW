/*Un alumno realizó una prueba. Se obtuvo la siguiente información: nombre del alumno,
cantidad total de preguntas que se le realizaron y cantidad de preguntas que contestó
correctamente. Se pide crear una(s) función(es) JS que lea los datos del estudiante,
informe el nivel del mismo según el porcentaje de respuestas correctas que ha obtenido,
y sabiendo que:

Nivel A: Porcentaje>=85%.
Nivel B: Porcentaje>=70% y <85%.
Nivel C: Porcentaje>=50% y <70%.
Nivel D: Porcentaje<50%.

Deberás mostrar en la consola un mensaje indicando los datos del estudiante y el nivel
del alumno. El mensaje en la consola aparecerá como "log" si es nivel A, "info" si es
nivel B, "warning" si es nivel C y "error" para nivel D
Igual que lo anterior pero añadiendo a la web los datos del alumno con formato H2 y el nivel en H1*/


var a = prompt("Nombre de alumno?");
var b = prompt("Cantidad de preguntas?");
var c = prompt("Respuesta correctas?")

/// object alumno
var alumno = [{
  "alumno": a,
  "totalpreguntas": parseInt(b),
  "correctas": parseInt(c)
}];

function getNivel(alu) {
  /// Maths
  var preg = parseInt(alu[0].totalpreguntas);
  var resp = parseInt(alu[0].correctas);
  var perc = (resp / preg).toFixed(2);
  /// return entero
  return (perc * 100).toFixed();
}

var n = parseInt(getNivel(alumno));

var name = document.getElementById("name").innerHTML = alumno[0].alumno;
var total = document.getElementById("total").innerHTML = alumno[0].totalpreguntas;
var correctas = document.getElementById("correctas").innerHTML = alumno[0].correctas;

if (n >= 85) {
  console.info("Nivel A!");
  var nivel = document.getElementById("nivel").innerHTML = "Nivel A!";
} else if (n >= 70 && n < 85) {
  console.info("Nivel B!");
  var nivel = document.getElementById("nivel").innerHTML = "Nivel B!";
} else if (n >= 50 && n < 70) {
  console.warn("Nivel C!");
  var nivel = document.getElementById("nivel").innerHTML = "Nivel C!";
} else {
  console.error("Nivel D!");
  var nivel = document.getElementById("nivel").innerHTML = "Nivel D!";
}




/* No funciona?
switch (n) {
  case n >= 85:
    console.info("Nivel A!");
    break;
  case n >= 70 && n < 85:
    console.info("Nivel B!");
    break;
  case n >= 50 && n < 70:
    console.warn("Nivel C!");
    break;
  case n < 50:
    console.error("Nivel D!");
    break;
}
*/
