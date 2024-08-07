package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Parcial2020 {

    public List<List<String>> resolver(Graph<String> ciudades, String origen, String destino, String pasandoPor) {
        List<List<String>> caminos = new LinkedList<>();
        Vertex<String> inicio = ciudades.search(origen);
        List<String> caminoAct = new LinkedList<>();
        boolean[] visitados = new boolean[ciudades.getSize()];
        dfs(inicio.getPosition(), visitados, ciudades, caminoAct, caminos, destino, pasandoPor);
        return caminos;
    }

    private void dfs(int pos, boolean[] visitados, Graph<String> grafo, List<String> caminoAct,
            List<List<String>> caminos,
            String destino, String pasandoPor) {
        Vertex<String> v = grafo.getVertex(pos);

        visitados[pos] = true;
        caminoAct.add(v.getData());
        if (v.getData().equals(destino) && caminoAct.contains(pasandoPor)) {
            caminos.add(new LinkedList<>(caminoAct));

        } else {

            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j] && edge.getWeight() == 1) { // 1 habilitado, 0 NH
                    dfs(j, visitados, grafo, caminoAct, caminos, destino, pasandoPor);
                }
            }
        }
        caminoAct.remove(caminoAct.size() - 1);
        visitados[pos] = false;
    }

}
