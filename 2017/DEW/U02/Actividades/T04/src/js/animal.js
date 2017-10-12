/**
 * 
 * @param {Objeto animal} name, letter,pos,mov 
 */
function animal(data) {
    this.name = data.name;
    this.letter = data.letter;
    this.pos = data.pos;
    this.mov = data.mov;
}

/**
 * Funcion mover para el animal, actualiza la posicion, esta funcion es importante
 * ya que se pueden cambiar los movimientos que esta funcion seguira funcionando
 */
animal.prototype.move = function(random) {
    var k = Object.keys(this.mov);
    var v = Object.values(this.mov);

    for (var i = 0; i < Object.keys(k).length; i++) {

        /// Si el numero random es mayor que el key y menor que el key + 1, sumar el value
        if (random > k[i] && random <= k[i + 1]) {
            this.pos += parseInt(v[i + 1]);
            /// Si es menor que 0 -> 0
            if (this.pos < 0) {
                this.pos = 0;
            }
            // Si es mayor que 70 -> 70
            if (this.pos >= 70) {
                this.pos = 70;
            }
            break;
        }
        /// Si el numero es mayr que 0 y es menor que el key[1], toma el value 0
        else if (random >= 0 && random < k[0]) {
            this.pos += parseInt(v[0]);
            /// Si es menor que 0 -> 0
            if (this.pos < 0) {
                this.pos = 0;
            }
            // Si es mayor que 70 -> 70
            if (this.pos >= 70) {
                this.pos = 70;
            }
            break;
        }

    }
};