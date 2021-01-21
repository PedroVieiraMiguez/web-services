package com.company.service;

import com.company.repo.Dados;
import com.company.dto.ListaFreguesiaDTO;
import com.company.dto.Mapper;
import com.company.dto.FreguesiaDTO;
import com.company.exception.ConversaoException;
import com.company.model.Autarquia;
import com.company.model.Freguesia;
import java.util.ArrayList;

public class FreguesiasService {
    
    public static ListaFreguesiaDTO getFreguesias() {
        ListaFreguesiaDTO listaFreguesiaDTO;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Freguesia> freguesias = autarquia.getAllFreguesias();
        listaFreguesiaDTO = Mapper.listFreguesia2FreguesiaDTO(freguesias);
        return listaFreguesiaDTO;
    }

    public static FreguesiaDTO getFreguesia(String nome) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(nome);
        if (freguesia == null) {
            return null;
        }
        FreguesiaDTO freguesiaDTO = Mapper.freguesia2FreguesiaDTO(freguesia);
        if (freguesiaDTO != null) {
            return freguesiaDTO;
        } else {
            throw new ConversaoException("FreguesiaDTO");
        }
    }

    public static void addFreguesia(FreguesiaDTO freguesiaDTO) {
        Freguesia freguesia = Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addFreguesia(freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("FreguesiaDTO");
        }
    }

    public static void updateFreguesia(String nome, FreguesiaDTO freguesiaDTO) {
        Freguesia freguesia = Mapper.freguesiaDTO2Freguesia(freguesiaDTO);
        if (freguesia != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateFreguesia(nome, freguesia);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("FreguesiaDTO");
        }
    }

    public static void removeFreguesia(String nome) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeFreguesia(nome);
        Dados.guardarDados(autarquia);
    }
}
