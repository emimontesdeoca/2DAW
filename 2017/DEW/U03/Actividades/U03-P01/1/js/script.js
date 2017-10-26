/// Constante de arrays con colores
const colors = ['red', 'green', 'blue', 'orange', 'yellow', 'lightblue', 'black', 'pink', 'brown'];

function boom() {
  /// Creo la ventana con X,Y tamaños
  var view1 = window.open('about:blank', "", "width=100, height=100");

  /// SetInterval cada 0.5 segundos
  setInterval(function() {

    /// Consigo los parametros de tamaño de la ventana
    var a = view1.innerWidth;
    var b = view1.innerHeight;

    /// Mientras los parametros sean menores que 400
    if (a <= 400 || b <= 400) {

      /// ResizeBy (añade 5px a cada lado)
      view1.resizeBy(5, 5);

      /// Cambio de color, uno random de al constante colores
      view1.document.getElementsByTagName('body')[0].style.backgroundColor = colors[Math.floor(Math.random() * colors.length)];

      /// Formacion de string
      var string = "Alto: " + b + " - Ancho: " + a;

      /// Cambio en pagina maestra
      document.getElementById('tamanoVentana').innerHTML = string;
    }
  }, 500);
}
