package com.company.model;

import com.company.exception.IdTerrenoInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;


public class Terreno implements Serializable {
    
    private int numID;
    private Forma forma;
    private ArrayList<Pessoa> proprietarios;
    
    public Terreno (int numID, Forma forma) {
        setNumID(numID);
        setForma(forma);
        setProprietarios(new ArrayList<>());
    }

    public Terreno (int numID, Forma forma, Pessoa proprietario) {
        setNumID(numID);
        setForma(forma);
        setProprietarios(new ArrayList<>());
        addProprietario(proprietario);
    }

    public Terreno (int numID, Forma forma, ArrayList<Pessoa> proprietarios) {
        setNumID(numID);
        setForma(forma);
        setProprietarios(proprietarios);
    }
    
    public Terreno (Terreno terreno) {
        setNumID(terreno.getNumID());
        setForma(terreno.getForma());
        setProprietarios(terreno.getProprietarios());
    }

    
    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        if (numID > 0) {
            this.numID = numID;
        } else {
            throw new IdTerrenoInvalidoException(numID + " :número de ID do terreno inválido.");
        }
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public double getArea() {
        return forma.calcularArea();
    }


    public ArrayList<Pessoa> getProprietarios() {
        return new ArrayList<>(proprietarios);
    }

    public void setProprietarios(ArrayList<Pessoa> proprietarios) {
        this.proprietarios = proprietarios;
    }

    public void addProprietario(Pessoa pessoa) {
        this.proprietarios.add(pessoa);
    }

    public boolean removeProprietario(Pessoa pessoa) {
        return this.proprietarios.remove(pessoa);
    }
}
