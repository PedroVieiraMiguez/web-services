package com.company.service;

import com.company.dto.*;
import com.company.model.*;
import com.company.repo.Dados;
import com.company.exception.ConversaoException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TerrenosService {


    
    public static ListaTerrenoDTO getAllTerrenos() {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getAllTerrenos();
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static ListaTerrenoDTO getTerrenosByFreguesiaNome(String nome) {
        ListaTerrenoDTO listaTerrenoDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Terreno> terrenos = autarquia.getFreguesia(nome).getAllTerrenos();
        listaTerrenoDTO = Mapper.listTerreno2TerrenoDTO(terrenos);
        return listaTerrenoDTO;
    }

    public static ListaPessoaDTO getProprietarios(String nome, int numID) {
        ListaPessoaDTO listaPessoaDTO = null;
        Autarquia autarquia = Dados.carregarDados();
        ArrayList<Pessoa> pessoas = autarquia.getProprietarios(nome, numID);
        listaPessoaDTO = Mapper.listPessoa2PessoaDTO(pessoas);
        return listaPessoaDTO;
    }

    public static Object getTerreno(String nome, int numID) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(nome);
        Terreno terreno = freguesia.getTerreno(numID);
        if (terreno == null) {
            return null;
        }
        if (terreno.getForma() instanceof Triangulo) {
            return Mapper.terreno2terrenoTriangularDTO(terreno);
        } else if (terreno.getForma() instanceof Rectangulo){
            return Mapper.terreno2terrenoRectangularDTO(terreno);
        } else if (terreno.getForma() instanceof Circulo) {
            return Mapper.terreno2terrenoCircularDTO(terreno);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static TerrenoCircularDTO getTerrenoCircular(String nome, int numID) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(nome);
        Terreno terreno = freguesia.getTerreno(numID);
        if (terreno == null) {
            return null;
        }
        TerrenoCircularDTO terrenoCircularDTO = Mapper.terreno2terrenoCircularDTO(terreno);
        if (terrenoCircularDTO != null) {
            return terrenoCircularDTO;
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static TerrenoRectangularDTO getTerrenoRectangular(String nome, int numID) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(nome);
        Terreno terreno = freguesia.getTerreno(numID);
        if (terreno == null) {
            return null;
        }
        TerrenoRectangularDTO terrenoRectangularDTO = Mapper.terreno2terrenoRectangularDTO(terreno);
        if (terrenoRectangularDTO != null) {
            return terrenoRectangularDTO;
        } else {
            throw new ConversaoException("TerrenoRectangularDTO");
        }
    }

    public static TerrenoTriangularDTO getTerrenoTriangular(String nome, int numID) {
        Autarquia autarquia = Dados.carregarDados();
        Freguesia freguesia = autarquia.getFreguesia(nome);
        Terreno terreno = freguesia.getTerreno(numID);
        if (terreno == null) {
            return null;
        }
        TerrenoTriangularDTO terrenoTriangularDTO = Mapper.terreno2terrenoTriangularDTO(terreno);
        if (terrenoTriangularDTO != null) {
            return terrenoTriangularDTO;
        } else {
            throw new ConversaoException("TerrenoTriangularDTO");
        }
    }

    public static ListaPessoaDTO addProprietario(String nome, int numID, ListaNIFsDTO listaNIFsDTO) {
        ArrayList<Integer> listaNIFs = Mapper.listaNIFsDTO2ListaNIFs(listaNIFsDTO);
        if (listaNIFs.size() > 0) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addProprietario(listaNIFs, nome, numID);
            Dados.guardarDados(autarquia);
            return Mapper.listPessoa2PessoaDTO(autarquia.getProprietarios(nome, numID));
        } else {
            throw new ConversaoException("Adicionar Proprietário");
        }
    }

    public static void addTerrenoCircular(String nome, TerrenoCircularDTO terrenoCircDTO) {
        Terreno terreno = Mapper.terrenoCircularDTO2Terreno(terrenoCircDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static void addTerrenoRectangular(String nome, TerrenoRectangularDTO terrenoRectDTO) {
        Terreno terreno = Mapper.terrenoRectangularDTO2Terreno(terrenoRectDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoRectangularDTO");
        }
    }

    public static void addTerrenoTriangular(String nome, TerrenoTriangularDTO terrenoTriDTO) {
        Terreno terreno = Mapper.terrenoTriangularDTO2Terreno(terrenoTriDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.addTerreno(nome, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoTriangularDTO");
        }
    }

    public static void updateTerrenoCircular(String nome, int numID, TerrenoCircularDTO terrenoCircDTO) {
        Terreno terreno = Mapper.terrenoCircularDTO2Terreno(terrenoCircDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, numID, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoCircularDTO");
        }
    }

    public static void updateTerrenoRectangular(String nome, int numID, TerrenoRectangularDTO terrenoRectDTO) {
        Terreno terreno = Mapper.terrenoRectangularDTO2Terreno(terrenoRectDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, numID, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoRectangularDTO");
        }
    }

    public static void updateTerrenoTriangular(String nome, int numID, TerrenoTriangularDTO terrenoTriDTO) {
        Terreno terreno = Mapper.terrenoTriangularDTO2Terreno(terrenoTriDTO);
        if (terreno != null) {
            Autarquia autarquia = Dados.carregarDados();
            autarquia.updateTerreno(nome, numID, terreno);
            Dados.guardarDados(autarquia);
        } else {
            throw new ConversaoException("TerrenoTriangularDTO");
        }
    }

    public static void removeTerreno(String nome, int numID) {
        Autarquia autarquia = Dados.carregarDados();
        autarquia.removeTerreno(nome, numID);
        Dados.guardarDados(autarquia);
    }

}
