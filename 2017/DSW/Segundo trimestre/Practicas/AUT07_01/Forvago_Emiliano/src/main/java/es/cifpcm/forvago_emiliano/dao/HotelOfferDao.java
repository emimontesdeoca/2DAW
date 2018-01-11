/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.dao;

import es.cifpcm.forvago_emiliano.pojo.HotelOffer;
import java.util.List;

/**
 *
 * @author emont
 */
public interface HotelOfferDao {

    public List<HotelOffer> selectAll();

    public void insert(HotelOffer h);

    public void select(HotelOffer h);

    public void update(HotelOffer h);

    public void delete(Integer id);
}
