package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class CiudadLP {

    public static List<Recorrido> resolver(Graph<String> grafo, String origen, String destino,
            List<String> evitarPasarPor) {
        List<Recorrido> lista = new LinkedList<>();

        Vertex<String> ori = grafo.search(origen);
        Vertex<String> dest = grafo.search(destino);
        if (ori != null && dest != null) {
            boolean[] visitados = new boolean[grafo.getSize()];
            Recorrido caminoAct = new Recorrido();
            dfs(ori.getPosition(), visitados, grafo, destino, caminoAct, lista, evitarPasarPor);
        }
        return lista;

    }

    private static void dfs(int pos, boolean[] visitados, Graph<String> grafo, String destino,
            Recorrido caminoAct, List<Recorrido> lista, List<String> evitar) {
        visitados[pos] = true;
        Vertex<String> v = grafo.getVertex(pos);
        if (!evitar.contains(v.getData())) {
            caminoAct.getCamino().add(v.getData());

            if (v.getData().equals(destino)) {
                lista.add(new Recorrido(caminoAct.getCamino(), caminoAct.getDistanciatotal()));
            } else {
                List<Edge<String>> ady = grafo.getEdges(v);
                for (Edge<String> edge : ady) {
                    int j = edge.getTarget().getPosition();
                    if (!visitados[j]) {
                        caminoAct.setDistanciatotal(caminoAct.getDistanciatotal() + edge.getWeight());
                        dfs(j, visitados, grafo, destino, caminoAct, lista, evitar);
                        caminoAct.setDistanciatotal(caminoAct.getDistanciatotal() - edge.getWeight());
                    }
                }
            }
            caminoAct.getCamino().remove(caminoAct.getCamino().size() - 1);
        }
        visitados[pos] = false;
    }

    public static void main(String[] args) {

        Graph<String> graph = new AdjListGraph<>();
        Vertex<String> estadio = graph.createVertex("Estadio Diego Armando Maradona");
        Vertex<String> legislatura = graph.createVertex("Legislatura");
        Vertex<String> coliseo = graph.createVertex("Coliseo Podestá");
        Vertex<String> macla = graph.createVertex("MACLA");
        Vertex<String> catedral = graph.createVertex("Catedral La Plata");
        Vertex<String> rectorado = graph.createVertex("Rectorado UNLP");
        Vertex<String> museo = graph.createVertex("Museo UNLP");
        Vertex<String> palacio = graph.createVertex("Palacio Campodónico");

        // Crear las aristas en ambas direcciones para un grafo no dirigido
        graph.connect(estadio, legislatura, 25);
        graph.connect(legislatura, estadio, 25);

        graph.connect(estadio, macla, 35);
        graph.connect(macla, estadio, 35);

        graph.connect(estadio, catedral, 40);
        graph.connect(catedral, estadio, 40);

        graph.connect(estadio, coliseo, 20);
        graph.connect(coliseo, estadio, 20);

        graph.connect(legislatura, coliseo, 25);
        graph.connect(coliseo, legislatura, 25);

        graph.connect(coliseo, palacio, 10);
        graph.connect(palacio, coliseo, 10);

        graph.connect(macla, catedral, 8);
        graph.connect(catedral, macla, 8);

        graph.connect(catedral, rectorado, 5);
        graph.connect(rectorado, catedral, 5);

        graph.connect(rectorado, museo, 15);
        graph.connect(museo, rectorado, 15);

        graph.connect(rectorado, palacio, 30);
        graph.connect(palacio, rectorado, 30);

        List<String> evitar = new LinkedList<>();
        evitar.add("Legislatura");
        evitar.add("MACLA");

        List<Recorrido> l = resolver(graph, "Estadio Diego Armando Maradona", "Palacio Campodónico", evitar);
        System.out.println(l);

    }
}
