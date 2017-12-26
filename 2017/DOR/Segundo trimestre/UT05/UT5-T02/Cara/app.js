var canvas = document.getElementById("canvas");
if (canvas.getContext) {
  var ctx = canvas.getContext("2d");

  ctx.beginPath();
  ctx.arc(50, 75, 50, 0, Math.PI * 2, true); // Círculo externo
  ctx.moveTo(85, 75);
  ctx.arc(50, 75, 35, 0, Math.PI, false); // Boca (contra reloj)
  ctx.moveTo(40, 65);
  ctx.arc(35, 65, 5, 0, Math.PI * 2, true); // Ojo izquierdo
  ctx.moveTo(70, 65);
  ctx.arc(65, 65, 5, 0, Math.PI * 2, true); // Ojo derecho
  ctx.stroke();
}

var i = 10;
var timer = null;
var manual = false;

timer = setInterval(() => {
  if (canvas.getContext) {
    var ctx = canvas.getContext("2d");

    if (50 + i == canvas.width) {
      i = 10;
    }
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.beginPath();
    ctx.arc(50 + i, 75, 50, 0, Math.PI * 2, true); // Círculo externo
    ctx.moveTo(85 + i, 75);
    ctx.arc(50 + i, 75, 35, 0, Math.PI, false); // Boca (contra reloj)
    ctx.moveTo(40 + i, 65);
    ctx.arc(35 + i, 65, 5, 0, Math.PI * 2, true); // Ojo izquierdo
    ctx.moveTo(70 + i, 65);
    ctx.arc(65 + i, 65, 5, 0, Math.PI * 2, true); // Ojo derecho
    ctx.stroke();
    i += 10;
  }
}, 100);

document.onkeydown = function(e) {
  e = e || window.event;
  console.log(e.keyCode);

  if (e.keyCode == 13) {
    manual = !manual;
  }

  if (manual) {
    clearInterval(timer);
    if (e.keyCode == 39) {
      if (canvas.getContext) {
        var ctx = canvas.getContext("2d");

        if (50 + i == canvas.width) {
          i = 10;
        }
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();
        ctx.arc(50 + i, 75, 50, 0, Math.PI * 2, true); // Círculo externo
        ctx.moveTo(85 + i, 75);
        ctx.arc(50 + i, 75, 35, 0, Math.PI, false); // Boca (contra reloj)
        ctx.moveTo(40 + i, 65);
        ctx.arc(35 + i, 65, 5, 0, Math.PI * 2, true); // Ojo izquierdo
        ctx.moveTo(70 + i, 65);
        ctx.arc(65 + i, 65, 5, 0, Math.PI * 2, true); // Ojo derecho
        ctx.stroke();
        i += 10;
      }
    } else if (e.keyCode == 37) {
      if (canvas.getContext) {
        var ctx = canvas.getContext("2d");
        if (i <= 0) {
          i = canvas.width;
        }
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();
        ctx.arc(50 + i, 75, 50, 0, Math.PI * 2, true); // Círculo externo
        ctx.moveTo(85 + i, 75);
        ctx.arc(50 + i, 75, 35, 0, Math.PI, false); // Boca (contra reloj)
        ctx.moveTo(40 + i, 65);
        ctx.arc(35 + i, 65, 5, 0, Math.PI * 2, true); // Ojo izquierdo
        ctx.moveTo(70 + i, 65);
        ctx.arc(65 + i, 65, 5, 0, Math.PI * 2, true); // Ojo derecho
        ctx.stroke();
        i -= 10;
      }
    }
  } else {
    timer = setInterval(() => {
      if (canvas.getContext) {
        var ctx = canvas.getContext("2d");

        if (50 + i == canvas.width) {
          i = 10;
        }
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.beginPath();
        ctx.arc(50 + i, 75, 50, 0, Math.PI * 2, true); // Círculo externo
        ctx.moveTo(85 + i, 75);
        ctx.arc(50 + i, 75, 35, 0, Math.PI, false); // Boca (contra reloj)
        ctx.moveTo(40 + i, 65);
        ctx.arc(35 + i, 65, 5, 0, Math.PI * 2, true); // Ojo izquierdo
        ctx.moveTo(70 + i, 65);
        ctx.arc(65 + i, 65, 5, 0, Math.PI * 2, true); // Ojo derecho
        ctx.stroke();
        i += 10;
      }
    }, 100);
  }

  // use e.keyCode
};
