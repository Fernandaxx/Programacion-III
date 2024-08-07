package practica5.P6;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Caperucita {
    private Graph<String> bosque;

    public Caperucita(Graph<String> bosque) {
        this.bosque = bosque;
    }

    public List<List<String>> recorridosMasSeguro() {
        List<List<String>> caminos = new LinkedList<>();
        Vertex<String> casaCap = bosque.search("Casa Caperucita");
        if (casaCap != null) {
            boolean[] visitados = new boolean[bosque.getSize()];
            List<String> caminoAct = new LinkedList<>();
            dfs(casaCap.getPosition(), visitados, caminoAct, caminos);

        }
        return caminos;
    }

    private void dfs(int pos, boolean[] visitados, List<String> caminoAct,
            List<List<String>> caminos) {

        Vertex<String> v = bosque.getVertex(pos);
        caminoAct.add(v.getData());
        visitados[pos] = true;

        if (v.getData().equals("Casa Abuelita")) {
            caminos.add(new LinkedList<>(caminoAct));

        } else {
            List<Edge<String>> ady = bosque.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j] && edge.getWeight() < 5) {
                    dfs(j, visitados, caminoAct, caminos);
                }
            }
        }

        caminoAct.remove(caminoAct.size() - 1);
        visitados[pos] = false;

    }
}
