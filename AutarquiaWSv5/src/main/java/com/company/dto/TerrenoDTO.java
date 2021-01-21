package com.company.dto;

import com.company.exception.IdTerrenoInvalidoException;
import com.company.model.Forma;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"numID", "forma", "area"})
@JacksonXmlRootElement(localName = "terreno")
public class TerrenoDTO {

    @JacksonXmlProperty(localName = "numID")
    private int numID;
    @JacksonXmlProperty(localName = "forma")
    private Forma forma;
    @JacksonXmlProperty(localName = "area")
    private double area;

    public TerrenoDTO() {
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        this.numID = numID;
        
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
