package com.company.model;

import com.company.exception.IdTerrenoInvalidoException;
import java.io.Serializable;


public class Terreno implements Serializable {
    
    private int numID;
    private Forma forma;
    
    public Terreno (int numID, Forma forma) {
        setNumID(numID);
        setForma(forma);
    }
    
    public Terreno (Terreno terreno) {
        setNumID(terreno.getNumID());
        setForma(terreno.getForma());
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

    

}
