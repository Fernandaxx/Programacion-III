package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Mafia {

    public static List<String> devolverRuta(Graph<String> grafo) {
        List<String> lista = new LinkedList<>();
        Vertex<String> origen = grafo.search("Casa del Intendente");
        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> camino = new LinkedList<>();
        // int mafia = 0, mafiaLista = 99999;
        dfs(origen.getPosition(), grafo, camino, visitados, 0, 9999, lista);
        return lista;
    }

    private static void dfs(int pos, Graph<String> grafo, List<String> camino, boolean[] visitados, int mafia,
            int mafiaLista, List<String> lista) {
        visitados[pos] = true;
        Vertex<String> v = grafo.getVertex(pos);
        camino.add(v.getData());
        if (v.getData().equals("M"))
            mafia++;
        if (v.getData().equals("Municipalidad") && mafia < mafiaLista) {
            mafiaLista = mafia;
            lista.clear();
            lista.addAll(camino);
        } else {
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                mafia += edge.getWeight();
                if (!visitados[j]) {
                    dfs(j, grafo, camino, visitados, mafia, mafiaLista, lista);
                }
                mafia -= edge.getWeight();
            }
            camino.remove(camino.size() - 1);
            visitados[pos] = false;
            mafia--;
        }
    }

    public static void main(String[] args) {

        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> m1 = grafo.createVertex("M");
        Vertex<String> m2 = grafo.createVertex("M");
        Vertex<String> inte = grafo.createVertex("Casa del Intendente");
        Vertex<String> mun = grafo.createVertex("Municipalidad");
        Vertex<String> v1 = grafo.createVertex("holi");
        Vertex<String> v2 = grafo.createVertex("chau");

        grafo.connect(inte, m1, 0);
        grafo.connect(m1, inte, 0); // Conexión bidireccional
        grafo.connect(inte, m2, 0);
        grafo.connect(m2, inte, 0); // Conexión bidireccional
        grafo.connect(inte, v1, 1);
        grafo.connect(v1, inte, 1); // Conexión bidireccional
        grafo.connect(v1, m2, 0);
        grafo.connect(m2, v1, 0); // Conexión bidireccional
        grafo.connect(v1, mun, 1);
        grafo.connect(mun, v1, 1); // Conexión bidireccional
        grafo.connect(m2, mun, 1);
        grafo.connect(mun, m2, 1); // Conexión bidireccional
        grafo.connect(mun, v2, 0);
        grafo.connect(v2, mun, 0); // Conexión bidireccional
        grafo.connect(v2, m1, 0);
        grafo.connect(m1, v2, 0);

        System.out.println(devolverRuta(grafo));

    }

}
