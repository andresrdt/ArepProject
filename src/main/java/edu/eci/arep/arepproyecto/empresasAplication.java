/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto;

/**
 *
 * @author Andres
 */
import edu.eci.arep.arepproyecto.persistencia.empresasPersistenceException;
import edu.eci.arep.arepproyecto.persistencia.imp.empresaImplements;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class empresasAplication {

    public static void main(String[] args) {
        SpringApplication.run(empresasAplication.class, args);
        
    }

}
