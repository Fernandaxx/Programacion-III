package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Estadios {

    public static List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm) {
        List<String> lista = new LinkedList<>();
        int or = -1;
        List<Vertex<Estadio>> vertices = mapaEstadios.getVertices();
        for (Vertex<Estadio> vertex : vertices) {
            if (vertex.getData().getNombre().equals(estadioOrigen)) {
                or = vertex.getPosition();
            }
        }
        Vertex<Estadio> origen = mapaEstadios.getVertex(or);
        if (origen != null) {
            boolean[] visitados = new boolean[mapaEstadios.getSize()];
            List<String> caminoAct = new LinkedList<>();
            dfs(or, mapaEstadios, lista, caminoAct, cantKm, visitados);
        }
        return lista;
    }

    private static void dfs(int pos, Graph<Estadio> mapaEstadios, List<String> lista, List<String> caminoAct,
            int cantKm,
            boolean[] visitados) {
        visitados[pos] = true;
        Vertex<Estadio> v = mapaEstadios.getVertex(pos);
        caminoAct.add(v.getData().getNombre());
        if (caminoAct.size() > lista.size()) {
            lista.clear();
            lista.addAll(caminoAct);
        }
        List<Edge<Estadio>> ady = mapaEstadios.getEdges(v);
        for (Edge<Estadio> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j] && cantKm >= edge.getWeight()) {
                dfs(j, mapaEstadios, lista, caminoAct, cantKm - edge.getWeight(), visitados);
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {
        Graph<Estadio> graph = new AdjListGraph<>();

        Vertex<Estadio> e1 = graph.createVertex(new Estadio("AI BAYT STADIUM", "Jor"));
        Vertex<Estadio> e2 = graph.createVertex(new Estadio("LUSAIL STADIUM", "Lusail"));
        Vertex<Estadio> e3 = graph.createVertex(new Estadio("STADIUM", "Doha"));
        Vertex<Estadio> e4 = graph.createVertex(new Estadio("EDUCATION CITY STADIL", "Rayán"));
        Vertex<Estadio> e5 = graph.createVertex(new Estadio("AL RAYYAN STADIUM", "Rayán"));
        Vertex<Estadio> e6 = graph.createVertex(new Estadio("KHALIFA INTERNATIONAL STADIUM", "Doha"));
        Vertex<Estadio> e7 = graph.createVertex(new Estadio("AL THUMAMA STADIUM", "Doha"));
        Vertex<Estadio> e8 = graph.createVertex(new Estadio("AL JANOUB STADIUM", "wakrah"));

        graph.connect(e1, e2, 42);
        graph.connect(e2, e1, 42);

        graph.connect(e2, e3, 52);
        graph.connect(e3, e2, 52);

        graph.connect(e2, e4, 24);
        graph.connect(e4, e2, 24);

        graph.connect(e4, e5, 11);
        graph.connect(e5, e4, 11);

        graph.connect(e6, e5, 8);
        graph.connect(e5, e6, 8);

        graph.connect(e6, e7, 12);
        graph.connect(e7, e6, 12);

        graph.connect(e7, e8, 12);
        graph.connect(e8, e7, 12);

        graph.connect(e8, e2, 19);
        graph.connect(e2, e8, 19);

        System.out.println(estadios(graph, "AI BAYT STADIUM", 100));
    }
}
