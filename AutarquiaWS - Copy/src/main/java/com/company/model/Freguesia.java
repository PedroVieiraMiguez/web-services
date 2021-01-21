package com.company.model;

import com.company.exception.ElementoNaoExistenteException;
import com.company.exception.IdTerrenoInvalidoException;
import com.company.exception.NomeFreguesiaInvalidoException;
import com.company.exception.NomePessoaInvalidoException;
import java.io.Serializable;
import java.util.ArrayList;


public class Freguesia implements Serializable {
    
    private String nome;
    private ArrayList<Terreno> terrenos;

    public Freguesia() {
    }
    
    public Freguesia(String nome) {
        setNome(nome);
        this.terrenos = new ArrayList<>();
    }
    
    public Freguesia (Freguesia freguesia) {
        setNome(freguesia.getNome());
        this.terrenos = new ArrayList<>();
    }

    public ArrayList<Integer> getAllIDs() {
        ArrayList<Integer> allIDs = new ArrayList<>();
        for (Terreno t : this.terrenos) {
            allIDs.add(t.getNumID());
        }
        return allIDs;
    }
    
    public ArrayList<Terreno> getAllTerrenos() {
        return new ArrayList<>(terrenos);
    }
    
    public boolean addTerreno(Terreno terreno) throws IdTerrenoInvalidoException {
        Terreno t = getTerrenoByNumID(terreno.getNumID());
        if (t == null) {
            this.terrenos.add(terreno);
            return true;
        } else {
            throw new IdTerrenoInvalidoException(t.getNumID() + ": Terreno já existe");
        }
    }
    
    public void removeTerreno(int numID) throws ElementoNaoExistenteException {
        Terreno terreno = null;
        for (int i = 0; i < this.terrenos.size(); i++) {
            terreno = this.terrenos.get(i);
            if (terreno.getNumID() == numID) {
                this.terrenos.remove(i);
                    return;
            }
        }
        throw new ElementoNaoExistenteException(nome + ": Não existe esse terreno");
    }
    
    public void updateTerreno(int numID, Terreno t) throws ElementoNaoExistenteException {
        Terreno terreno = null;
        boolean updated = false;
        for (int i = 0; i < this.terrenos.size() && !updated; i++) {
            terreno = this.terrenos.get(i);
            if (terreno.getNumID() == numID) {
                this.terrenos.set(i, t);
                updated = true;
            }
        }
        if (updated == false) {
            throw new ElementoNaoExistenteException(nome + ": Não existe essa freguesia");
        }
    }

    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) throws NomeFreguesiaInvalidoException {
        if (eNomeValido(nome)) {
            this.nome = nome;
        } else {
            throw new NomePessoaInvalidoException(nome + ": Nome inv´alido");
        }
    }
    
    private boolean eNomeValido(String nome) {
        if (nome == null) {
            return false;
        }
        if (nome.length() < 3) {
            return false;
        }
        for (int i = 0; i < nome.length(); i++) {
            if (Character.isDigit(nome.charAt(i))) {
                return false;
            }

        }
        return true;
    }
    
    public Terreno getTerrenoByNumID(int numID) {
        Terreno terreno = null;
        for (int i = 0; i < this.terrenos.size(); i++) {
            terreno = this.terrenos.get(i);
            if (terreno.getNumID() == numID) {
                Terreno copia = new Terreno(terreno);
                return copia;
            }
        }
        return null;
    }
}
