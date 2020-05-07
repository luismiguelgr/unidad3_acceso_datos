package com.mycompany.adrec03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author miguel
 */
public class Conexion {
    static Connection conexion = null;
    private String nombre;
    
    public Conexion(String nombre) {
         String baseDatos = "jdbc:sqlite:/home/miguel/" + nombre;
        
        try{
            conexion = DriverManager.getConnection(baseDatos);
            if(conexion != null){
                //DatabaseMetaData meta = connection.getMetaData();
                crearTabla();
                System.out.println("La base de datos fue creada");
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
          
    public static void desconetarBaseDatos(){
      try{
          if(conexion != null){
              conexion.close();
              System.out.println("Desconectado de la base de datos");
          }
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
    }
      
    private static void crearTabla(){
      try{
          String sql = "CREATE TABLE IF NOT EXISTS record (\n" +
                            "id integer PRIMARY KEY,\n"+
                            "dateRep text NOT NULL,\n"+
                            "day int NOT NULL,\n"+
                            "month int NOT NULL,\n"+
                            "year int NOT NULL,\n"+
                            "cases int NOT NULL,\n"+
                            "deaths int NOT NULL,\n"+
                            "countriesAndTerritories text NOT NULL,\n"+
                            "geoId text NOT NULL,\n"+
                            "countryterritoryCode text NOT NULL,\n"+
                            "popData2018 int NOT NULL,\n"+
                            "continentExp text NOT NULL\n"+
                            ");";

          Statement stmt = conexion.createStatement();
          stmt.execute(sql);
          System.out.println("Tabla creada.");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
        
    }
    /*
     public static void crearBaseDatos(String nombreBaseDatos){

        String directorio = "/home/miguel/" + nombreBaseDatos;
        String url = "jdbc:sqlite:"+directorio;

        File ficheroBaseDatos = new File(directorio);
        if (!ficheroBaseDatos.exists()) {
            
            
            System.out.println("Base de datos no existe.");
        }
              
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                String schema = conn.getSchema();
                System.out.println("Prueba");
                System.out.println(schema);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
}
