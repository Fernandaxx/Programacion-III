package practica5.Parciales;

import java.util.List;

import practica1.P8.Queue;
import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Popularidad {

    public static Result nivelPopularidad(Graph<String> red, String usuario, int distancia, int umbral) {
        Result r = null;

        Vertex<String> v = red.search(usuario);
        if (v != null) {
            r = new Result(0, false);
            boolean[] visitados = new boolean[red.getSize()];
            Queue<Vertex<String>> cola = new Queue<>();
            int nivel = 0;
            int pos = v.getPosition();
            visitados[pos] = true;

            cola.enqueue(v);
            cola.enqueue(null);
            while (!cola.isEmpty() && nivel <= distancia) {
                Vertex<String> w = cola.dequeue();
                if (w != null) {
                    if (nivel == distancia) {
                        r.setCantUsers(r.getCantUsers() + 1);
                    }
                    if (r.getCantUsers() >= umbral) {
                        r.setPopularidad(true);
                    }
                    List<Edge<String>> ady = red.getEdges(w);
                    for (Edge<String> edge : ady) {
                        int j = edge.getTarget().getPosition();
                        if (!visitados[j]) {
                            visitados[j] = true;
                            cola.enqueue(edge.getTarget());
                        }
                    }
                } else if (!cola.isEmpty()) {
                    nivel++;
                    cola.enqueue(null);
                }

            }
        }
        return r;

    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Lionel");
        Vertex<String> v2 = grafo.createVertex("Rodrigo");
        Vertex<String> v3 = grafo.createVertex("Ángel");
        Vertex<String> v4 = grafo.createVertex("Emiliano");
        Vertex<String> v5 = grafo.createVertex("Julián");
        Vertex<String> v6 = grafo.createVertex("Diego");
        Vertex<String> v7 = grafo.createVertex("Lautaro");
        Vertex<String> v8 = grafo.createVertex("Enzo");

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);

        grafo.connect(v1, v3);
        grafo.connect(v3, v1);

        grafo.connect(v2, v4);
        grafo.connect(v4, v2);

        grafo.connect(v2, v5);
        grafo.connect(v5, v2);

        grafo.connect(v3, v5);
        grafo.connect(v5, v3);

        grafo.connect(v3, v6);
        grafo.connect(v6, v3);

        grafo.connect(v6, v7);
        grafo.connect(v7, v6);

        grafo.connect(v5, v7);
        grafo.connect(v7, v5);

        grafo.connect(v6, v8);
        grafo.connect(v8, v6);

        grafo.connect(v4, v8);
        grafo.connect(v8, v4);

        grafo.connect(v4, v7);
        grafo.connect(v7, v4);

        System.out.println(nivelPopularidad(grafo, "Lionel", 2, 3));
        System.out.println(nivelPopularidad(grafo, "Lionel", 1, 3));
        System.out.println(nivelPopularidad(grafo, "Matias", 1, 0));
    }
}
