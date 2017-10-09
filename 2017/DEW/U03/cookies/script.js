function setCookie(nombre, value, dias) {
    var expdate = new Date();
    expdate.setTime(expdate.getTime() + dias * 24 * 60 * 60 * 1000);
    document.cookie = nombre + "=" + encodeURIComponent(value) + "; expires=" + expdate.toUTCString();
}

function getCookie(nombre) {
    var index = document.cookie.indexOf(nombre + "=");
    if (index == -1)
        return null;
    index = document.cookie.indexOf("=", index) + 1;
    var endstr = document.cookie.indexOf(";", index);
    if (endstr == -1)
        endstr = document.cookie.length;
    return decodeURIComponent(document.cookie.substring(index, endstr));
}

function comprobar() {
    var cont = getCookie("contador");


    if ((name = getCookie("nombre")) == null) {
        var name = prompt("Introduzca nombre:");
        setCookie("nombre", name, 30);
        alert("Usuario guardado");
    } else {
        alert("Usuario:" + name);
    }
    if (cont == null) {
        cont = 1;
        setCookie("contador", cont, 30);


    } else {
        cont++;
        setCookie("contador", cont, 30);
        alert("Contador: " + cont);
    }


}

comprobar();

function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}