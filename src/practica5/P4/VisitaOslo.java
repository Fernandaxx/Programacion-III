package practica5.P4;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
            List<String> lugaresRestringidos, Integer tiempo) {
        List<String> camino = new LinkedList<>();
        Vertex<String> origen = lugares.search("Ayuntamiento");
        if (origen != null) {
            boolean[] visitados = new boolean[lugares.getSize()];
            List<String> caminoAct = new LinkedList<>();
            int tiempoAct = 0;
            tiempo = 0;
            dfs(origen.getPosition(), lugares, destino, maxTiempo, lugaresRestringidos, visitados, camino, caminoAct,
                    tiempo, tiempoAct);

        }
        return camino;
    }

    private void dfs(int pos, Graph<String> grafo, String destino, int maxTiempo,
            List<String> lugaresRestringidos, boolean[] visitados, List<String> camino, List<String> caminoAct,
            Integer tiempo, int tiempoAct) {

        Vertex<String> v = grafo.getVertex(pos);
        if (lugaresRestringidos.contains(v.getData()))
            return;
        caminoAct.add(v.getData());
        visitados[pos] = true;

        if (v.getData().equals(destino)) {
            if (tiempoAct < maxTiempo) {
                tiempo = tiempoAct;
                camino.clear();
                camino.addAll(caminoAct);
            }
        } else {
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j]) {
                    tiempoAct += edge.getWeight();
                    if (tiempoAct < maxTiempo)
                        dfs(j, grafo, destino, maxTiempo, lugaresRestringidos, visitados, camino, caminoAct, tiempo,
                                tiempoAct);
                    tiempoAct -= edge.getWeight();
                }
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);

    }
}
