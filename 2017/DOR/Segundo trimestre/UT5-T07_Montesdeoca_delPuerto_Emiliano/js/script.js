var svgns = "http://www.w3.org/2000/svg";
var xlinkns = "http://www.w3.org/1999/xlink";
var estado = "";
var cont = document.getElementById("contenedor");


function cambiar(e) {
    if (e.srcElement.getAttribute("estado") == "libre") {

        if ($(e.srcElement).hasClass("selected")) {
            $(e.srcElement).removeClass("selected");
            $(e.srcElement).addClass("noSelected");
        } else {
            $(e.srcElement).addClass("selected");
            $(e.srcElement).removeClass("noSelected");
        }
    }
}


function createJson() {
    var json = [];

    localStorage.removeItem("asientos");
    var cont = 0;
    for (let index = 0, x = -350; index < 5; index++, x += 300) {
        for (let index = 0, y = -100; index < 5; index++, y += 300, cont++) {
            var object = {
                "id": cont,
                "x": x,
                "y": y,
                "estado": "libre"
            }
            json.push(object);
        }
    }
    localStorage.setItem("asientos", JSON.stringify(json));
}

function loadJson() {
    var arr = JSON.parse(localStorage.getItem("asientos"));

    if (arr == null) {
        createJson();
    }

    arr.forEach(element => {
        var use = document.createElementNS(svgns, "use");
        use.setAttributeNS(xlinkns, "href", "#copa");
        use.setAttribute("x", element.x);
        use.setAttribute("y", element.y);
        use.setAttribute("id", element.id);

        use.setAttribute("estado", element.estado);

        if (element.estado == "ocupado") {
            use.setAttribute("class", "copa ocupado")
        } else {
            use.setAttribute("class", "copa noSelected");
            addEventListener("click", updateJson, false);
            addEventListener("click", cambiar, false);
        }

        cont.appendChild(use);
    });
}

function updateJson(e) {
    var id = parseInt(e.srcElement.getAttribute("id"));
    var arr = JSON.parse(localStorage.getItem("asientos"));

    arr.forEach(element => {
        element.id == id ? element.estado = "ocupado" : null;
    });

    localStorage.setItem("asientos", JSON.stringify(arr));
}

$(document).ready(function () {
    loadJson();
})