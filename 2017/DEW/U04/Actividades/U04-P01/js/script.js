function crearTabla() {
  /// Alto y ancho introducidos por usuario
  var alto = parseInt(document.getElementById('alto').value);
  var ancho = parseInt(document.getElementById('ancho').value);

  /// Si no son numero, valor por defecto es 20
  if (isNaN(alto)) {
    alto = 20;
  }
  if (isNaN(ancho)) {
    ancho = 20;
  }
  /// Si la tabla existe, borrarla
  var table = document.getElementById('tabla');
  if (table) {
    table.parentNode.removeChild(table)
  }

  /// Crea tabla
  var tabla = document.createElement("table");
  tabla.id = "tabla";
  tabla.setAttribute("style", "margin: 0 auto;")
  for (var i = 0; i < alto; i++) {
    var tr = document.createElement("tr");
    for (var j = 0; j < ancho; j++) {
      var td = document.createElement("td");
      td.id = "td" + i + j;
      tr.appendChild(td);
    }
    tabla.appendChild(tr);
  }
  document.getElementsByClassName('container')[0].appendChild(tabla);
  /// Pintar la tabla
  pintarTabla();
}

function resetTabla() {
  /// Valores por defecto a los bucles
  document.getElementById('formula').value = "";
  document.getElementById('alto').value = "";
  document.getElementById('ancho').value = "";
  document.getElementById('principal').value = "#ffffff";
  document.getElementById('secundario').value = "#000000";

  /// Crea la tabla con valores por defectto
  crearTabla();
}

function resetCSS() {
  /// Objeto archivo css
  var styleSheet = document.styleSheets[0];

  /// Array de CSS por defecto
  const css = ['table {  border: solid 1px black;  border-collapse: collapse;}',
    'td { height: 20px; width: 20px; padding: 0; border: solid 0.2px black; background-color:white;}',
    'input {margin-left: 10px;margin-bottom: 10px;}',
    '*{font-family: "Arial"}'
  ]
  /// Borrar todos los CSS actuales, sirve para limpiar los estilos actuales
  try {
    /// styleSheet no tiene .length para poder conseguir el ultimo numero asi que uso el max value de integer
    for (var i = 0; i < Number.MAX_SAFE_INTEGER; i++) {
      /// Borrar esa norma css hasta que de excepcion de rango asi sale del bucle
      styleSheet.deleteRule(i);
    }
  } catch (e) {}

  /// Agregar el CSS por defecto
  for (var i = 0; i < css.length; i++) {
    styleSheet.insertRule(css[i], styleSheet.length - 1);
  }
}

function pintarTabla() {
  /// Borrar CSS actual
  resetCSS();

  /// Conseguir los colores por usuario, siempre tienen valor asi que no hace falta
  /// controlar si son nulos
  var colorPrincipal = document.getElementById('principal').value;
  var colorSecundario = document.getElementById('secundario').value;

  /// Conseguir formula por usuario
  var nthchild = document.getElementById('formula').value;
  /// Si es nulo, utilizo uno default
  if (nthchild == "") {
    nthchild = "even";
  }
  /// Conseguir el CSS actual
  var styleSheet = document.styleSheets[0];

  /// Normas CSS
  var principal = 'td { background-color: ' + colorPrincipal + ' !important}';
  var secundario = 'td:nth-child(' + nthchild + ')  { background-color: ' + colorSecundario + ' !important}';

  /// Agregarlas al CSS
  styleSheet.insertRule(principal, styleSheet.length - 1);
  styleSheet.insertRule(secundario, 2);
}

function crearInputLabel(labelname, type, id) {
  /// Objeto tipo label
  var label = document.createElement("label");
  /// Texto de label
  label.innerHTML = labelname + ":";

  /// Nuevo input
  var input = document.createElement("input");
  /// Tipo e ID asignado por valores de funcion
  input.type = type;
  input.id = id;
  input.size = 10;

  /// Para que no sea siempre negro en caso de default, asigno blanco al principal
  if (id == "principal") {
    input.value = "#ffffff";
  }

  /// Agregar las 3 elementos y un br para separar
  document.getElementsByClassName('container')[0].appendChild(label);
  document.getElementsByClassName('container')[0].appendChild(input);
  document.getElementsByClassName('container')[0].appendChild(document.createElement("br"));
}

function crearInputBoton(name, id, func) {
  /// Nuevo input
  var input = document.createElement("input");
  /// ID y value por parametros de funcion
  input.type = "button";
  input.id = id;
  input.value = name;

  /// La funcion depende del boton
  input.addEventListener('click', function() {
    if (id == "generar") {
      crearTabla();
    } else if (id == "reset") {
      resetTabla();
    } else if (id == "guardar") {
      guardarInputs();
    } else if (id == "cargar") {
      cargarInputs();
    }
  });
  /// Añadir al dom
  document.getElementsByClassName('container')[0].appendChild(input);
}

function guardarInputs() {
  /// Crear objeto inputs con los valores
  var inputs = {
    'funcion': document.getElementById('formula').value,
    'alto': parseInt(document.getElementById('alto').value),
    'ancho': parseInt(document.getElementById('ancho').value),
    'principal': document.getElementById('principal').value,
    'secundario': document.getElementById('secundario').value
  };

  /// Parsear a JSON y guardar en localStorage
  localStorage.setItem('inputs', JSON.stringify(inputs));
}

function cargarInputs() {
  /// Parsear JSON del locasltorage
  var inputs = JSON.parse(localStorage.getItem('inputs'));

  if (inputs != null) {
    /// Valores por defecto a los bucles
    document.getElementById('formula').value = inputs.funcion;
    document.getElementById('alto').value = inputs.alto;
    document.getElementById('ancho').value = inputs.ancho;
    document.getElementById('principal').value = inputs.principal;
    document.getElementById('secundario').value = inputs.secundario;
  }

  /// Recrear la tabla con los valores cargados
  crearTabla();
}

/// Crear objetos del DOM
crearInputLabel("Formula", "text", "formula");
crearInputLabel("Alto", "text", "alto");
crearInputLabel("Ancho", "text", "ancho");
crearInputLabel("Color principal", "color", "principal");
crearInputLabel("Color secundario", "color", "secundario");
crearInputBoton("Generar", "generar");
crearInputBoton("Reset", "reset");
document.getElementsByClassName('container')[0].appendChild(document.createElement("br"));
crearInputBoton("Guardar localStorage", "guardar");
crearInputBoton("Cargar localStorage", "cargar");

/// Crear la tabla
crearTabla();
