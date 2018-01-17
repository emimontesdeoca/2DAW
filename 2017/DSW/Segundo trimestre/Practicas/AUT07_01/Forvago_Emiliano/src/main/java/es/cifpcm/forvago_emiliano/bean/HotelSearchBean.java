/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.forvago_emiliano.bean;

import es.cifpcm.forvago_emiliano.utils.Cookies;
import es.cifpcm.forvago_emiliano.pojo.Municipio;
import es.cifpcm.forvago_emiliano.pojo.Provincia;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;

import java.util.List;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author emont
 */
@Named(value = "hotelSearchBean")
@SessionScoped
public class HotelSearchBean implements Serializable {

    private Integer idProvincia;
    private Integer idMunicipio;

    private Date fechaEntrada;
    private Date fechaSalida;

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

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

    public String setIDCookie() {
        Cookies.setCookie("idMunicipio", this.idMunicipio.toString(), 10);
        Cookies.setCookie("fechaEntrada", this.fechaEntrada.toString(), 10);
        Cookies.setCookie("fechaSalida", this.fechaSalida.toString(), 10);

        return "resultSearch?faces-redirect=true";
    }

    private List<Provincia> provincias;
    private List<Municipio> municipios;
    private List<Municipio> municipiosFiltrados;

    public HotelSearchBean() {
        this.municipios = new MasterDataBean().getMunicipios();
        municipiosFiltrados = municipios;
    }

    public List<Provincia> getProvincias() {
        this.provincias = new MasterDataBean().getProvincias();
        return provincias;
    }

    public List<Municipio> getMunicipios() {

        return municipiosFiltrados;
    }

    public void onCboProvinciasChange() {

        Integer val = this.getIdProvincia();
        municipiosFiltrados = new ArrayList<>();
        if (val != null) {
            for (Municipio m : municipios) {
                if (m.getId_provincia() == val) {
                    municipiosFiltrados.add(m);
                }
            }

            //this.municipios.removeIf(x -> x.getId_provincia() == this.getIdProvincia());
        }
    }
}
