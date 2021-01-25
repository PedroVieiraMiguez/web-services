package com.company.dto;

import com.company.exception.IdTerrenoInvalidoException;
import com.company.model.Forma;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numID", "raio"})
@JacksonXmlRootElement(localName = "terreno-circular")
public class TerrenoCircularDTO {

    @JacksonXmlProperty(localName = "numID")
    private int numID;
    @JacksonXmlProperty(localName = "raio")
    private double raio;


    public TerrenoCircularDTO() {
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        this.numID = numID;
        
    }

    
    public double getRaio() {
        return raio;
    }

    
    public void setRaio(double raio) {
        this.raio = raio;
    }


}
