package ParcialArboles;

import java.util.LinkedList;
import java.util.List;

public class Result {
    private List<Integer> lista = new LinkedList<Integer>();
    private int cantidad = 0;

    public void incrementarCant() {
        this.cantidad++;
    }

    public void agregarDato(int n) {
        this.lista.add(n);
    }

    public List<Integer> getLista() {
        return lista;
    }

    public int getCantidad() {
        return cantidad;
    }

}
