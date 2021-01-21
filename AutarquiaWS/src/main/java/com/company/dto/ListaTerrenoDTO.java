package com.company.dto;

import com.company.model.Terreno;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "terrenos")
public class ListaTerrenoDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "terreno")
    private ArrayList<Object> terrenos;

    public ListaTerrenoDTO() {
    }

    public ArrayList<Object> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(ArrayList<Object> terrenos) {
        this.terrenos = terrenos;
    }
}
