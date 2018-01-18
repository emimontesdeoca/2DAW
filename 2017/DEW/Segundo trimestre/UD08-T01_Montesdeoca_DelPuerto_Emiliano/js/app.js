var $gallery = $("#gallery");

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

$(document).ready(function() {
  // Contenedores
  var c = document.getElementById("gallery");
  var ci = document.getElementById("islas");

  // Numero random de islas
  var random = Math.floor(Math.random() * (6 - 3 + 1)) + 3;
  var aIslas = [];

  // Crear ids para las islas, que nunca se repitan
  var arr = [];
  while (arr.length < random) {
    var randomnumber = Math.floor(Math.random() * (6 - 0 + 1)) + 0;
    if (arr.indexOf(randomnumber) > -1) continue;
    arr[arr.length] = randomnumber;
  }

  /// Utilizando el array de islas agregar dependiendo el id generado en el arr
  arr.forEach(element => {
    aIslas.push(arrayIslasCrear[element]);
  });

  // Crea las islas con su respectiva informacion
  aIslas.forEach(element => {
    let div = document.createElement("div");
    div.setAttribute("id", element.name);
    div.setAttribute("isla", element.att);
    div.setAttribute(
      "class",
      "contenedor-imgs ui-widget-content ui-state-default"
    );

    let h4 = document.createElement("h4");
    h4.setAttribute("class", "ui-widget-header");
    h4.innerHTML = element.title;

    div.appendChild(h4);

    ci.appendChild(div);
  });

  console.log(aIslas);

  // Crear las imagenes
  for (let index = 0; index < 5; index++) {
    var li = document.createElement("li");
    li.setAttribute(
      "class",
      "ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle"
    );
    li.setAttribute("isla", "elhierro");

    var h5 = document.createElement("h5");
    h5.setAttribute("class", "ui-widget-header");
    h5.innerHTML = "elhierro";

    li.appendChild(h5);

    var img = document.createElement("img");
    img.setAttribute("src", "images/elhierro/uno.jpg");
    img.setAttribute("width", "96");
    img.setAttribute("height", "72");
    img.setAttribute("alt", "hola");

    li.appendChild(img);

    c.appendChild(li);
  }

  $("li", $gallery).draggable({
    cancel: "a.ui-icon", // clicking an icon won't initiate dragging
    revert: "invalid", // when not dropped, the item will revert back to its initial position
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
      classes: {
        "ui-droppable-active": "ui-state-highlight"
      },
      drop: function(event, ui) {
        deleteImage(ui.draggable, $(this));
        console.log(ui);
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
    });
  }
});
