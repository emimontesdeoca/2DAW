/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.pojo.Municipio;
import es.cifpcm.forvago_emiliano.pojo.Provincia;
import javax.inject.Named;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author emont
 */
@Named(value = "hotelSearchBean")
@ApplicationScoped
public class HotelSearchBean {

    private Integer idProvincia;
    private Integer idMunicipio;

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    //private List<Provincia> listaProvincias;
    //private List<Municipio> listaMunicipios;

    public HotelSearchBean() {
    }

    public List<Provincia> getProvincias() {
        return new MasterDataBean().getProvincias();
    }

    public List<Municipio> getMunicipios() {
        return new MasterDataBean().getMunicipios();
    }

    public void onCboProvinciasChange() {
        if (idProvincia != null) {
            new MasterDataBean().getMunicipios().removeIf(x -> x.getId_provincia() != idProvincia);
        }
    }
}
