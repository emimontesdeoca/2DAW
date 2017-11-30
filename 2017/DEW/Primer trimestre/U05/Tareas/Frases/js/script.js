var a = document.getElementById('lib-button');

function libit() {
  var b = document.getElementById('noun').value;
  var c = document.getElementById('adjective').value;
  var d = document.getElementById('name').value;

  document.getElementById('story').innerHTML = b + " realmente le gusta " + d + " de color " + c + ".";
}
a.addEventListener("click", libit, false);
