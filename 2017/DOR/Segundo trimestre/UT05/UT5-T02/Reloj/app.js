var ctx = document.getElementById("canvas").getContext("2d");

function reloj() {
  ctx.clearRect(0, 0, 250, 250);
  ctx.save();
  ctx.translate(125, 125);
  var now = new Date();
  var sec = now.getSeconds();
  ctx.rotate(sec * Math.PI / 30);

  ctx.strokeStyle = "#D40000";
  ctx.lineWidth = 6;
  ctx.lineCap = "square";

  ctx.beginPath();
  ctx.moveTo(-30, 0);
  ctx.lineTo(100, 0);
  ctx.stroke();

  ctx.beginPath();
  ctx.strokeStyle = "black";
  ctx.lineWidth = 5;
  ctx.arc(0, 0, 5, 0, Math.PI * 2, true);
  ctx.stroke();

  ctx.restore();

  window.requestAnimationFrame(reloj);
}
window.requestAnimationFrame(reloj);
