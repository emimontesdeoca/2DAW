/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilaorm_emiliano.data;

import es.cifpcm.sakilaorm_emiliano.Actor;
import javax.websocket.Session;
import java.util.*;
import org.hibernate.Session;

/**
 *
 * @author emont
 */
public class Main {

    private List<Actor> fetchActors() {
        List<Actor> aList = new ArrayList<>();

        Session session = NewHibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            aList.addAll(session.createCriteria(Actor.class).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransatcion().rollback();
        } finally {
            session.close();
        }
        return aList;
    }
}
