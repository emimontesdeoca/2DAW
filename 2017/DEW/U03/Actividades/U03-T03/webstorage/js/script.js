function saveLocalStorage() {
  var frases = [];

  var localStorageFrases = localStorage.getItem('frases');

  if ((frases = JSON.parse(localStorageFrases)) == null) {
    frases = [];
  }

  var storyDiv = document.getElementById("story");
  var name = document.getElementById("name").value;
  var adjective = document.getElementById("adjective").value;
  var noun = document.getElementById("noun").value;

  frase = name + " married a " + adjective + " " + noun + "... So weird!";

  var a = {
    "frase": frase
  };

  frases.push(a);

  localStorage.setItem('frases', JSON.stringify(frases));
}

function saveFormularionOnKeyUp() {
  var formulario = [];

  localStorage.removeItem("formulario");

  var noun = document.getElementById("noun").value;
  var adjective = document.getElementById("adjective").value;
  var name = document.getElementById("name").value;

  var a = {
    "noun": noun,
    "adjective": adjective,
    "name": name,
  };

  formulario.push(a);

  localStorage.setItem('formulario', JSON.stringify(formulario));
  console.log(localStorage.forulario);
}

function getFormularioSavedValues() {
  var formulario = [];

  var localStorageFormulario = localStorage.getItem('formulario');

  if ((formulario = JSON.parse(localStorageFormulario)) != null) {
    console.log(formulario[0]);
    document.getElementById("noun").value = formulario[0].noun;
    document.getElementById("adjective").value = formulario[0].adjective;
    document.getElementById("name").value = formulario[0].name;
  }
};

document.getElementById('megusta').innerHTML += localStorage.getItem('megusta');

function meGusta() {
  var cont = localStorage.getItem('megusta');
  if (cont == null) {
    localStorage.setItem('megusta', 1)
  } else {
    localStorage.setItem('megusta', parseInt(cont) + 1)
  }
};

const preguntas = [{
    "pregunta": "¿Cual es el mejor equipo del mundo?",
    "respuesta": "Uruguay"
  },
  {
    "pregunta": "¿Cual es el peor equipo del mundo?",
    "respuesta": "Argentina"
  },
  {
    "pregunta": "¿Que equipo es un compracopas?",
    "respuesta": "Chile"
  },
  {
    "pregunta": "¿Donde esta el barraquito mas barato?",
    "respuesta": "Instituto"
  },
  {
    "pregunta": "¿Cual es la mejor empresa de todas?",
    "respuesta": "Microsoft"
  },
  {
    "pregunta": "¿Cual es la empresa mas sobrevalorada?",
    "respuesta": "Apple"
  }
];

function nuevaPregunta() {

  var preguntaMostrar = preguntas[Math.floor(Math.random() * preguntas.length)];
  document.getElementById('pregunta').innerHTML = preguntaMostrar.pregunta;

  var respuestaAsteriscos = preguntaMostrar.respuesta;

  for (var i = 0; i < 4; i++) {
    var index = Math.floor(Math.random() * respuestaAsteriscos.length);
    respuestaAsteriscos = respuestaAsteriscos.substr(0, index) + '*' + respuestaAsteriscos.substr(index + 1);
  }

  document.getElementById('respuesta').value = respuestaAsteriscos;

  document.getElementById('respuesta').removeAttribute("disabled");
  document.getElementById('comprobarBtn').removeAttribute("disabled");

}

function comprobar() {
  var bool = false;
  for (var i = 0; i < preguntas.length; i++) {
    if (preguntas[i].respuesta == document.getElementById('respuesta').value) {
      bool = true;
      break;
    }
  }

  var a = localStorage.getItem('respuestas');

  if (a == null) {
    a = "";
  }

  if (bool) {
    alert("Correcta");
  } else {
    alert("Incorrecta");

  }
  localStorage.setItem('respuestas', a + document.getElementById('respuesta').value + ",");
}

function getAllRespuestasAnteriores() {
  document.getElementById('respuestasAnteriores').innerHTML = "";
  var a = localStorage.getItem('respuestas');
  if (a != null) {
    var b = a.split(',');

    for (var i = 0; i < b.length; i++) {
      document.getElementById('respuestasAnteriores').innerHTML += b[i] + "<br/>";
    }
  }
}

function borrarRespuestasAnteriores() {
  localStorage.removeItem('respuestas');
}

getAllRespuestasAnteriores();
