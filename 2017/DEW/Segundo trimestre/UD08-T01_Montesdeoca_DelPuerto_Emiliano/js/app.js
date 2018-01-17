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

arrayIslas.forEach(element => {
  $elemento = element;

  let isla = element[0].getAttribute("isla");
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

/*
<li class="ui-widget-content ui-corner-tr" isla="elhierro">
            <h5 class="ui-widget-header">Uno</h5>
            <img src="images/elhierro/uno.jpg" alt="The peaks of High Tatras" width="96" height="72">
        </li>
*/

$(document).ready(function() {
  var c = document.getElementById("gallery");

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
});
