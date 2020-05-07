package com.mycompany.adrec03;

import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author miguel
 */
public class Main {
    
    public static void main(String[] args) {
        String baseDatos = "coronavirus.db";
        String nombreXml = "/home/miguel/coronavirus.xml";
        new Conexion(baseDatos);
       
        Conexion.desconetarBaseDatos();  
    
        XMLReader procesadorXml = null;
        try{
            procesadorXml = XMLReaderFactory.createXMLReader();
            Recordxml recordXml = new Recordxml();
            procesadorXml.setContentHandler(recordXml);
            InputSource archivoXml = new InputSource(nombreXml);
            procesadorXml.parse(archivoXml);
            ArrayList<Record> records = recordXml.getRecords();
            for(Record r: records){
                System.out.println("Date rep: " + r.getDateRep());
            }
        } catch (SAXException e){
            System.out.println("Error al leer el XML");
        } catch (IOException e){
            System.out.println("Error al leer el archivo XML");
        }
    }       
}
