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
    private String dateRep;
    private boolean dateRepEncontrado = false;
    private String day;
    private boolean dayEncontrado = false;
    private String month;
    private boolean monthEncontrado = false;
    private String year;
    private boolean yearEncontrado = false;
    private String continentExp;
    private boolean continentExpEncontrado = false;
    private String countriesAndTerritories;
    private boolean countriesAndTerritoriesEncontrado = false;
    private String cases;
    private boolean casesEncontrado = false;
    private String deaths;
    private boolean deathsEncontrado = false;
    private String geoId;
    private boolean geoIdEncontrado = false;
    private String countryterritoryCode;
    private boolean countryterritoryCodeEncontrado = false;
    private String popData2018;
    private boolean popData2018Encontrado = false;
    
    public Recordxml() {
        super();
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("records")){
            this.records = new ArrayList<Record>();
        }else if(qName.equals("record")){
            this.recordAux = new Record();
            dateRepEncontrado = true;
           dayEncontrado = true;
            monthEncontrado = true;
            yearEncontrado = true;
            continentExpEncontrado = true;
            countriesAndTerritoriesEncontrado = true;
            casesEncontrado = true;
            deathsEncontrado = true;
            geoIdEncontrado = true;
            countryterritoryCodeEncontrado = true;
            popData2018Encontrado = true;
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("dateRep")){
            if(dateRepEncontrado){
                this.recordAux.setDateRep(dateRep);
                dateRepEncontrado = false;
            }
        }else if(qName.equals("day")){
            if(dayEncontrado){
                this.recordAux.setDay(day);
                dayEncontrado = false;
            }
        }else if(qName.equals("month")){
            if(monthEncontrado){
                this.recordAux.setMonth(month);
                monthEncontrado = false;
            }
        }else if(qName.equals("year")){
            if(yearEncontrado){
                this.recordAux.setYear(year);
                yearEncontrado = false;
            }
        }else if(qName.equals("continentExp")){
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
                this.recordAux.setCases(cases);
                casesEncontrado = false;
            }
        }else if(qName.equals("deaths")){
            if(deathsEncontrado){
                this.recordAux.setDeaths(deaths);
                deathsEncontrado = false;
            }
        }else if(qName.equals("geoId")){
            if(geoIdEncontrado){
                this.recordAux.setGeoId(geoId);
                geoIdEncontrado = false;
            }
        }else if(qName.equals("countryterritoryCode")){
            if(countryterritoryCodeEncontrado){
                this.recordAux.setCountryterritoryCode(countryterritoryCode);
                countryterritoryCodeEncontrado = false;
            }
        }else if(qName.equals("popData2018")){
            if(popData2018Encontrado){
                this.recordAux.setPopData2018(popData2018);
                popData2018Encontrado = false;
            }
        }else if(qName.equals("record")){
            this.records.add(this.recordAux);
        }
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(dateRepEncontrado){
            this.dateRep = new String(ch, start, length);
        }
        if(dayEncontrado){
            this.day = new String(ch, start, length);
        }
        if(monthEncontrado){
            this.month = new String(ch, start, length);
        }
        if(yearEncontrado){
            this.year = new String(ch, start, length);
        }
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
        if(geoIdEncontrado){
            this.geoId = new String(ch, start, length);
        }
        if(countryterritoryCodeEncontrado){
            this.countryterritoryCode = new String(ch, start, length);
        }
        if(popData2018Encontrado){
            this.popData2018 = new String(ch, start, length);
        }
    }
    
    public ArrayList<Record> getRecords(){
        return this.records;
    }
}
