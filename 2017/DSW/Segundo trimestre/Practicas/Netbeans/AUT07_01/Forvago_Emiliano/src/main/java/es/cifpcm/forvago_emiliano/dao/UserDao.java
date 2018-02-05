/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

/**
 *
 * @author emont
 */
public interface UserDao {

    public Boolean login(String username, String password);
}
