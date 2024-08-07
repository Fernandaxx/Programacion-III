package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class MapaDeBicisendas {
    // private Graph<String> grafo;

    public static List<String> buscarCaminoEntreOrigenYDestino(Graph<String> grafo, String origen, String destino) {
        List<String> lista = new LinkedList<>();
        Vertex<String> or = grafo.search(origen);
        Vertex<String> dest = grafo.search(destino);
        if (or != null && dest != null) {
            boolean[] visitados = new boolean[grafo.getSize()];
            List<String> camino = new LinkedList<>();
            dfs(or.getPosition(), grafo, visitados, destino, lista, camino);
        }
        return lista;
    }

    static private void dfs(int pos, Graph<String> grafo, boolean[] visitados, String destino, List<String> lista,
            List<String> camino) {
        visitados[pos] = true;
        Vertex<String> v = grafo.getVertex(pos);
        camino.add(v.getData());
        if (v.getData().equals(destino)) {
            lista.addAll(camino);
        } else {
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitados[j]) {
                    dfs(j, grafo, visitados, destino, lista, camino);
                }
            }
            camino.remove(camino.size() - 1);
            visitados[pos] = false;
        }
    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        // Create vertices
        Vertex<String> v1 = graph.createVertex("Estación 1");
        Vertex<String> v2 = graph.createVertex("Estación 2");
        Vertex<String> v3 = graph.createVertex("Estación 3");
        Vertex<String> v4 = graph.createVertex("Estación 4");
        Vertex<String> v5 = graph.createVertex("Estación 5");
        Vertex<String> v6 = graph.createVertex("Estación 6");
        Vertex<String> v7 = graph.createVertex("Estación 7");
        Vertex<String> v8 = graph.createVertex("Estación 8");

        // Connect vertices (based on your diagram) - undirected
        graph.connect(v1, v2);
        graph.connect(v2, v1);

        graph.connect(v2, v6);
        graph.connect(v6, v2);

        graph.connect(v1, v4);
        graph.connect(v4, v1);

        graph.connect(v6, v4);
        graph.connect(v4, v6);

        graph.connect(v3, v8);
        graph.connect(v8, v3);

        graph.connect(v8, v7);
        graph.connect(v7, v8);

        graph.connect(v5, v7);
        graph.connect(v7, v5);

        System.out.println(buscarCaminoEntreOrigenYDestino(graph, "Estación 1", "Estación 6"));

    }

}
