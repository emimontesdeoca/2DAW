/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilaorm_emiliano.data;

import es.cifpcm.sakilaorm_emiliano.Actor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alumno
 */
public class Main {
    private List <Actor> fetchActors() {
        List <Actor> aList = new ArrayList<>();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            aList.addAll(session.createCriteria(Actor.class).list());
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return aList;
    }
}
