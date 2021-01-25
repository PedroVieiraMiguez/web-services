package com.company.dto;

import com.company.model.*;

import java.util.ArrayList;

public class Mapper {

    public static DataDTO data2dataDTO(Data data) throws NullPointerException {
        DataDTO dataDTO = new DataDTO();
        dataDTO.setDia(data.getDia());
        dataDTO.setMes(data.getMes());
        dataDTO.setAno(data.getAno());
        return dataDTO;
    }

    public static Data dataDTO2data(DataDTO dataDTO) throws NullPointerException {
        Data data = null;
        data = new Data(dataDTO.getDia(), dataDTO.getMes(), dataDTO.getAno());
        return data;
    }

    public static PessoaDTO pessoa2PessoaDTO(Pessoa pessoa) throws NullPointerException {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNif(pessoa.getNif());
        pessoaDTO.setNome(pessoa.getNome());
        DataDTO dataDTO = data2dataDTO(pessoa.getNascimento());
        pessoaDTO.setNascimento(dataDTO);
        return pessoaDTO;
    }
    
    public static FreguesiaDTO freguesia2FreguesiaDTO(Freguesia freguesia) throws NullPointerException {
        FreguesiaDTO freguesiaDTO = new FreguesiaDTO();
        freguesiaDTO.setNome(freguesia.getNome());
        return freguesiaDTO;
    }
    
    public static TerrenoTriangularDTO terreno2terrenoTriangularDTO(Terreno terreno) throws NullPointerException {
        TerrenoTriangularDTO terrenoTriDTO = new TerrenoTriangularDTO();
        terrenoTriDTO.setNumID(terreno.getNumID());
        terrenoTriDTO.setBase(((Triangulo) terreno.getForma()).getBase());
        terrenoTriDTO.setAltura(((Triangulo) terreno.getForma()).getAltura());
        return terrenoTriDTO;
    }

    public static TerrenoCircularDTO terreno2terrenoCircularDTO(Terreno terreno) throws NullPointerException {
        TerrenoCircularDTO terrenoCircDTO = new TerrenoCircularDTO();
        terrenoCircDTO.setNumID(terreno.getNumID());
        terrenoCircDTO.setRaio(((Circulo) terreno.getForma()).getRaio());
        return terrenoCircDTO;
    }
    
    public static TerrenoRectangularDTO terreno2terrenoRectangularDTO(Terreno terreno) throws NullPointerException {
        TerrenoRectangularDTO terrenoRecDTO = new TerrenoRectangularDTO();
        terrenoRecDTO.setNumID(terreno.getNumID());
        terrenoRecDTO.setComprimento(((Rectangulo) terreno.getForma()).getComprimento());
        terrenoRecDTO.setLargura(((Rectangulo) terreno.getForma()).getLargura());
        return terrenoRecDTO;
    }
    
    public static Pessoa pessoaDTO2Pessoa(PessoaDTO pessoaDTO) throws NullPointerException {
        Pessoa pessoa = null;
        Data data = dataDTO2data(pessoaDTO.getNascimento());
        pessoa = new Pessoa(pessoaDTO.getNif(), pessoaDTO.getNome(), data);
        return pessoa;
    }
    
    public static Freguesia freguesiaDTO2Freguesia(FreguesiaDTO freguesiaDTO) throws NullPointerException {
        Freguesia freguesia = null;
        freguesia = new Freguesia(freguesiaDTO.getNome());
        return freguesia;
    }
    
    public static Terreno terrenoTriangularDTO2Terreno (TerrenoTriangularDTO terrenoTriDTO) throws NullPointerException {
        Terreno terreno = null;
        terreno = new Terreno(terrenoTriDTO.getNumID(), new Triangulo(terrenoTriDTO.getBase(), terrenoTriDTO.getAltura()));
        return terreno;
    }

    public static Terreno terrenoCircularDTO2Terreno (TerrenoCircularDTO terrenoCircDTO) throws NullPointerException {
        Terreno terreno = null;
        terreno = new Terreno(terrenoCircDTO.getNumID(), new Circulo(terrenoCircDTO.getRaio()));
        return terreno;
    }

    public static Terreno terrenoRectangularDTO2Terreno (TerrenoRectangularDTO terrenoRecDTO) throws NullPointerException {
        Terreno terreno = null;
        terreno = new Terreno(terrenoRecDTO.getNumID(), new Rectangulo(terrenoRecDTO.getComprimento(), terrenoRecDTO.getLargura()));
        return terreno;
    }

