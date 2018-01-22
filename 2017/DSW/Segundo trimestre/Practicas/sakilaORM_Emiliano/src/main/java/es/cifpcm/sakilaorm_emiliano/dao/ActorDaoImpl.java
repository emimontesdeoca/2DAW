/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilaorm_emiliano.dao;

import es.cifpcm.sakilaorm_emiliano.Actor;
import es.cifpcm.sakilaorm_emiliano.data.NewHibernateUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author emont
 */
public class ActorDaoImpl implements ActorDao {

    public List<Actor> selectAll() {
        List<Actor> aList = new ArrayList<>();

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            aList = session.createQuery("FROM Actor").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return aList;
    }

    public Actor insert(Actor actor) {
        Actor a = actor;

        return a;

    }
}
