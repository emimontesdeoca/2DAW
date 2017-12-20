/// SELECTORES
/// 1 Seleccionar todos los elementos div que poseen la clase “module”
$(".module").find("div");

/// 2 Especificar tres selecciones que puedan seleccionar el tercer ítem de la lista desordenada #myList. ¿Cuál es el mejor para utilizar? ¿Porqué?
$("#myList")
  .find("li")
  .first()
  .next()
  .next();

$("#myList")
  .children("li")
  .first()
  .next()
  .next();

$("#myList")
  .children("li:odd")
  .first()
  .next();
/// 3 Seleccionar el elemento label del elemento input utilizando un selector de atributo.
elmLabel = $("body").find(
  "[for=" +
    $("body")
      .find("input")
      .attr("name") +
    "]"
);
console.log("Elementos label del elemento input: " + elmLabel);
/// 4 Averiguar cuantos elementos en la página están ocultos (ayuda: .length).

console.log("Elementos ocultos: " + $("body").find(":hidden").length);
/// 5 Averiguar cuantas imágenes en la página poseen el atributo alt
console.log("Imagenes con alt: " + $("img[alt]").length);
/// 6 Seleccionar todas las filas impares del cuerpo de la tabla
var impar = $("tr").filter(":odd");

/// RECORRER DOM

/// 1  Seleccionar todas las imágenes en la página; registrar en la consola el atributo alt de cada imagen.
$("img").each(function() {
  console.log($(this).attr("alt"));
});
/// 2 Seleccionar el elemento input, luego dirigirse hacia el formulario y añadirle una clase al mismo.
$("input")
  .closest("form")
  .addClass("UnaClase");

/// 3 Seleccionar el ítem que posee la clase “current” dentro de la lista #myList y remover dicha clase en el elemento; luego añadir la clase “current” al siguiente ítem de la lista.
seleccionado = $("#myList").find(".current");
seleccionado.removeClass("current");
seleccionado.next().addClass("current");
/// 4  Seleccionar el elemento select dentro de #specials; luego dirigirse hacia el botón submit.
elmSelect = $("#specials").find("select");
elmSelect
  .parent()
  .next()
  .children();
/// 5 Seleccionar el primer ítem de la lista en el elemento #slideshow; añadirle la clase “current” al mismo y luego añadir la clase “disabled” a los elementos hermanos.
primerItemSlide = $("#slideshow")
  .children()
  .first();
primerItemSlide.addClass("current");
primerItemSlide.siblings().addClass("disabled");
/// MANIPULACION

/// 1  Añadir 5 nuevos ítems al final de la lista desordenada #myList.

var myItems = [],
  $myList = $("#myList");
for (var i = 0; i <= 5; i++) {
  myItems.push("<li>Elemento  " + i + " Añadido</li>");
}
$myList.append(myItems.join(""));

/// 2  Remover los ítems impares de la lista.
$myList.find(":even").remove();
/// 3  Añadir otro elemento h2 y otro párrafo al último div.module.
$("div")
  .find(".module")
  .last()
  .append("<h2>Elemento h2</h2><p>Parrafo añadido</p>");
/// 4  Añadir otra opción al elemento select; darle a la opción añadida el valor “Wednesday”.
elmOption = "<option value='wednesday'>Wednesday</option>";
elmSelect.append(elmOption);
/// 5  Añadir un nuevo div.module a la página después del último; luego añadir una copia de una de las imágenes existentes dentro del nuevo div.
img = $("img").first();
copia = img.clone(true);
nuevoDivModule = "<div class='module'></div>";

$("div.module")
  .last()
  .after(nuevoDivModule);
$("div.module")
  .last()
  .append(copia);
/// SUGERENCIA

/// 1    Establecer el valor del elemento input igual al valor del elemento label.
valorElementoLabel = $("label").text(); /// PREGUNTAR POR .VAL()
$Input = $(".input_text");
$Input.val(valorElementoLabel);
/// 2    Añadir la clase “hint” al elemento input.
$Input.addClass("hint");
/// 3    Remover el elemento label.
$("label").remove();
/// 4    Vincular un evento focus en el input para remover el texto de sugerencia y la clase “hint”.
$(document).ready(function() {
  $("form").on("focusin", ".input_text", function() {
    $(this).val("");
    $(this).removeClass("hint");
  });
});
/// 5    Vincular un evento blur en el input para restaurar el texto de sugerencia y la clase “hint” en caso que no se haya ingresado algún texto.
$(document).ready(function() {
  $("form").on("blur", ".input_text", function() {
    if ($.trim($(".input_text").val()) === "") {
      $(this).val(valorElementoLabel);
      $(this).addClass("hint");
    }
  });
});
/// NAVEGACION POR PESTAÑAS

