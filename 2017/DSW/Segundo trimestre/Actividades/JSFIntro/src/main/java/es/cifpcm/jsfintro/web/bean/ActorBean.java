/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.jsfintro.web.bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author emont
 */
@Named(value = "actorBean")
@RequestScoped
public class ActorBean {

    private String firstName;
    private String lastName;
    
    public ActorBean() {
    }
    
    public ActorBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String save() {
        return "ok";
    }

   
}