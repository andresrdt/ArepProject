/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.controller;
import edu.eci.arep.arepproyecto.model.empresa;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Andres
 */
@RestController
@RequestMapping(value = "/date")
public class empresasController {
    /*@Autowired
    AirportsFinderServices afs=null;
    @RequestMapping(path ="/{city}",method = RequestMethod.GET)
    public ResponseEntity<?> GetAirportByName(@PathVariable ("city") String name){
        try {
            
            return new ResponseEntity<>(afs.OpenConnection(name),HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(AirportsFinderController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }*/
}
