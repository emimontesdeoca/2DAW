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

    public ActorBean() {
    }

    public static List<Actor> getActorList() {
        return ActorDao.selectAll();
    }
}
