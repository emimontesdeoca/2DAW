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
    window.open('views/padre.html', 'Padre');
}