package practica5.P3;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Mapa {
    private Graph<String> mapaCiudades;

    public Mapa(Graph<String> m) {
        mapaCiudades = m;
    }

    // 1) Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
    // ciudad2 en caso de que se pueda llegar, si no retorna la lista vacía.

    public List<String> devolverCamino(String cuidad1, String ciudad2) {
        if (mapaCiudades == null)
            return null;
        boolean[] visitados = new boolean[mapaCiudades.getSize()];
        Vertex<String> aux = mapaCiudades.search(cuidad1);
        int origen = aux.getPosition();
        List<String> camino = new LinkedList<>();
        dfs(origen, mapaCiudades, visitados, ciudad2, camino);
        return camino;
    }

    private void dfs(int actual, Graph<String> grafo, boolean[] visitados, String destino, List<String> lista) {
        visitados[actual] = true;
        Vertex<String> v = grafo.getVertex(actual);
        lista.add(v.getData());
        if (!v.getData().equals(destino)) {
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j]) {
                    dfs(j, grafo, visitados, destino, lista);
                }
            }
            lista.remove(lista.size() - 1);
            visitados[actual] = false;
        }

    }

}
