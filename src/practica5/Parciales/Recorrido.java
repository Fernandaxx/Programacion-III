package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

public class Recorrido {
    private List<String> camino;
    private int distanciatotal;

    public Recorrido() {
        this.camino = new LinkedList<>();
        this.distanciatotal = 0;
    }

    public List<String> getCamino() {
        return camino;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }

    public int getDistanciatotal() {
        return distanciatotal;
    }

    public void setDistanciatotal(int distanciatotal) {
        this.distanciatotal = distanciatotal;
    }

    public Recorrido(List<String> camino, int distanciatotal) {
        this.camino = new LinkedList<>(camino); // Deep copy
        this.distanciatotal = distanciatotal;
    }

    @Override
    public String toString() {
        return "Recorrido [camino=" + camino + ", distanciatotal=" + distanciatotal + "]";
    }

}
