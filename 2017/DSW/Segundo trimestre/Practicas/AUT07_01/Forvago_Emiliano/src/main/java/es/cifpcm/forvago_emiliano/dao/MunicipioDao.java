/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.Municipio;
import java.util.List;

/**
 *
 * @author emont
 */
public interface MunicipioDao {


    public List<Municipio> selectAll();
}
