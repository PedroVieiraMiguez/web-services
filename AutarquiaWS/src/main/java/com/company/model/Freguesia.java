package com.company.model;

import com.company.exception.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


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
        this.terrenos = freguesia.getAllTerrenos();
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
        if (!updated) {
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
    
    private Terreno getTerrenoByNumID(int numID) {
        Terreno terreno = null;
        for (int i = 0; i < this.terrenos.size(); i++) {
            terreno = this.terrenos.get(i);
            if (terreno.getNumID() == numID) {
                return terreno;
            }
        }
        return null;
    }

    public Terreno getTerreno(int numID) {
        return new Terreno(Objects.requireNonNull(getTerrenoByNumID(numID)));
    }

    public void addProprietario(int numID, Pessoa pessoa) throws ProprietarioTerrenoDuplicadoException {
        Terreno t = getTerrenoByNumID(numID);
        assert t != null;
        if (!t.getProprietarios().contains(pessoa)) {
            t.addProprietario(pessoa);
        }
    }

    public void removeProprietario(int numID, Pessoa pessoa) throws ProprietarioNaoExistenteException {
        Terreno t = getTerrenoByNumID(numID);
        assert t != null;
        if (!t.removeProprietario(pessoa)) {
            throw new ProprietarioNaoExistenteException(pessoa.getNif() + ": não existe nenhum proprietário com este NIF associado ao terreno.");
        }
    }

}
