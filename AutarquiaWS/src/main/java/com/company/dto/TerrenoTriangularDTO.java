package com.company.dto;

import com.company.exception.IdTerrenoInvalidoException;
import com.company.model.Forma;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numID", "base", "altura"})
@JacksonXmlRootElement(localName = "terreno-triangular")
public class TerrenoTriangularDTO {

    @JacksonXmlProperty(localName = "numID")
    private int numID;
    @JacksonXmlProperty(localName = "base")
    private double base;
    @JacksonXmlProperty(localName = "altura")
    private double altura;

    public TerrenoTriangularDTO() {
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        this.numID = numID;
        
    }

    public double getBase() {
        return base;
    }

    
    public void setBase(double base) {
        this.base = base;
    }

    
    public double getAltura() {
        return altura;
    }

    
    public void setAltura(double altura) {
        this.altura = altura;
    }


}
