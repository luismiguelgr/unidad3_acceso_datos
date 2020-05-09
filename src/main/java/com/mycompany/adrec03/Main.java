package com.mycompany.adrec03;


/**
 *
 * @author miguel
 */
public class Main {
    
    public static void main(String[] args) {
        String baseDatos = "coronavirus.db";
        String nombreXml = "coronavirus.xml";
        new Conexion(baseDatos);
       
        Conexion.procesarXml(nombreXml);       
        
        Conexion.desconetarBaseDatos();
    }       
}
