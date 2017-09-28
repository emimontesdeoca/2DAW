package es.cifp.ForVagosApp;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public class Hotel {

    /// Tratamiento de fichero
    public static String desktopPath = System.getProperty("user.home") + "\\Desktop";
    public static String filename = desktopPath + "\\hoteles.txt";

    /// Propiedades
    private String nombre;
    private String localidad;
    private Integer estrellas;
    private Integer precioNoche;

    /// Constructor vacio
    public Hotel() {
    }

    /// Constructor con valores
    public Hotel(String nombre, String localidad, Integer estrellas, Integer precioNoche) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.estrellas = estrellas;
        this.precioNoche = precioNoche;
    }

    /// Getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return this.localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getEstrellas() {
        return this.estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getPrecioNoche() {
        return this.precioNoche;
    }

    public void setPrecioNoche(Integer precioNoche) {
        this.precioNoche = precioNoche;
    }

}
