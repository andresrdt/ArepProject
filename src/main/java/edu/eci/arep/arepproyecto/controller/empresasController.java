/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.controller;
import edu.eci.arep.arepproyecto.model.empresa;
import edu.eci.arep.arepproyecto.persistencia.empresasPersistenceException;
import edu.eci.arep.arepproyecto.services.empresaServices;
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
@RequestMapping(value = "/datos")
public class empresasController {
    @Autowired
    empresaServices es =null;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllEmpresas(){
        try {
            return new ResponseEntity<>(es.getEmpresas(),HttpStatus.ACCEPTED);
        } catch (empresasPersistenceException e) {
            Logger.getLogger(empresasController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path ="/{service}")
    public ResponseEntity<?> GetEmpresasByService(@PathVariable String service ){
        return new ResponseEntity<>(es.getEmpresasPorServicio(service),HttpStatus.ACCEPTED);
    }
}
