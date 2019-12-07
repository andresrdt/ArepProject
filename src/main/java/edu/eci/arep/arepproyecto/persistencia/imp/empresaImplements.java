/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.persistencia.imp;

import edu.eci.arep.arepproyecto.model.empresa;
import edu.eci.arep.arepproyecto.persistencia.empresaIMP;
import edu.eci.arep.arepproyecto.persistencia.empresasPersistenceException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class empresaImplements implements empresaIMP {
    private ArrayList<empresa> list;

    public empresaImplements() {
        
    }

    @Override
    public ArrayList<empresa> getAllEmpresas() throws empresasPersistenceException{
        return list;
    }
    
    
}
