/// Inicializando valores para las puntuaciones
var intBoom = 0;
var intLiebre = 0;
var intTurtle = 0;


/// Funcion para jugar una ronda.
function playGame(a) {
    /// Actualizar las puntuaciones
    updateInt("boom", intBoom);
    updateInt("liebre", intLiebre);
    updateInt("tortuga", intTurtle);

    /// Si ya ha terminado la partida
    if ((a.animal1.pos >= 70 || a.animal2.pos >= 70)) {
        var f = "";
        /// Gana liebre
        if (a.animal1.pos >= 70 && a.animal2.pos <= 70) {
            /// Asignamos valor a f
            f = "ganó la liebre,...,qué bien!!, yuhu";
            /// Aumentamos puntuacion
            intLiebre = intLiebre + 1;
            /// Gana la tortuga
        } else if (a.animal2.pos >= 70 && a.animal1.pos <= 70) {
            /// Asignamos valor a f
            f = "GANÓ TORTUGA! YEAH!";
            /// Aumentamos puntuacion
            intTurtle = intTurtle + 1
            /// Empate
        } else if (a.animal2.pos == 70 && a.animal1.pos == 70) {
            /// Asignamos valor a f
            f = "Es un empate";
        }

        /// Si el radio de documento esta checkeado
        if (document.getElementById('doc').checked) {
            /// Mostrar por documento
            document.getElementById("line").innerHTML += "<br><b>" + f + "</b><br>";
            /// Si el radio de consola esta checkeado
        } else if (document.getElementById('con').checked) {
            /// Mostrar por consola
            console.log(f);
            document.getElementById("line").innerHTML = "Ejecución en consola!";
            /// Si el radio de ambos esta checkeado
        } else if (document.getElementById('both').checked) {
            /// Mostrar por ambos
            console.log(f);
            document.getElementById("line").innerHTML += "<br><b>" + f + "</b><br>";
        }
        /// Actualizar el marcador ya que se acaba la partida
        updateInt("boom", intBoom);
        updateInt("liebre", intLiebre);
        updateInt("tortuga", intTurtle);

        /// Devolver -1, para control.
        return -1;
        /// La partida no ha acabado
    } else if ((a.animal1.pos <= 70 || a.animal2.pos <= 70)) {
        /// Nueva ronda
        a.nextRound();

        /// Devuelve la linea, lo siguiente es puramente cosmetico
        var l = a.showLine();

        /// Si se cruzan, agregar OUCH
        if (l.indexOf("<i class=\"em em-boom icon-flipped\"></i>") !== -1 && l.indexOf("<i class=\"em em-boom icon-flipped\"></i>") !== 0) {
            l += "<br><br><b>OUCH</b>";

            /// Sumar a la puntuacion
            intBoom = intBoom + 1;
        }
        /// Si el radio de documento esta checkeado
        if (document.getElementById('doc').checked) {
            /// Lo dejamos como esta
            document.getElementById("line").innerHTML += l + "<br>";
            /// Si esta actuvado la consola en el radio de consola o el de ambos, hay que remplazar 
            /// para que en la consola quede bien.
        } else if (document.getElementById('con').checked) {
            if (l.indexOf("<i class=\"em em-boom icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-boom icon-flipped\"></i>", "X");
            }
            if (l.indexOf("<i class=\"em em-goat icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-goat icon-flipped\"></i>", "L");
            }
            if (l.indexOf("<i class=\"em em-turtle icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-turtle icon-flipped\"></i>", "T");
            }
            if (l.indexOf("<br><br><b>OUCH</b>") != -1) {
                l = l.replace("<br><br><b>OUCH</b>", "");
                console.log("OUCH!");
            }
            console.log(l);
            /// Si esta actuvado la consola en el radio de consola o el de ambos, hay que remplazar 
            /// para que en la consola quede bien.
        } else if (document.getElementById('both').checked) {
            document.getElementById("line").innerHTML += l + "<br>";
            if (l.indexOf("<i class=\"em em-boom icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-boom icon-flipped\"></i>", "X");
            }
            if (l.indexOf("<i class=\"em em-goat icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-goat icon-flipped\"></i>", "L");
            }
            if (l.indexOf("<i class=\"em em-turtle icon-flipped\"></i>") != -1) {
                l = l.replace("<i class=\"em em-turtle icon-flipped\"></i>", "T");
            }
            if (l.indexOf("<br><br><b>OUCH</b>") != -1) {
                l = l.replace("<br><br><b>OUCH</b>", "");
                console.log("OUCH!");
            }
            console.log(l);
        }
    }

}

/**
 * Funcion para realizar el juego de forma continua
 */
function continuousGame() {
    /// Limpia consola y documento
    console.clear();
    document.getElementById("line").innerHTML = "";
    
    /// Si el juego no esta creado, crearlo
    if (a == null) {
        var a = new game();
    }

    do {
        /// Realizar el juego hasta que devuelva -1 (cuando acaba)
        var res = playGame(a);
    } while (res != -1)

}

/// Necesario para el stepByStepGame.
var a = new game();
/**
 * Funcion que avanza un turno en el juego
 */
function stepByStepGame() {
    /// Borrar el documento
    document.getElementById("line").innerHTML = "";
    /// Si esta puesto que funcione en consola, dejar un texto en el documento
    if (document.getElementById('con').checked) {
        document.getElementById("line").innerHTML = "Ejecución en consola!";
    }
    /// Borrar la consola
    console.clear();
    var f = 0;
    /// Realizar hasta que f no sea (-1), significa que ya acabo
    if ((f = playGame(a)) == -1) {
        a = new game();
    }


}