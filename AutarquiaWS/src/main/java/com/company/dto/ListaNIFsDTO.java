package com.company.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JacksonXmlRootElement(localName = "lista-nifs")
public class ListaNIFsDTO {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "nif")
    private ArrayList<Integer> nifs;

    public ListaNIFsDTO() {
    }

    public ArrayList<Integer> getNIFs() {
        return nifs;
    }

    public void setNIFs(ArrayList<Integer> nifs) {
        this.nifs = nifs;
    }

}
