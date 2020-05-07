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
    
    public Recordxml() {
        super();
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("records")){
            this.records = new ArrayList<Record>();
        }else if(qName.equals("record")){
            this.recordAux = new Record();
            dateRepEncontrado = true;
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equals("dateRep")){
            if(dateRepEncontrado){
                this.recordAux.setDateRep(dateRep);
                dateRepEncontrado = false;
            }
        }else if(qName.equals("record")){
            this.records.add(this.recordAux);
        }
    }
    
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(dateRepEncontrado){
            this.dateRep = new String(ch, start, length);
        }
    }
    
    public ArrayList<Record> getRecords(){
        return this.records;
    }
}
