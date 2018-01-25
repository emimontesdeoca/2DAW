function getDivPelicula(index, src, titulo, sinopsis) {
  var divPelicula =
    "<img alt='" +
    titulo +
    "' aria-hidden=true class='card-img-top' src='" +
    src +
    "'><div class='card-body'><h1 tabindex='0' aria-label='Pelicula: " +
    titulo +
    "' class='card-title'>" +
    titulo +
    "</h1><p tabindex='0' class='card-text'>Sinopsis: " +
    sinopsis +
    "</p></div><div class='buttons-form'><button class='btn btn-success' data-toggle='modal' data-target='#modalConfirmacion' aria-label='Votar por " +
    titulo +
    "' onclick='setValuesPelicula(" +
    index +
    ")'>Votar</button></div><br/></div></div>";

  return divPelicula;
}

const cont = document.getElementById("peliculas-contenedor");

for (let index = 0; index < peliculas.length; index++) {
  const element = peliculas[index];

  let res = getDivPelicula(
    element.id,
    element.path,
    element.titulo,
    element.sinopsis
  );
  let div = document.createElement("div");
  div.setAttribute("class", "card newcard");
  // div.setAttribute("tabindex", "0");
  // div.setAttribute("aria-labelledby", "titulo-" + element.id);

  div.innerHTML = res;

  cont.appendChild(div);
}

function votarFinal() {
  let n = document.getElementById("nombre").value;
  let a = document.getElementById("apellido").value;
  let e = document.getElementById("email").value;
  let t = document.getElementById("telefono").value;
  let i = parseInt(
    document.getElementById("idPelicula").getAttribute("data-id")
  );

  var obj = {
    nombre: n,
    apellido: a,
    email: e,
    telefono: t,
    voto: i
  };

  var arr = JSON.parse(localStorage.getItem("usuarios"));
  arr == null ? (arr = []) : null;
  arr.push(obj);
  localStorage.setItem("usuarios", JSON.stringify(arr));

  var pel = JSON.parse(localStorage.getItem("peliculas"));
  pel == null ? (pel = peliculas) : null;

  pel.forEach(element => {
    element.id == i ? element.votos++ : null;
  });

  localStorage.setItem("peliculas", JSON.stringify(pel));
}

function setValuesPelicula(id) {
  let idP = document.getElementById("idPelicula");
  idP.setAttribute("data-id", id);
}
