package practica5.P;

import java.util.*;
import java.util.LinkedList;

public class Retorno {
    private List<String> camino;
    private int montoSobrante;

    public List<String> getCamino() {
        return camino;
    }

    public int getMontoSobrante() {
        return montoSobrante;
    }

    public Retorno() {
        this.camino = new LinkedList<>();
        this.montoSobrante = 0;
    }

    public void setMontoSobrante(int montoSobrante) {
        this.montoSobrante = montoSobrante;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }

    @Override
    public String toString() {
        return "Retorno [camino=" + camino + ", montoSobrante=" + montoSobrante + ", cantCiudades=" + this.camino.size()
                + "]";
    }

}
