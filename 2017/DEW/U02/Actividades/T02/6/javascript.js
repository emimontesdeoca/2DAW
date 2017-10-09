/*Solicitar que el usuario escriba alguna de estas cuatro palabras
(profesor, manzana, servidor, mar) para luego mostrar la palabra traducida
en inglés. Es decir, si se ingresa 'mar' debemos mostrar el texto 'sea' en
la página. Solo se admiten estas palabras como entradas permitidas.*/


function mainEjercicio6() {

var dic = [{
    "word": "profesor",
    "trad": "teacher"
  },
  {
    "word": "manzana",
    "trad": "apple"
  },
  {
    "word": "servidor",
    "trad": "server"
  },
  {
    "word": "mar",
    "trad": "sea"
  }
]

function getTraduction(word) {
  return dic.filter(dic => dic.word == word)[0].trad;
}

var a = prompt("Introduzca una de estas palabras: profesor, manzana, servidor, mar:");

var old = document.getElementById("old").innerHTML = a;

var newt = document.getElementById("newt").innerHTML = getTraduction(a);

}
