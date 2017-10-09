function game() {
    /**
     * Movimientos de los animales, 0 es de tortuga, 1 es de liebre
     */
    const mov = [{
            5: 3,
            7: -6,
            10: 1
        },
        {
            2: 0,
            4: 9,
            5: -12,
            8: 1,
            10: -2
        }
    ];

    /** 
     * Creacion del objeto animal1
     */
    this.animal1 = new animal({
        name: "Liebre",
        letter: "L",
        pos: 0,
        mov: mov[0]
    });

    /**
     * Creacion del objeto animal2
     */
    this.animal2 = new animal({
        name: "Tortuga",
        letter: "T",
        pos: 0,
        mov: mov[1]
    });

}

/**
 * Funcion que consigue un numero random y cambia la posicion de los animales.
 */
game.prototype.nextRound = function() {
    var res = getRandom();
    this.animal1.move(res);
    this.animal2.move(res);
};

/**
 * Funcion que escribe una linea en consola donde aparece el animal1 y el animal2
 */
game.prototype.showLine = function() {
    var line = "";
    for (var i = 0; i <= 70; i++) {

        if (i == this.animal1.pos && i == this.animal2.pos) {
            line += "X ";
        } else if (i == this.animal1.pos) {
            line += this.animal1.letter + " ";
        } else if (i == this.animal2.pos) {
            line += this.animal2.letter + " ";
        } else {
            line += "_ ";
        }
    };
    console.log(line);

};

/**
 * Funcion que actualiza una lista hasta que acaba el juego
 */
game.prototype.showOneLine = function(p) {
    var line = "";
    for (var i = 0; i <= 70; i++) {

        if (i == this.animal1.pos && i == this.animal2.pos) {
            line += "X ";
        } else if (i == this.animal1.pos) {
            line += this.animal1.letter + " ";
        } else if (i == this.animal2.pos) {
            line += this.animal2.letter + " ";
        } else {
            line += "_ ";
        }
    };
    document.getElementById('line').innerHTML = line;

};