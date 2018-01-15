/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.dao.HotelOfferDao;
import es.cifpcm.forvago_emiliano.dao.HotelOfferDaoImpl;
import es.cifpcm.forvago_emiliano.dao.MunicipioDao;
import es.cifpcm.forvago_emiliano.dao.MunicipioDaoImpl;
import es.cifpcm.forvago_emiliano.dao.ProvinciaDao;
import es.cifpcm.forvago_emiliano.dao.ProvinciaDaoImpl;
import es.cifpcm.forvago_emiliano.pojo.HotelOffer;
import es.cifpcm.forvago_emiliano.pojo.Municipio;
import es.cifpcm.forvago_emiliano.pojo.Provincia;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author emont
 */
@Named(value = "masterDataBean")
@ApplicationScoped
public class MasterDataBean {

    /**
     * Creates a new instance of MasterDataBean
     */
    public MasterDataBean() {
    }

    public List<Municipio> getMunicipios() {
        MunicipioDao a = new MunicipioDaoImpl();
        return a.selectAll();
    }

    public List<Provincia> getProvincias() {
        ProvinciaDao a = new ProvinciaDaoImpl();
        return a.selectAll();
    }

    public List<HotelOffer> getHotelOffers(Integer idMunicipio) {
        HotelOfferDao h = new HotelOfferDaoImpl();
        return h.selectByCriteria(idMunicipio);
    }
}
