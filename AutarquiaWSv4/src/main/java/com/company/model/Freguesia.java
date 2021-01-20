package com.company.model;

import com.company.exception.NomeFreguesiaInvalidoException;
import com.company.exception.NomePessoaInvalidoException;
import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class Freguesia implements Serializable {
    
    private String nome;

    public Freguesia() {
    }
    
    public Freguesia(String nome) {
        setNome(nome);
    }
    
    public Freguesia (Freguesia freguesia) {
        setNome(freguesia.getNome());
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
}
