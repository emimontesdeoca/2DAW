/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilaorm_emiliano.dao;

import java.util.List;
import es.cifpcm.sakilaorm_emiliano.Actor;

/**
 *
 * @author emont
 */
public interface ActorDao {

    public List<Actor> selectAll();

    public Actor insert(Actor actor);
}
