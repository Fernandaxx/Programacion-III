package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Mafia {
    private int costoMin;
    private List<Sitio> caminoMin;

    public List<Sitio> getRutaMinMafioso(Graph<Sitio> grafo) {
        this.costoMin = Integer.MAX_VALUE;
        this.caminoMin = new LinkedList<>();
        boolean[] visitados = new boolean[grafo.getSize()];
        List<Sitio> caminoAct = new LinkedList<>();
        int mafia = 0;

        Sitio casa = new Sitio(0, "Casa intendente");
        Vertex<Sitio> inicio = grafo.search(casa);
        Sitio Municipalidad = new Sitio(0, "municipalidad");
        Vertex<Sitio> destino = grafo.search(Municipalidad);

        dfs(inicio, destino, grafo, visitados, caminoAct, mafia);
        return caminoMin;
    }

    private void dfs(Vertex<Sitio> inicio, Vertex<Sitio> destino, Graph<Sitio> grafo, boolean[] visitados,
            List<Sitio> caminoAct, int mafia) {
        visitados[inicio.getPosition()] = true;
        caminoAct.add(inicio.getData());
        mafia += inicio.getData().getMafia();
        if (inicio.equals(destino)) { // de que otra forma se puede comparar?? con las posiciones?
            if (mafia < this.costoMin) {
                this.costoMin = mafia;
                this.caminoMin.clear();
                this.caminoMin.addAll(caminoAct);
            }
        } else {
            List<Edge<Sitio>> ady = grafo.getEdges(inicio);
            for (Edge<Sitio> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j]) {
                    mafia += edge.getWeight();
                    dfs(edge.getTarget(), destino, grafo, visitados, caminoAct, mafia);
                    mafia -= edge.getWeight();

                }
            }
        }
        visitados[inicio.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
        mafia -= inicio.getData().getMafia();

    }
}