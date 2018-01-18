var svgns = "http://www.w3.org/2000/svg";
var xlinkns = "http://www.w3.org/1999/xlink";
var estado = "";
var cont = document.getElementById("contenedor");
var arr = JSON.parse(localStorage.getItem("asientos"));

if (arr == null) {
  createJson();
  arr = JSON.parse(localStorage.getItem("asientos"));
}

function cambiar(e) {
  if ($(e.srcElement).hasClass("selected")) {
    $(e.srcElement).removeClass("selected");
    $(e.srcElement).addClass("noSelected");
    e.srcElement.setAttribute("estado", "libre");
  } else {
    $(e.srcElement).addClass("selected");
    $(e.srcElement).removeClass("noSelected");
    e.srcElement.setAttribute("estado", "reservado");
  }
}

function clearJson() {
  localStorage.removeItem("asientos");
  createJson();
  loadJson();
}

function createJson() {
  var json = [];

  var cont = 0;
  for (let index = 0, x = -300; index < 5; index++, x += 300) {
    for (let index = 0, y = -50; index < 5; index++, y += 300, cont++) {
      var object = {
        id: cont,
        x: x,
        y: y,
        estado: "libre"
      };
      json.push(object);
    }
  }
  localStorage.setItem("asientos", JSON.stringify(json));
}

function loadJson() {
  arr = JSON.parse(localStorage.getItem("asientos"));

  var uses = document.querySelectorAll("use");

  uses.forEach(element => {
    cont.removeChild(element);
  });

  arr.forEach(element => {
    var use = document.createElementNS(svgns, "use");
    use.setAttributeNS(xlinkns, "href", "#copa");
    use.setAttribute("x", element.x);
    use.setAttribute("y", element.y);
    use.setAttribute("id", element.id);

    use.setAttribute("estado", element.estado);

    if (element.estado == "reservado") {
      use.setAttribute("class", "copa ocupado");
    } else {
      use.setAttribute("class", "copa noSelected");
      addEventListener("click", cambiar, false);
    }

    cont.appendChild(use);
  });
}

function updateJson() {
  var uses = document.querySelectorAll("use[estado='reservado']");

  arr.forEach(element => {
    uses.forEach(use => {
      if (element.id == parseInt(use.id)) {
        element.estado = use.getAttribute("estado");
      }
    });
  });

  localStorage.setItem("asientos", JSON.stringify(arr));

  loadJson();
}

$(document).ready(function() {
  loadJson();
});
