  var caja = 0;

  function addEuros(e) {
    caja += parseInt(e.path[0].attributes['id'].value);
    document.getElementById('caja').innerHTML = "Dinero: " + caja;
  }

  var a = document.querySelectorAll('img');

  for (var i = 0; i < a.length; i++) {
    a[i].addEventListener("click", addEuros, false);
  }
