package com.mycompany.adrec03;

import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author miguel
 */
public class Main {
    
    
    public static void main(String[] args) {
        String baseDatos = "coronavirus.db";
        String nombreXml = "coronavirus.xml";
        
        new Conexion(baseDatos); 
        if(!Conexion.contieneDatos()){
            int dialogo = JOptionPane.showConfirmDialog(null, "Debe importar los datos para que el programa funcione. ¿Importar datos?");
            if(dialogo == 0){
                Conexion.procesarXml(nombreXml);
            }else{
                System.exit(0);
            }
        }
        menu();
    }       
    
    public static void menu(){     
       Scanner sc = new Scanner(System.in);
       boolean salir =  false;
       int opcion;
       
       while(!salir){
           try{
                System.out.println("\nMenu\n");  
                System.out.println("1. Paises por número de casos / 2. Día con mayores muertes / 3. Sair");
                System.out.println("Escolla opcion");
                opcion = sc.nextInt();

                switch(opcion){
                    case 1:
                        System.out.println("Introduzca número de casos\n");
                        int numCasos = sc.nextInt();
                        System.out.println("Listado: \n");
                        Conexion.obtenerPaisesPorNumCasos(numCasos);   
                        break;
                    case 2:
                        System.out.println("Listado: \n");
                        Conexion.obtenerMayorNumMuertesPorPais();  
                        break;
                    case 3:
                        Conexion.desconetarBaseDatos();
                        System.out.println("Saindo...");
                        salir=true;
                        break;
                }
           } catch (InputMismatchException e){
               System.out.println("Solo se admiten numeros");
               sc.next();
           }
       }
    }
}
