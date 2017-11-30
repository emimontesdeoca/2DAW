/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilajsf_emiliano.web.bean;

import es.cifpcm.sakilajsf_emiliano.web.dao.ActorDao;
import es.cifpcm.sakilajsf_emiliano.web.pojo.Actor;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author emont
 */
@Named(value = "actorBean")
@RequestScoped
public class ActorBean extends Actor {

    /// Variable para skip, empieza en 0 y va cambiando, esto solo dura en la sesion
    public static Integer skip = 0;
    /// Variable global para saber la cantidad total de actores, necesaria para que no se pase en las paginas
    public static final Integer allActors = ActorDao.selectAll();

    public static Integer getSkip() {
        return skip;
    }
    /// Agrega a la variable global skip 10, y controla si se pasa del total
    public static void addSkip(Integer skip) {
        ActorBean.skip += skip;
        if (ActorBean.skip >= allActors) {
            ActorBean.skip = allActors - 10;
        }
    }

    /// Quita a la variable global skip 10, y controlar si se es negativa
    public static void subSkip(Integer skip) {
        ActorBean.skip -= skip;
        if (ActorBean.skip < 0) {
            ActorBean.skip = 0;
        }
    }

    public ActorBean() {
    }
    
    /// Metodo que devuelve todos los actores dependiendo del salto que quiera el usuario
    public static List<Actor> getActorList() {
        return ActorDao.selectAll(ActorBean.skip);
    }
}
