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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            realizaConexion();
        } catch (empresasPersistenceException ex) {
            Logger.getLogger(empresaImplements.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<empresa> getAllEmpresas() throws empresasPersistenceException{
        Statement stmt = null;
        ArrayList<empresa> lista = new ArrayList<>();
         try{
            Class.forName("org.postgresql.Driver");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "Select * from empresas;";
            //System.out.println(sql);
            String rsl = null;
            ResultSet rs = stmt.executeQuery(sql);
            empresa u = null;
            while (rs.next()) {
                 u = new empresa(rs.getString("name"),rs.getString("service"), rs.getString("url"));
                 lista.add(u);
            }
            rs.close();
            stmt.close();
            //System.out.println(lista.get(1).getName());
            list=lista;
            return lista;
            
        }catch(Exception e){
            System.out.println("Ocurrio un error obteniendo la empresa : "+e.getMessage());
        }
         return null;
    }
    
    public ArrayList<empresa> getEmpresasPorServicio( String servicio ){
        Statement stmt = null;
        ArrayList<empresa> lista = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "Select * from empresas where service ='"+servicio+"';";
            //System.out.println(sql);
            String rsl = null;
            ResultSet rs = stmt.executeQuery(sql);
            empresa u = null;
            while (rs.next()) {
                 u = new empresa(rs.getString("name"),rs.getString("service"), rs.getString("url"));
                 lista.add(u);
            }
            rs.close();
            stmt.close();
            //System.out.println(lista.get(1).getName());
            return lista;
            
        }catch(Exception e){
            System.out.println("Ocurrio un error obteniendo la empresa : "+e.getMessage());
        }

        return null;

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

    @Override
    public void AddEmpresa(String empresa,String service,String url) {
        PreparedStatement stmt = null;
        ArrayList<empresa> lista = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver");
            stmt=c.prepareStatement("INSERT INTO empresas VALUES (?,?,?)");
            stmt.setString(1,empresa);
            stmt.setString(2,service);
            stmt.setString(3,url);
            stmt.executeUpdate();
            //stmt = c.createStatement();
            //String sql = "insert into empresas(name,service,url) values('"+empresa+"','"+service+"','"+url+"');";
            //System.out.println("llegue aqui ");
            //stmt.executeQuery(sql);
            //System.out.println(sql);
            stmt.close();
            //System.out.println(lista.get(1).getName());
            
        }catch(Exception e){
            System.out.println("Ocurrio un error obteniendo la empresa : "+e.getMessage());
        }

        
    }
    
    
    
}
