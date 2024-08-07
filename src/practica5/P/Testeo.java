package practica5.P;

import java.util.List;

import practica1.P8.Queue;
import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Testeo {

    public static Graph<String> CrearGrafo() {
        Graph<String> grafo = new AdjListGraph<>();
        Vertex<String> v1 = grafo.createVertex("A");
        Vertex<String> v2 = grafo.createVertex("B");
        Vertex<String> v3 = grafo.createVertex("C");
        Vertex<String> v4 = grafo.createVertex("D");
        Vertex<String> v5 = grafo.createVertex("E");
        Vertex<String> v6 = grafo.createVertex("F");
        Vertex<String> v7 = grafo.createVertex("G");

        grafo.connect(v1, v2); // A->B
        grafo.connect(v1, v3);// A->C

        grafo.connect(v2, v5);// B->E

        // C-> null

        grafo.connect(v4, v7);// D->G
        grafo.connect(v4, v1);// D->A

        grafo.connect(v5, v6);// E->F
        grafo.connect(v5, v4);// E->D

        grafo.connect(v6, v7); // F->G

        // G->null
        return grafo;
    }

    public static void ImprimirDFS(Graph<String> grafo) {
        boolean[] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitado[i]) {
                imprimirdfs(i, grafo, visitado);
            }
        }
    }

    private static void imprimirdfs(int i, Graph<String> grafo, boolean[] visitado) {
        visitado[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        System.out.println(v.getData());
        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitado[j]) {
                imprimirdfs(j, grafo, visitado);
            }

        }
    }

    public static void ImprimirBFS(Graph<String> grafo) {
        boolean[] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitado[i]) {
                imprimirbfs(i, grafo, visitado);
            }
        }
    }

    private static void imprimirbfs(int i, Graph<String> grafo, boolean[] visitado) {
        visitado[i] = true;
        Queue<Vertex<String>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        while (!cola.isEmpty()) {
            Vertex<String> w = cola.dequeue();
            System.out.println(w.getData());
            List<Edge<String>> ady = grafo.getEdges(w);
            for (Edge<String> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitado[j]) {
                    visitado[j] = true;
                    cola.enqueue(edge.getTarget());
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> grafo = CrearGrafo();
        ImprimirDFS(grafo);
        ImprimirBFS(grafo);
    }
}
