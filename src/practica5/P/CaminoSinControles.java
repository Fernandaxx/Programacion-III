package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class CaminoSinControles {
    // private Graph<String> mapa;

    public static List<List<String>> devolverCaminos(Graph<String> mapa, String origen, String destino) {

        List<List<String>> caminos = new LinkedList<>();
        Vertex<String> inicio = mapa.search(origen);
        Vertex<String> fin = mapa.search(destino);

        if (inicio != null && fin != null) {
            boolean[] visitados = new boolean[mapa.getSize()];
            List<String> caminoAct = new LinkedList<>();
            dfs(inicio.getPosition(), fin, caminoAct, caminos, visitados, mapa);
        }
        return caminos;
    }

    private static void dfs(int pos, Vertex<String> fin, List<String> caminoAct, List<List<String>> caminos,
            boolean[] visitados, Graph<String> mapa) {
        Vertex<String> v = mapa.getVertex(pos);
        caminoAct.add(v.getData());
        visitados[pos] = true;

        if (v.getData().equals(fin.getData())) {
            caminos.add(new LinkedList<String>(caminoAct));
        }

        List<Edge<String>> ady = mapa.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j] && edge.getWeight() == 0) {
                dfs(j, fin, caminoAct, caminos, visitados, mapa);
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        Vertex<String> stavanger = graph.createVertex("Stavanger");
        Vertex<String> lofoten = graph.createVertex("Lofoten");
        Vertex<String> tromso = graph.createVertex("Tromso");
        Vertex<String> mosjeem = graph.createVertex("Mosjeem");
        Vertex<String> trondheim = graph.createVertex("Trondheim");
        Vertex<String> drammen = graph.createVertex("Drammen");
        Vertex<String> oslo = graph.createVertex("Oslo");
        Vertex<String> berger = graph.createVertex("Berger");
        Vertex<String> norland = graph.createVertex("Nordland");

        graph.connect(stavanger, lofoten, 3);
        graph.connect(lofoten, stavanger, 3); // Conexión en sentido contrario

        graph.connect(stavanger, tromso, 0);
        graph.connect(tromso, stavanger, 0); // Conexión en sentido contrario

        graph.connect(tromso, mosjeem, 0);
        graph.connect(mosjeem, tromso, 0); // Conexión en sentido contrario

        graph.connect(mosjeem, trondheim, 1);
        graph.connect(trondheim, mosjeem, 1); // Conexión en sentido contrario

        graph.connect(trondheim, stavanger, 2);
        graph.connect(stavanger, trondheim, 2); // Conexión en sentido contrario

        graph.connect(drammen, oslo, 0);
        graph.connect(oslo, drammen, 0); // Conexión en sentido contrario

        graph.connect(oslo, berger, 0);
        graph.connect(berger, oslo, 0); // Conexión en sentido contrario

        graph.connect(stavanger, berger, 0);
        graph.connect(berger, stavanger, 0);

        graph.connect(mosjeem, oslo, 0);
        graph.connect(oslo, mosjeem, 0);

        graph.connect(mosjeem, drammen, 1);
        graph.connect(drammen, mosjeem, 1);

        graph.connect(norland, lofoten, 1);
        graph.connect(lofoten, norland, 1);

        graph.connect(norland, mosjeem, 1);
        graph.connect(mosjeem, norland, 1);

        List<List<String>> caminos = devolverCaminos(graph, "Stavanger", "Oslo");
        for (List<String> s : caminos) {
            System.out.println(s);
        }

    }
}
