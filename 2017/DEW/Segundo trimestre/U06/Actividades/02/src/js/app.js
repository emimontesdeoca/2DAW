//#region Constantes

//#region LOGICA

var map = null;
const globalArray = [];
cargarArrayGlobal();

//#endregion

//#region VISTA

const tipoDeBusquedaHTML =
  "<fieldset class='form-group animated fadeIn' id='panelGenerado'><div class='row'><legend class='animated fadeIn col-form-legend col-sm-4'>Tipo de busqueda</legend><div class='col-sm-8'><div class='form-check'><label class='form-check-label'><input class='form-check-input' type='radio' name='tipoBusqueda' value='nombre' onchange='generarTipoBusqueda()'> Nombre</label></div><div class='form-check'><label class='form-check-label'><input class='form-check-input' type='radio' name='tipoBusqueda' value='pais' onchange='generarTipoBusqueda()'> Pais</label></div></div></div></fieldset><div class='form-group row animated fadeIn' id='contenedorBusqueda'></div>";
const tipoDeBusquedaHTMLProfesores =
  "<fieldset class='form-group animated fadeIn' id='panelGenerado'><div class='form-group row animated fadeIn' id='contenedorBusqueda'></div>";
const tipoBusquedaPais =
  "<label for='inputPais'class='col-sm-4 col-form-label animated fadeIn'>Paises</label><div class='animated fadeIn col-sm-8'><select id='inputPais' class='form-control' onchange='filtroPorPais(this)'></select></div>";
const checkboxesCiclos =
  "<div class='col-sm-4 animated fadeIn'>Nombre de ciclos</div><div class='col-sm-8 animated fadeIn' id='contenedorCheckboxes'></div>";
const botonBuscar =
  "<div id='btnBuscarDiv' class='buttons text-center buttonbuscar animated fadeIn'><button type='button' class='btn btn-primary' id='btnBuscar' data-toggle='modal' data-target='#busquedaModal' onclick='buscar()' >Buscar</button></div>";

const containerGeneracion = document.getElementById("panelGenerado");

//#endregion

//#endregion

//#region Vista

function generarBusqueda(e) {
  if (e.value == "Grado Medio" || e.value == "Grado Superior") {
    containerGeneracion.innerHTML = tipoDeBusquedaHTML;
  } else if (e.value == "Profesorado") {
    containerGeneracion.innerHTML = tipoDeBusquedaHTMLProfesores;
    generarComboboxPaises();
  } else {
    containerGeneracion.innerHTML = "";
  }
}

function generarCheckboxesCiclos(e) {
  let container = document.getElementById("contenedorBusqueda");
  container.insertAdjacentHTML("beforeend", checkboxesCiclos);
  let contenedorCheckboxes = document.getElementById("contenedorCheckboxes");

  let filteredByCiclos = [];

  for (let i = 0; i < globalArray.length; i++) {
    let tipo = globalArray[i].tipo;
    let tipofiltro = e.value;
    if (tipo == tipofiltro) {
      let ciclo = globalArray[i].ciclo;
      if (filteredByCiclos.indexOf(ciclo) == -1) {
        filteredByCiclos.push(ciclo);
      }
    }
  }

  for (let index = 0; index < filteredByCiclos.length; index++) {
    let div = document.createElement("div");
    div.className = "form-check";

    let label = document.createElement("label");
    label.className = "form-check-label";

    let input = document.createElement("input");
    input.type = "checkbox";
    input.name = "ciclo";
    input.className = "form-check-input";
    input.value = filteredByCiclos[index];
    input.addEventListener("change", filtroPorCiclo, false);

    let text = document.createTextNode(filteredByCiclos[index]);

    label.appendChild(input);
    label.appendChild(text);
    div.appendChild(label);
    contenedorCheckboxes.appendChild(div);
  }
}

function generarComboboxPaises() {
  let container = document.getElementById("contenedorBusqueda");
  container.insertAdjacentHTML("beforeend", tipoBusquedaPais);
  let paisesSelect = document.getElementById("inputPais");

  var opt = document.createElement("option");
  opt.innerHTML = "Seleccione un pais";
  opt.value = "ninguno";
  paisesSelect.appendChild(opt);

  let paisesByTipo = [];

  let e = document.getElementById("inputTipoMovilidad").value;

  for (let i = 0; i < globalArray.length; i++) {
    let tipo = globalArray[i].tipo;
    let tipofiltro = e;
    if (tipo == tipofiltro) {
      let pais = globalArray[i].pais;
      if (paisesByTipo.indexOf(pais) == -1) {
        paisesByTipo.push(pais);
      }
    }
  }

  for (var i = 0; i < paisesByTipo.length; i++) {
    var opt = document.createElement("option");
    opt.value = paisesByTipo[i];
    opt.innerHTML = paisesByTipo[i];
    paisesSelect.appendChild(opt);
  }
}

function generarTipoBusqueda() {
  let e = document.querySelector('input[name="tipoBusqueda"]:checked');
  let mov = document.getElementById("inputTipoMovilidad");
  clearBusqueda("contenedorBusqueda");
  if (e.value == "nombre") {
    generarCheckboxesCiclos(mov);
  } else {
    generarComboboxPaises();
  }
}

function clearBusqueda(div) {
  var myNode = document.getElementById(div);
  if (myNode != null) {
    while (myNode.firstChild) {
      myNode.removeChild(myNode.firstChild);
    }
  }
}

function filtroPorPais(e) {
  let value = e.value;
  var myNode = document.getElementById("btnBuscarDiv");

  if (myNode != null) {
    while (myNode.firstChild) {
      myNode.removeChild(myNode.firstChild);
    }
    document
      .getElementById("contenedorBusqueda")
      .removeChild(document.getElementById("btnBuscarDiv"));
  }

  if (value != null && value != "ninguno") {
    let container = document.getElementById("contenedorBusqueda");
    container.insertAdjacentHTML("beforeend", botonBuscar);
  }
}

function filtroPorCiclo() {
  var checkedBoxes = document.querySelectorAll('input[name="ciclo"]:checked');
  var myNode = document.getElementById("btnBuscarDiv");

  if (checkedBoxes.length > 0 && myNode == null) {
    let container = document.getElementById("contenedorBusqueda");
    container.insertAdjacentHTML("beforeend", botonBuscar);
  } else if (checkedBoxes.length == 0 && myNode != null) {
    if (myNode != null) {
      while (myNode.firstChild) {
        myNode.removeChild(myNode.firstChild);
      }
      document
        .getElementById("contenedorBusqueda")
        .removeChild(document.getElementById("btnBuscarDiv"));
    }
  }
}

//#endregion

//#region Logica

function cargarArrayGlobal() {
  for (let index = 0; index < data.length; index++) {
    const e = data[index];
    var m = new movilidad(e.tipo, e.ciclo, e.pais, e.ciudad);
    globalArray.push(m);
  }
}

function buscar() {
  setTimeout(function() {
    google.maps.event.trigger(map, "resize");
    initMap();
  }, 500);
}

//#endregion
function myMap() {
  var mapProp = {
    center: new google.maps.LatLng(51.508742, -0.12085),
    zoom: 5
  };
  map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
}
