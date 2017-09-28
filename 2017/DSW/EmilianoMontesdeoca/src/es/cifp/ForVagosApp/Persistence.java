package es.cifp.ForVagosApp;

import java.util.List;

/**
 * @author Emiliano Montesdeoca del Puerto
 * @asignatura: Desarrollo de entorno servidor
 * @clase: 2DAW-B
 */
public interface Persistence {

    public void save(Hotel l);

    public void delete(Hotel l);

    public List<Hotel> list();

}
