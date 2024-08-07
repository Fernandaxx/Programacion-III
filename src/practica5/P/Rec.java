package practica5.P;

import java.util.*;
import java.util.LinkedList;

public class Rec {
    private List<String> camino;
    private int imperdible;
    private int opcional;

    public Rec() {
        this.camino = new LinkedList<>();
        this.imperdible = 0;
        this.opcional = 0;
    }

    public List<String> getCamino() {
        return camino;
    }

    public int getImperdible() {
        return imperdible;
    }

    public int getOpcional() {
        return opcional;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }

    public void setImperdible(int imperdible) {
        this.imperdible = imperdible;
    }

    public void setOpcional(int opcional) {
        this.opcional = opcional;
    }
}
