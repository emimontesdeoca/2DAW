/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilaorm_emiliano.services.rest;

import es.cifpcm.sakilaorm_emiliano.Actor;
import es.cifpcm.sakilaorm_emiliano.dao.ActorDao;
import es.cifpcm.sakilaorm_emiliano.dao.ActorDaoImpl;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author emont
 */
@Path("actor")
public class ActorRest {

    public ActorRest() {
    }

    @GET
    @Path("allActors")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllActores() {
        ActorDao a = new ActorDaoImpl();
        String json = "[";

        for (Actor actor : a.selectAll()) {
            json += "{ \"firstName\" : \"" + actor.getFirstName() + "\", \"lastName\" : \"" + actor.getLastName() + "\"},";
        }

        json = json.substring(0, json.length() - 1);
        json += "]";

        return json;
    }

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_JSON)
    public String getActor(@QueryParam("id") Integer id) {
        ActorDao a = new ActorDaoImpl();

        Actor actor = a.selectAll().get(id);

        String json = "[{ \"firstName\" : \"" + actor.getFirstName() + "\", \"lastName\" : \"" + actor.getLastName() + "\"}}";

        return json;
    }

}
