package com.company.dto;

import com.company.exception.IdTerrenoInvalidoException;
import com.company.model.Forma;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numID", "comprimento", "largura"})
@JacksonXmlRootElement(localName = "terreno-rectangular")
public class TerrenoRectangularDTO {

    @JacksonXmlProperty(localName = "numID")
    private int numID;
    @JacksonXmlProperty(localName = "comprimento")
    private double comprimento;
    @JacksonXmlProperty(localName = "largura")
    private double largura;

    public TerrenoRectangularDTO() {
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        this.numID = numID;
    }

    public double getComprimento() {
        return comprimento;
    }

   
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    
    public double getLargura() {
        return largura;
    }

    
    public void setLargura(double largura) {
        this.largura = largura;
    }

}
