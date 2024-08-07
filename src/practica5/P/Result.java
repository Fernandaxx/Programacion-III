package practica5.P;

import java.util.LinkedList;
import java.util.List;

public class Result {
    private List<String> camino;
    private int cantImperdibles;

    public List<String> getCamino() {
        return camino;
    }

    public Result() {
        this.camino = new LinkedList<>();
        this.cantImperdibles = -1;
    }

    public int getCantImperdibles() {
        return cantImperdibles;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }

    public void setCantImperdibles(int cantImperdibles) {
        this.cantImperdibles = cantImperdibles;
    }

}
