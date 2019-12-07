/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.persistencia;

import edu.eci.arep.arepproyecto.model.empresa;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public interface empresaIMP {
    public ArrayList<empresa> getAllEmpresas() throws empresasPersistenceException;
}
