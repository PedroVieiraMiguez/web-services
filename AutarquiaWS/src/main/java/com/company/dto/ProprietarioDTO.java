package com.company.dto;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;

@JsonPropertyOrder({"nome", "numID", "listaNIFs"})
@JacksonXmlRootElement(localName = "proprietario")
public class ProprietarioDTO {

    @JacksonXmlProperty(localName = "nome")
    private String nome;

    @JacksonXmlProperty(localName = "numID")
    private int numID;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "lista-nifs")
    private ListaNIFsDTO listaNIFs;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }


    public ListaNIFsDTO getListaNIFs() {
        return listaNIFs;
    }

    public void setListaNIFs(ListaNIFsDTO listaNIFs) {
        this.listaNIFs = listaNIFs;
    }
}
