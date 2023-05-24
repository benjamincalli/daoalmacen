package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static String drive = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn=null;
    
    public ConexionDB() {
        try{
            Class.forName(drive);
            conn = DriverManager.getConnection(url,usuario,password);
            
            if (conn != null){
                System.out.println("Conexion OK: "+ conn);
            }
        
        }catch(ClassNotFoundException ex){
            //Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
                 System.out.println("Error en driver: "+ ex.getMessage());
       
        }catch(SQLException ex){
                System.out.println("error sql: "+ ex.getMessage());
        
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try{
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    
    
}
