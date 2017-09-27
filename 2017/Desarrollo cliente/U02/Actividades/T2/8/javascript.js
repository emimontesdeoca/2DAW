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
function mainEjercicio8() {


  var a = prompt("Nombre de alumno?");
  do {
    var b = prompt("Cantidad de preguntas?");
  } while (b < 0);

  do {
    var c = prompt("Respuesta correctas?")
  } while (c > b);

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

  function changeInnerHtml(id, text) {
    return document.getElementById(id).innerHTML = text;
  }

  /// Set html
  var n = parseInt(getNivel(alumno));
  var name = changeInnerHtml("name", alumno[0].alumno);
  var total = changeInnerHtml("total", alumno[0].totalpreguntas);
  var correctas = changeInnerHtml("correctas", alumno[0].correctas);
  /*
  /// Write level
  if (n >= 85) {
    console.log("Nivel A!");
    var nivel = changeInnerHtml("nivel", "Nivel A!");
  } else if (n >= 70 && n < 85) {
    console.info("Nivel B!");
    var nivel = changeInnerHtml("nivel", "Nivel B!");
  } else if (n >= 50 && n < 70) {
    console.warn("Nivel C!");
    var nivel = changeInnerHtml("nivel", "Nivel C!");
  } else {
    console.error("Nivel D!");
    var nivel = changeInnerHtml("nivel", "Nivel D!");
  }
  */
  switch (true) {
    case (n >= 85):
      console.info("Nivel A!");
      var nivel = changeInnerHtml("nivel", "Nivel A!");
      break;
    case (n >= 70 && n < 85):
      console.info("Nivel B!");
      var nivel = changeInnerHtml("nivel", "Nivel B!");
      break;
    case (n >= 50 && n < 70):
      console.warn("Nivel C!");
      var nivel = changeInnerHtml("nivel", "Nivel C!");
      break;
    case (n < 50):
      console.error("Nivel D!");
      var nivel = changeInnerHtml("nivel", "Nivel D!");
      break;
  }
}
