package com.company.model;

import com.company.exception.IdTerrenoInvalidoException;


public class Terreno {
    
    private int numID;
    private Forma forma;
    private double area;
    
    public Terreno (int numID, Forma forma) {
        setNumID(numID);
        setForma(forma);
        setArea(forma.calcularArea());
    }

    
    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) throws IdTerrenoInvalidoException {
        if (numID > 0) {
            this.numID = numID;
        } else {
            throw new IdTerrenoInvalidoException(numId + " :número de ID do terreno inválido.");
        }
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
    

}
