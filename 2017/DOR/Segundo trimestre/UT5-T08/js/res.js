google.charts.load("current", { packages: ["corechart"] });

// google.charts.setOnLoadCallback(drawChart);

const arr = JSON.parse(localStorage.getItem("peliculas"));

function drawChart(index) {
  // Create the data table.
  var data = new google.visualization.DataTable();
  data.addColumn("string", "Topping");
  data.addColumn("number", "Votos");
  arr.forEach(element => {
    data.addRows([[element.titulo, element.votos]]);
  });

  if (parseInt(index) == 0) {
    var options = {
      title: "Resultado votacion",
      width: 800,
      height: 500,
      chartArea: { width: "60%" },
      hAxis: {
        title: "Votos",
        minValue: 0
      },
      vAxis: {
        title: "Peliculas"
      }
    };

    var chart = new google.visualization.BarChart(
      document.getElementById("chart_div")
    );
  } else if (parseInt(index) == 1) {
    var options = {
      title: "Resultado votación",
      width: 800,
      height: 500,
      pieHole: 0.4
    };
    var chart = new google.visualization.PieChart(
      document.getElementById("chart_div")
    );
  } else if (parseInt(index) == 2) {
    // Set chart options
    var options = {
      title: "Resultado votación",
      width: 800,
      height: 500
    };
    var chart = new google.visualization.PieChart(
      document.getElementById("chart_div")
    );
  }

  // Instantiate and draw our chart, passing in some options.
  //   var chart = new google.visualization.PieChart(
  //     document.getElementById("chart_div")
  //   );
  chart.draw(data, options);
  document.getElementById("chart_div").focus();
}
