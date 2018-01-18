var $gallery = $("#gallery");
var numeroIslasValue = 4;
var nombreJugador = "Jugador";
var score = 0;
var titScore = document.getElementById("puntuacion-titulo");
titScore.innerHTML = score;
var arrayIslas = [
  ($lapalma = $("#Lapalma")),
  ($elhierro = $("#Elhierro")),
  ($lagomera = $("#Lagomera")),
  ($tenerife = $("#Tenerife")),
  ($grancanaria = $("#Grancanaria")),
  ($lanzarote = $("#Lanzarote")),
  ($fuerteventura = $("#Fuerteventura"))
];

var arrayIslasCrear = [
  { id: 0, name: "Lapalma", title: "La Palma", att: "lapalma" },
  { id: 1, name: "Elhierro", title: "El Hierro", att: "elhierro" },
  { id: 2, name: "Lagomera", title: "La Gomera", att: "lagomera" },
  { id: 3, name: "Tenerife", title: "Tenerife", att: "tenerife" },
  { id: 4, name: "Grancanaria", title: "Gran Canaria", att: "grancanaria" },
  {
    id: 5,
    name: "Fuerteventura",
    title: "Fuerteventura",
    att: "fuerteventura"
  },
  { id: 6, name: "Lanzarote", title: "Lanzarote", att: "lanzarote" }
];

function borrar() {
  // Contenedores
  var c = document.getElementById("gallery");
  /// Borrar lo que tiene dentro
  while (c.firstChild) {
    c.removeChild(c.firstChild);
  }

  var ci = document.getElementById("islas");
  /// Borrar lo que tiene dentro
  while (ci.firstChild) {
    ci.removeChild(ci.firstChild);
  }
}

