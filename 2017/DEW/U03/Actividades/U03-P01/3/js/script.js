  /// Creo objeto date, por si en vez de dar a el boton
  /// Ahora se le da a otro, la fecha esta creada y se actualza
  /// con el boton Ahora
  var now = new Date();

  function showAhora() {
    /// Actualizo hora
    now = new Date();

    /// Formacion de string y muestra por alert
    var string = "Hoy es: " + now;
    alert(string);
  }

  function showAyer() {
    /// Hago copia del objeto asi no modifico la fecha inical
    var cookie = now;

    /// Conseguimos el dia con getDate() y le restamos uno, luego lo asignamos con el metodo setDate()
    cookie.setDate(cookie.getDate() - 1);

    /// Formacion de string y muestra por alert
    var string = "Hace 24 horas, la hora y la fecha eran: " + cookie;
    alert(string);

  }

  function showHaceDiezAnos() {
    /// Hago copia del objeto asi no modifico la fecha inical
    var cookie = now;

    /// Conseguimos el año con getFullYear() y le restamos diez, luego lo asignamos con la funcion setFullYear()
    cookie.setFullYear(cookie.getFullYear() - 10);

    /// Formacion de string y muestra por alert
    var string = "Hace 10 años, la hora y la fecha eran: " + cookie;
    alert(string);
  }

  function showDentroUnaSemana() {
    /// Hago copia del objeto asi no modifico la fecha inical
    var cookie = now;

    /// Conseguimos el dia con getDate() y le sumamos 7, luego lo asignamos con el metodo setDate()
    cookie.setDate(cookie.getDate() + 7);

    /// Formacion de string y muestra por alert
    var string = "Dentro de una semana, la hora y la fecha seran: " + cookie;
    alert(string);
  }