    public static ListaPessoaDTO listPessoa2PessoaDTO(ArrayList<Pessoa> pessoas) throws NullPointerException {
        ArrayList<PessoaDTO> pessoasDTO = new ArrayList<>();
        for (Pessoa pessoa : pessoas) {
            try {
                PessoaDTO pessoaDTO = pessoa2PessoaDTO(pessoa);
                pessoasDTO.add(pessoaDTO);
            } catch (NullPointerException e) {
                //nada é adicionado
            }
        }
        ListaPessoaDTO listaPessoaDTO = new ListaPessoaDTO();
        listaPessoaDTO.setPessoas(pessoasDTO);
        return listaPessoaDTO;
    }

    public static ListaTerrenoDTO listTerreno2TerrenoDTO(ArrayList<Terreno> terrenos) throws NullPointerException {
        ArrayList<Object> terrenosDTO = new ArrayList<>();
        Forma forma = null;
        for (Terreno terreno : terrenos) {
            try {
                forma = terreno.getForma();
                if (forma instanceof Triangulo) {
                    TerrenoTriangularDTO terrenoDTO = terreno2terrenoTriangularDTO(terreno);
                    terrenosDTO.add(terrenoDTO);
                } else if (forma instanceof Circulo) {
                    TerrenoCircularDTO terrenoDTO = terreno2terrenoCircularDTO(terreno);
                    terrenosDTO.add(terrenoDTO);
                } else if (forma instanceof Rectangulo) {
                    TerrenoRectangularDTO terrenoDTO = terreno2terrenoRectangularDTO(terreno);
                    terrenosDTO.add(terrenoDTO);
                }
            } catch (NullPointerException e) {
                //nada é adicionado
            }
        }
        ListaTerrenoDTO listaTerrenoDTO = new ListaTerrenoDTO();
        listaTerrenoDTO.setTerrenos(terrenosDTO);
        return listaTerrenoDTO;
    }
    
    public static ListaFreguesiaDTO listFreguesia2FreguesiaDTO(ArrayList<Freguesia> freguesias) throws NullPointerException {
        ArrayList<FreguesiaDTO> freguesiasDTO = new ArrayList<>();
        for (Freguesia freguesia : freguesias) {
            try {
                FreguesiaDTO freguesiaDTO = freguesia2FreguesiaDTO(freguesia);
                freguesiasDTO.add(freguesiaDTO);
            } catch (NullPointerException e) {
                //nada é adicionado
            }
        }
        ListaFreguesiaDTO listaFreguesiaDTO = new ListaFreguesiaDTO();
        listaFreguesiaDTO.setFreguesias(freguesiasDTO);
        return listaFreguesiaDTO;
    }

    public static FuncionarioDTO funcionario2FuncionarioDTO(Funcionario funcionario) throws
            NullPointerException {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setNif(funcionario.getNif());
        funcionarioDTO.setNome(funcionario.getNome());
        DataDTO dataDTO = data2dataDTO(funcionario.getNascimento());
        funcionarioDTO.setNascimento(dataDTO);
        funcionarioDTO.setNumeroFuncionario(funcionario.getNumeroFuncionario());
        funcionarioDTO.setCargo(funcionario.getCargo());
        return funcionarioDTO;
    }

    public static Funcionario funcionarioDTO2Funcionario(FuncionarioDTO funcionarioDTO) throws
            NullPointerException {
        Funcionario funcionario = null;
        Data data = dataDTO2data(funcionarioDTO.getNascimento());
        funcionario = new Funcionario(funcionarioDTO.getNif(), funcionarioDTO.getNome(), data, funcionarioDTO.
                getNumeroFuncionario(), funcionarioDTO.getCargo());
        return funcionario;
    }

    public static ListaFuncionarioDTO listFuncionario2FuncionarioDTO(ArrayList<Funcionario> funcionarios)
            throws NullPointerException {
        ArrayList<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            try {
                FuncionarioDTO funcionarioDTO = funcionario2FuncionarioDTO(funcionario);
                funcionariosDTO.add(funcionarioDTO);
            } catch (NullPointerException e) {
                //nada é adicionado
            }
        }
        ListaFuncionarioDTO listaFuncionarioDTO = new ListaFuncionarioDTO();
        listaFuncionarioDTO.setFuncionarios(funcionariosDTO);
        return listaFuncionarioDTO;
    }

    public static ArrayList<Integer> listaNIFsDTO2ListaNIFs(ListaNIFsDTO listaNIFsDTO) {
        return new ArrayList<>(listaNIFsDTO.getNIFs());
    }


}
