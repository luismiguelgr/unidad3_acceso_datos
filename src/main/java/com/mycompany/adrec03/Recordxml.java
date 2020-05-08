package com.mycompany.adrec03;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author miguel
 */
public class Recordxml extends DefaultHandler{
    private ArrayList<Record> records;
    private Record recordAux;
    private String continentExp;
    private boolean continentExpEncontrado = false;
    private String countriesAndTerritories;
    private boolean countriesAndTerritoriesEncontrado = false;
    private String cases;
    private boolean casesEncontrado = false;
    private String deaths;
    private boolean deathsEncontrado = false;
    
    public Recordxml() {
        super();
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("records")){
            this.records = new ArrayList<Record>();
        }else if(qName.equals("record")){
            this.recordAux = new Record();
            continentExpEncontrado = true;
            countriesAndTerritoriesEncontrado = true;
            casesEncontrado = true;
            deathsEncontrado = true;
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("continentExp")){
            if(continentExpEncontrado){
                this.recordAux.setContinentExp(continentExp);
                continentExpEncontrado = false;
            }
        }else if(qName.equals("countriesAndTerritories")){
            if(countriesAndTerritoriesEncontrado){
                this.recordAux.setCountriesAndTerritories(countriesAndTerritories);
                countriesAndTerritoriesEncontrado = false;
            }
        }else if(qName.equals("cases")){
            if(casesEncontrado){
                this.recordAux.setCases(Integer.parseInt(cases));
                casesEncontrado = false;
            }
        }else if(qName.equals("deaths")){
            if(deathsEncontrado){
                this.recordAux.setDeaths(Integer.parseInt(deaths));
                deathsEncontrado = false;
            }
        }else if(qName.equals("record")){
            this.records.add(this.recordAux);
        }
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(continentExpEncontrado){
            this.continentExp = new String(ch, start, length);
        }
        if(countriesAndTerritoriesEncontrado){
            this.countriesAndTerritories = new String(ch, start, length);
        }
        if(casesEncontrado){
            this.cases = new String(ch, start, length);
        }
        if(deathsEncontrado){
            this.deaths = new String(ch, start, length);
        }
    }
    
    public ArrayList<Record> getRecords(){
        return this.records;
    }
}
