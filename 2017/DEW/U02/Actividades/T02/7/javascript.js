/*Solicitar al usuario el día, mes y año de nacimiento.
En función de estos datos mostrar al usuario su edad.*/

function mainEjercicio7() {


  /// Get from user
  var d = prompt("Day of birth:");
  var m = prompt("Month of birth:");
  var y = prompt("Year of birth:");

  /// New date object
  var date = new Date();
  var cY = date.getFullYear();

  alert(cY - y);
}
