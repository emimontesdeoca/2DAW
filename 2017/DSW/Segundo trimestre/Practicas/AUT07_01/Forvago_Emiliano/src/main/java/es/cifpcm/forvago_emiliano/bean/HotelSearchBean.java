/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.pojo.Municipio;
import es.cifpcm.forvago_emiliano.pojo.Provincia;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author emont
 */
@Named(value = "hotelSearchBean")
@ApplicationScoped
public class HotelSearchBean extends Provincia {

    private Integer idProvincia;
    private Integer idMunicipio;

    private List<Provincia> listaProvincias;
    private List<Municipio> listaMunicipios;

    public HotelSearchBean() {
    }

    public List<Provincia> getProvincias() {
        if (listaProvincias == null) {
            listaProvincias = new MasterDataBean().getProvincias();
        }
        return listaProvincias;
    }

    public List<Municipio> getMunicipios() {
        if (listaMunicipios == null) {
            listaMunicipios = new MasterDataBean().getMunicipios();
        }

        List<Municipio> res = listaMunicipios;

        if (idProvincia != null) {
            res.removeIf(x -> x.getId_provincia() != idProvincia);
        }

        return res;
    }
}
