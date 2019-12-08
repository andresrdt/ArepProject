/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.services;

import edu.eci.arep.arepproyecto.model.empresa;
import edu.eci.arep.arepproyecto.persistencia.empresaIMP;
import edu.eci.arep.arepproyecto.persistencia.empresasPersistenceException;
import edu.eci.arep.arepproyecto.persistencia.imp.empresaImplements;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class empresaServices {
    
    @Autowired
    empresaImplements ep=null;
    
     public ArrayList<empresa> getEmpresas() throws empresasPersistenceException{
         return ep.getAllEmpresas();
     }
     
     public ArrayList<empresa> getEmpresasPorServicio( String service){
         return ep.getEmpresasPorServicio(service);
     }
     public void addNewEmpresa(String empresa,String service,String url){
         ep.AddEmpresa(empresa, service, url);
     }
     
     
}