function jugar() {
  score = 0;
  titScore.innerHTML = score;
  // Contenedores
  var c = document.getElementById("gallery");
  /// Borrar lo que tiene dentro
  while (c.firstChild) {
    c.removeChild(c.firstChild);
  }

  var ci = document.getElementById("islas");
  /// Borrar lo que tiene dentro
  while (ci.firstChild) {
    ci.removeChild(ci.firstChild);
  }

  // Numero random de islas
  var numeroIslas = parseInt(numeroIslasValue);
  var numeroImagenes = numeroIslas + 2;
  var imagenesRestantes = numeroImagenes - numeroIslas;
  var aIslas = [];

  // Crear ids para las islas, que nunca se repitan
  var arr = [];
  while (arr.length < numeroIslas) {
    var randomnumber = Math.floor(Math.random() * (6 - 0 + 1)) + 0;
    if (arr.indexOf(randomnumber) > -1) continue;
    arr[arr.length] = randomnumber;
  }

  /// Randomizar el array
  shuffle(arrayIslasCrear);
  /// Utilizando el array de islas agregar dependiendo el id generado en el arr
  arr.forEach(element => {
    aIslas.push(arrayIslasCrear[element]);
  });

  // Crea las islas con su respectiva informacion
  aIslas.forEach(element => {
    let div = document.createElement("div");
    div.setAttribute("id", element.name);
    div.setAttribute("isla", element.att);
    div.setAttribute("class", "contenedor-imgs ");

    let h4 = document.createElement("h4");
    h4.setAttribute("class", "ui-widget-header");
    h4.innerHTML = element.title;

    div.appendChild(h4);

    ci.appendChild(div);
  });

  // Conseguir imagenes teniendo las islas ya
  var arrayIslasNombre = [];

  aIslas.forEach(element => {
    var a = { title: element.title, att: element.att };
    arrayIslasNombre.push(a);
  });

  shuffle(arrayIslasNombre);

  var arrayIslasFinal = [];
  var finalArray = [];

  /// Una imagen por cada isla
  for (let index = 0; index < arrayIslasNombre.length; index++) {
    const element = arrayIslasNombre[index];
    var imagenumber = Math.floor(Math.random() * (4 - 0) + 0);
    arrayIslasFinal.push(imagenumber);
  }

  for (let index = 0; index < arrayIslasFinal.length; index++) {
    var att = arrayIslasNombre[index].att;
    var title = arrayIslasNombre[index].title;
    var imgN = arrayIslasFinal[index];
    var path = "images/" + att + "/" + imgN + ".jpg";

    var obj = { att: att, title: title, path: path };

    if (finalArray.indexOf(obj) == -1) {
      finalArray.push(obj);
    } else {
      index--;
    }
  }

  // Imagenes retantes
  arrayIslasFinal = [];
  for (let index = 0; index < imagenesRestantes; index++) {
    const element = arrayIslasNombre[index];
    var imagenumber = Math.floor(Math.random() * (4 - 0) + 0);
    arrayIslasFinal.push(imagenumber);
  }

  for (let index = 0; index < imagenesRestantes; index++) {
    var att = arrayIslasNombre[index].att;
    var title = arrayIslasNombre[index].title;
    var imgN = arrayIslasFinal[index];
    var path = "images/" + att + "/" + imgN + ".jpg";

    var obj = { att: att, title: title, path: path };

    if (finalArray.indexOf(obj) == -1) {
      finalArray.push(obj);
    } else {
      index--;
    }
  }
  console.log(finalArray);

  // shuffle(finalArray);
  // Crear las imagenes
  finalArray.forEach(element => {
    var li = document.createElement("li");
    li.setAttribute(
      "class",
      "ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle"
    );
    li.setAttribute("isla", element.att);

    var h5 = document.createElement("h5");
    h5.setAttribute("class", "ui-widget-header");
    h5.innerHTML = element.title;

    // li.appendChild(h5);

    var img = document.createElement("img");
    img.setAttribute("src", element.path);
    img.setAttribute("width", "96");
    img.setAttribute("height", "150");
    img.setAttribute("alt", "hola");

    li.appendChild(img);

    c.appendChild(li);
  });

  $("li", $gallery).draggable({
    cancel: "a.ui-icon", // clicking an icon won't initiate dragging
    revert: "invalid",
    revert: function(event) {
      if (event == false) {
        toastr.error("Se ha equivocado, -2 puntos!", "Mal!");
        score -= 2;
        titScore.innerHTML = score;
        return "invalid";
      } else {
        score += 5;
        toastr.success("Ha acertado, +5 puntos!", "Bien!");
        titScore.innerHTML = score;
      }
    },
    containment: "document",
    helper: "clone",
    cursor: "move"
  });

  aIslas.forEach(element => {
    $elemento = $("#" + element.name);

    let isla = $elemento[0].getAttribute("isla");
    let string = "#gallery > li[isla='" + isla + "']";

    $elemento.droppable({
      accept: string,
      // classes: {
      //   "ui-droppable-active": "ui-state-highlight"
      // },
      drop: function(event, ui) {
        deleteImage(ui.draggable, $(this));
      }
    });
  });

  function deleteImage($item, $isla) {
    $item.fadeOut(function() {
      var $list = $("ul", $isla).length
        ? $("ul", $isla)
        : $("<ul class='gallery ui-helper-reset'/>").appendTo($isla);

      $item.find("a.ui-icon-trash").remove();
      $item.appendTo($list).fadeIn(function() {
        $item
          .animate({ width: "48px" })
          .find("img")
          .animate({ height: "36px" });
      });

      //console.log(document.querySelector("#gallery").children.length);
      if (document.querySelector("#gallery").children.length == 0) {
        var c = document.getElementById("puntuacion");
        borrar();
        c.innerHTML = score;
        showModalFinPartida();
      }
    });
  }

  function shuffle(array) {
    for (var i = array.length - 1; i > 0; i--) {
      var j = Math.floor(Math.random() * (i + 1));
      var temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  var cT = document.getElementById("contenedor-todo");
  cT.setAttribute("style", "display:inline");
}

function showModalFinPartida() {
  $("#dialog-finpartida").dialog({
    resizable: false,
    height: "auto",
    width: 400,
    modal: true,
    buttons: {
      Reinciar: function() {
        $(this).dialog("close");
        score = 0;
        dialogoInicial();
        // jugar();
      }
    }
  });
}
function dialogoInicial() {
  $("#dialog-confirm").dialog({
    resizable: false,
    height: "auto",
    width: 400,
    modal: true,
    buttons: {
      Jugar: function() {
        var b = document.getElementById("username").value;

        var patt = new RegExp(/^([^0-9]*)$/);
        if (patt.test(b) && b.length != 0) {
          $(this).dialog("close");
          var a = document.getElementById("dificultad").value;
          numeroIslasValue = parseInt(a);

          nombreJugador = b;

          var c = document.getElementById("nombreJugador");
          c.innerHTML = nombreJugador;
          jugar();
          toastr.success("A jugar!", "Bienenido!");
        } else {
          toastr.error("Ha introducido mal el nombre!", "Error!");
        }
      }
    }
  });
}

$(document).ready(dialogoInicial());
