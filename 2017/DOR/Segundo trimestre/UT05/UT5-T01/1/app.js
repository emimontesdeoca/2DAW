document
  .getElementById("p1")
  .addEventListener("transitionend", finTransicionP1);

function finTransicionP1() {
  var p2 = document.getElementById("p2");
  if (p2.className == "Rotado") {
    p2.style.transform = "rotate(0deg)";
    p2.className = "noRotado";
  } else {
    p2.style.transform = "rotate(-2deg)";
    p2.className = "Rotado";
  }
}
