package es.cifpcm.sakilajsf_emiliano.bean;

import es.cifpcm.sakilajsf_emiliano.dao.ActorDao;
import es.cifpcm.sakilajsf_emiliano.dao.ActorDaoImplements;
import es.cifpcm.sakilajsf_emiliano.pojo.Actor;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author emont
 */
@Named(value = "actorBean")
@RequestScoped
public class ActorBean {

    public List<Actor> getActorList() {

        ActorDao a = new ActorDaoImplements();

        return a.selectAll();
    }
}
