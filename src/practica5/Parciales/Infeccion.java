package practica5.Parciales;

import java.util.List;

import practica1.P8.Queue;
import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Infeccion {

    public static int tiempoInfeccion(Graph<String> grafo, String Infectada) {
        int tiempo = 0;
        boolean[] visitados = new boolean[grafo.getSize()];
        Vertex<String> origen = grafo.search(Infectada);
        int pos = origen.getPosition();
        visitados[pos] = true;
        Queue<Vertex<String>> cola = new Queue<>();
        Vertex<String> v = grafo.getVertex(pos);
        cola.enqueue(v);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            Vertex<String> w = cola.dequeue();
            if (w != null) {
                List<Edge<String>> ady = grafo.getEdges(w);
                for (Edge<String> edge : ady) {
                    int j = edge.getTarget().getPosition();
                    if (!visitados[j]) {
                        visitados[j] = true;
                        cola.enqueue(edge.getTarget());
                    }
                }
            } else if (!cola.isEmpty()) {
                tiempo++;
                cola.enqueue(null);
            }
        }
        return tiempo;
    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        Vertex<String> c1 = graph.createVertex("c1");
        Vertex<String> c2 = graph.createVertex("c2");
        Vertex<String> c3 = graph.createVertex("c3");
        Vertex<String> c4 = graph.createVertex("c4");
        Vertex<String> c5 = graph.createVertex("c5");
        Vertex<String> c6 = graph.createVertex("c6");
        Vertex<String> c7 = graph.createVertex("c7");
        Vertex<String> c8 = graph.createVertex("c8");
        Vertex<String> c9 = graph.createVertex("c9");
        Vertex<String> c10 = graph.createVertex("c10");

        graph.connect(c1, c2);
        graph.connect(c2, c1);

        graph.connect(c4, c2);
        graph.connect(c2, c4);

        graph.connect(c4, c5);
        graph.connect(c5, c4);

        graph.connect(c2, c5);
        graph.connect(c5, c2);

        graph.connect(c5, c3);
        graph.connect(c3, c5);

        graph.connect(c5, c7);
        graph.connect(c7, c5);

        graph.connect(c3, c6);
        graph.connect(c6, c3);

        graph.connect(c6, c7);
        graph.connect(c7, c6);

        graph.connect(c6, c8);
        graph.connect(c8, c6);

        graph.connect(c6, c10);
        graph.connect(c10, c6);

        graph.connect(c8, c9);
        graph.connect(c9, c8);

        System.out.println(tiempoInfeccion(graph, "c2"));

    }

}
