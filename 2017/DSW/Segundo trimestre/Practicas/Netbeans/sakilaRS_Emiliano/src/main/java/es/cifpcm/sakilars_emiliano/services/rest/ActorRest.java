/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.sakilars_emiliano.services.rest;

import es.cifpcm.sakilars_emiliano.Actor;
import es.cifpcm.sakilars_emiliano.dao.ActorDao;
import es.cifpcm.sakilars_emiliano.dao.ActorDaoImpl;
import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.lang.*;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.primefaces.json.*;

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
        JSONArray json = new JSONArray(a.selectAll());
        return json.toString();
    }

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response setActor(String json) {

        JSONObject jsonObj = new JSONObject(json);

        Actor a = new Actor();

        a.setFirstName(jsonObj.getString("firstName"));
        a.setLastName(jsonObj.getString("lastName"));

        ActorDao dao = new ActorDaoImpl();
        dao.insert(a);

        return Response.status(200).entity(jsonObj).build();
    }

    @GET
    @Path("{data}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getActor(@PathParam("data") String data) {
        ActorDao a = new ActorDaoImpl();
        JSONObject j = new JSONObject(a.selectAll().get(Integer.parseInt(data)));
        return Response.status(200).entity(j.toString()).build();
    }

}
