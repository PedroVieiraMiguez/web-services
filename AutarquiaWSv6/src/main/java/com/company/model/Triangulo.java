package com.company.model;

import com.company.exception.AlturaInvalidaException;
import com.company.exception.BaseInvalidaException;
import java.io.Serializable;

public class Triangulo extends Forma implements Serializable {
    
    private double base;
    private double altura;
    
    public Triangulo (double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    @Override
    public double calcularArea() {
        return (double)(getBase() * getAltura()) / 2;
    }

    
    public double getBase() {
        return base;
    }

    
    public void setBase(double base) throws BaseInvalidaException {
        if (base > 0) {
            this.base = base;
        } else {
            throw new BaseInvalidaException(base + ": base inválida");
        }
    }

    
    public double getAltura() {
        return altura;
    }

    
    public void setAltura(double altura) throws AlturaInvalidaException {
        if (altura > 0) {
            this.altura = altura;
        } else {
            throw new AlturaInvalidaException(altura + ": altura inválida");
        }
    }

}
