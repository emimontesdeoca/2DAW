/**
 * Funcion para realizar el juego de forma continua
 */
function continuousGame() {
    var n = new game();
    var i = 0;
    do {
        if (n.animal1.pos >= 70 || n.animal2.pos >= 70) {
            n = null;
            break;
        } else {
            n.nextRound();
            n.showLine();
        }
    } while (true)

}

/**
 * Funcion para limpiar pantalla y limpiar consola
 */
function newGame() {
    console.clear();
    a = new game();
}

var a = new game();
/**
 * Funcion que avanza un turno en el juego
 */
function stepByStepGame() {
    if (a != null) {
        if ((a.animal1.pos >= 70 || a.animal2.pos >= 70)) {
            a = null;
        } else if ((a.animal1.pos <= 70 || a.animal2.pos <= 70)) {
            a.nextRound();
            a.showLine();
        }
    }
}

function continuousOneLine() {
    var n = new game();
    var i = 0;
    do {
        if (n.animal1.pos >= 70 || n.animal2.pos >= 70) {
            n = null;
            break;
        } else {
            n.nextRound();
            n.showOneLine();
        }
    } while (true)
}