/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.arepproyecto.persistencia.imp;

import edu.eci.arep.arepproyecto.model.empresa;
import edu.eci.arep.arepproyecto.persistencia.empresaIMP;
import edu.eci.arep.arepproyecto.persistencia.empresasPersistenceException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class empresaImplements implements empresaIMP {
    private ArrayList<empresa> list;
    static String urlDatabase = "jdbc:postgresql://ec2-174-129-255-72.compute-1.amazonaws.com:5432/d81uor8or0kqm4";
    static String usuarioDb = "plttretcjnfrqg";
    static String passwordDb= "604b098edfdbd5b8bad885aae437b2045f0fce811e02358c5d3620f1f6ed6f8e";
    static Connection c = null;

    public empresaImplements() {
        
    }

    @Override
    public ArrayList<empresa> getAllEmpresas() throws empresasPersistenceException{
        return list;
    }
    
    public void realizaConexion() throws empresasPersistenceException{
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(urlDatabase,  usuarioDb, passwordDb);
            System.out.println("La conexion se realizo sin problemas!");
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurrio un error not found: "+e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocurrio un error : "+e.getMessage());
        }        
    }
    
    
}
