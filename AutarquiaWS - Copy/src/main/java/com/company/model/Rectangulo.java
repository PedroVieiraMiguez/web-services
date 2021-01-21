package com.company.model;

import com.company.exception.ComprimentoInvalidoException;
import com.company.exception.LarguraInvalidaException;
import java.io.Serializable;

public class Rectangulo extends Forma implements Serializable {
    
    private double comprimento;
    private double largura;
    
    public Rectangulo (double comprimento, double largura) {
        setComprimento(comprimento);
        setLargura(largura);
    }
    
    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) throws ComprimentoInvalidoException {
        if (comprimento > 0) {
            this.comprimento = comprimento;
        } else {
            throw new ComprimentoInvalidoException(comprimento + ": comprimento inválido");
        }
    }
    
    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) throws LarguraInvalidaException {
        if (largura > 0) {
            this.largura = largura;
        } else {
            throw new LarguraInvalidaException(largura + ": largura inválido");
        }
    }

    @Override
    public double calcularArea() {
        return getComprimento() * getLargura();
    }
    
}
