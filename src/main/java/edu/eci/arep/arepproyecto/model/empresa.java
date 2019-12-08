/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.model;

/**
 *
 * @author Andres
 */
public class empresa {
    private String name;
    private String service;
    private String url;

    public empresa(String name, String service, String url) {
        this.name = name;
        this.service = service;
        this.url = url;
    }

        
    
    public void setName(String name) {
        this.name = name;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public String getUrl() {
        return url;
    }
}
