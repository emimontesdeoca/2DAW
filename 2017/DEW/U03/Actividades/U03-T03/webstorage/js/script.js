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
