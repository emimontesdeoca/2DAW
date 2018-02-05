/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.holamundorest.services.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author emont
 */
@Path("/lista")
public class ListaParametroQueryRest {

    public ListaParametroQueryRest() {
    }

    @GET
    @Produces("text/html")
    public String getItems(@QueryParam("item") List<String> items) {
        StringBuffer sb = new StringBuffer();

        for (String item : items) {
            sb.append(item + "<br>");
        }

        return sb.toString();
    }
}
