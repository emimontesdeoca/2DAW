function tellFortune(children, fname, loc, work) {
  alert("Seras " + work + " en " + loc + ", estaras casado con " + fname + " y tendras " + children + " hijos.")
}

function calculateAge(a, b) {
  alert("Estas entre " + b - a - 1 + " o " + b - a + " años.")
}

function isLeapYear(year) {
  return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
}

const emax = 100;

function calculateSupplyFlotante(a, b) {
  if (isNaN(a) || isNaN(b)) {
    return console.log("Error en datos");
  }

  var yearToLive = emax - a;
  var currentYear = new Date().getFullYear();
  var lastYear = currentYear + yearToLive;
  var c = 0;

  for (var i = currentYear; i <= lastYear; i++) {
    isLeapYear(currentYear) ? c += b * 366 : c += b * 365;
  }

  return console.log("Necesitaras " + c.toFixed() +
    " hasta que tengas " + emax + " años y te vas a gastar " +
    (0.80 * c).toFixed(2) + "€.");
}


calculateSupplyFlotante(22, 2.8);
