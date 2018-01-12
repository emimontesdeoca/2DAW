// Seleccionar todos los elementos div que poseen la clase “media”.

var a = $("div[class='media']");
// console.log(a);

// Contar el número de opciones del menú de navegación superior de la página y mostrar su nombre por consola.

var b = $(".nav.navbar-nav > li").length;
// console.log(b);

// Seleccionar el primer elemento p de la clase lead y mostrar su contenido html.

var c = $(".lead").first().text();
// console.log(c);

// Cambiar las imágenes de la parte final del documento que tienen justo a continuación un <h4> con el texto "Start Bootstrap..." 
// por otras imágenes diferentes. En este punto se debe usar $.fn.each.

var d = $(".media");
console.log(d);

d.each(function () {
    $(this).find("img").attr("src", "images/-text.png");
});

// Posicionarte en el botón del formulario y a partir de ahí añadir una imagen justo antes del formulario que use la clase "img-responsive".

var e = $("form > button").first().parent().before("<img src='images/-text_peq.png' class='img-responsive' />");
// console.log(e);

// Eliminar el elemento div que está contenido en el último div con clase .media.

var f = $("div[class='media']").last().last().remove();
// console.log(f);

// Seleccionar la primera lista de categorías y luego añadir un nuevo elemento.

var g = $("a:contains('Category Name')").first().parent().parent().append("<li><a href='#'>Emi</a></li>");
// console.log(g);

// Copiar la imagen que está al principio del documento en un div que estará ubicado justo antes del footer.

var h = $("img.img-responsive").first();
var h1 = $("footer").prev().prev().append(h.clone());
// console.log(h1);

// Eliminar los elementos pares de la segunda lista de categorías y al resto de elementos establecerle una clase css que 
// hayas creado o bien una de las existentes.

var i = $("ul.list-unstyled").eq(1).children(":even").remove();
// console.log(i);

// Hay que añadir interactividad al párrafo que está justo a continuación del h2 del contenido. Es decir, al hacer click sobre 
// el texto de la cabecera h2 se debe ocultar el párrafo con un efecto de deslizamiento y si volvemos a hacer click sobre el 
// encabezado volveremos a mostrar el texto nuevamente.

var j = $("h2");

$("h2").on("click", function () {
    j.next().fadeToggle();
});

// Añadir una validación al botón del formulario que existe en al página para dejar sugerencias de manera que al hacer click sobre el botón, 
// se compruebe si el usuario ha escrito un comentario. Si lo ha hecho, no haremos nada, y si no ha introducido ningún comentario le mostraremos 
// un alert al usuario indicando que debe introducir un mensaje.

$(document).ready(function () {

    var k = $("form > button");

    k.on("click", function () {
        var k1 = $("form textarea").first().val();

        if (k1.length == 0) {
            alert("Tienes que introducir un mensaje");
        }
    });
});