/// 1 Ocultar todos los elementos div.module.
var a = $("div.module").attr("hidden", "true");

/// 2  Crear una lista desordenada antes del primer div.module para utilizar como pestañas.
var lista = $("div.module");

$("div.module")
  .first()
  .before("<ul></ul>");

$Ul = $("div.module")
  .prev()
  .closest("ul");

/// 3  Interactuar con cada div utilizando $.fn.each. Por cada uno, utilizar el texto del elemento h2 como el texto para el ítem de la lista desordenada.

var listanombres = [];

for (let index = 0; index < lista.length; index++) {
  const element = lista[index];
  var n = $(element).children()[0].outerText;
  listanombres.push(n);
}

for (let index = 0; index < listanombres.length; index++) {
  $Ul.append("<li>" + listanombres[index] + "</li>");
}

/// 4  Vincular un evento click a cada ítem de la lista de forma que:

/// 4.1 muestre el div correspondiente y oculte el otro;
/// 4.2  añada la clase “current” al ítem seleccionado;
/// 4.3  remueva la clase “current” del otro ítem de la lista.

$Ul
  .children()
  .first()
  .on("click", function() {
    $("div.module")
      .first()
      .addClass("current")
      .css("display", "inline");
    $("div.module")
      .first()
      .next()
      .removeClass("current")
      .css("display", "none");
    $("div.module")
      .first()
      .next()
      .next()
      .removeClass("current")
      .css("display", "none");

    $("div#blog")
      .find("p")
      .first()
      .slideDown();
  });

$Ul
  .children()
  .first()
  .next()
  .on("click", function() {
    $("div.module")
      .first()
      .removeClass("current")
      .css("display", "none");
    $("div.module")
      .first()
      .next()
      .addClass("current")
      .css("display", "inline");
    $("div.module")
      .first()
      .next()
      .next()
      .removeClass("current")
      .css("display", "none");
  });

$Ul
  .children()
  .first()
  .next()
  .next()
  .on("click", function() {
    $("div.module")
      .first()
      .removeClass("current")
      .css("display", "none");
    $("div.module")
      .first()
      .next()
      .removeClass("current")
      .css("display", "none");
    $("div.module")
      .first()
      .next()
      .next()
      .addClass("current")
      .css("display", "inline");
  });

/// 5  Finalmente, mostrar la primera pestaña.

/// MOSTRAR OCULTAR TEXTO

/// 1  Al hacer click en alguno de los titulares del div #blog, se debe mostrar el párrafo correspondiente con un efecto de deslizamiento;

$("div#blog")
  .find("a")
  .on("click", function() {
    $("div#blog")
      .find("p")
      .slideUp();
    $(this)
      .parent()
      .next()
      .slideDown();
  });

/// 2  Al hacer click en otro titular, se debe ocultar el párrafo mostrado con un efecto de deslizamiento y mostrar nuevamente el párrafo correspondiente también con un efecto de deslizamiento. Ayuda: No se olvide de utilizar el selector :visible.

/// MENU DESPLEGABLE

/// 1 Al pasar el puntero del ratón por encima de un ítem del menú, se debe mostrar su submenú en caso que exista;
$("#nav")
  .find("li")
  .hover(function() {
    $(this)
      .find("ul")
      .slideDown();
  });
/// 2 Al no estar más encima de un ítem, el submenú se debe ocultar
$("#nav")
  .find("li")
  .hover(
    function() {
      $(this)
        .find("ul")
        .slideDown();
    },
    function() {
      $(this)
        .find("ul")
        .slideUp();
    }
  );

/// CREAR SLIDESHOW

/// 1  Mover el elemento #slideshow a la parte superior de la página;

$("#slideshow").prependTo("#main");

/// 2  Escribir un código que permita mostrar los ítems de forma cíclica, mostrando un ítem por unos segundos, luego ocultándolo con un efecto fade out y mostrando el siguiente con un efecto fade in;

$("#slideshow")
  .children()
  .hide();

var i = 0;

setInterval(function() {
  if (i == 3) {
    i = 0;
  }
  console.log(i);
  if (i < 3) {
    try {
      $("#slideshow")
        .children()
        .eq(i - 1)
        .fadeOut()
        .hide();
    } catch (error) {}

    $("#slideshow")
      .children()
      .eq(i)
      .fadeIn();
    i++;
  }
}, 2000);

/// 3  Una vez llegado al último ítem de la lista, comenzar de nuevo con el primero;

/// 4  Incluir un área de navegación por debajo del slideshow que muestre cuantas imágenes existen y en cual se encuentra (ayuda: $.fn.prevAllpuede resultar útil).
