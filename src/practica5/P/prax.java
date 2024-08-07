package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica1.P8.Queue;
import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class prax {

    public static Graph<String> crearGrafo() {
        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> va = grafo.createVertex("A");
        Vertex<String> vb = grafo.createVertex("B");
        Vertex<String> vc = grafo.createVertex("C");
        Vertex<String> vd = grafo.createVertex("D");
        Vertex<String> ve = grafo.createVertex("E");
        Vertex<String> vf = grafo.createVertex("F");
        Vertex<String> vg = grafo.createVertex("G");

        grafo.connect(va, vc);
        grafo.connect(va, vb);

        grafo.connect(vb, vc);
        grafo.connect(vc, vd);
        grafo.connect(vd, ve);

        grafo.connect(vc, vf);
        grafo.connect(vf, vg);

        return grafo;
    }

    public static void printDfs(Graph<String> grafo) {
        boolean[] visitados = new boolean[grafo.getSize()];
        for (int i = 0; i < visitados.length; i++) {
            if (!visitados[i]) {
                dfs(i, grafo, visitados);
            }
        }
    }

    private static void dfs(int i, Graph<String> grafo, boolean[] visitados) {
        visitados[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        System.out.print(v.getData() + " | ");

        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j]) {
                dfs(j, grafo, visitados);
            }
        }

    }

    public static List<String> listaDfs(Graph<String> grafo) {
        boolean[] visitados = new boolean[grafo.getSize()];
        List<String> lista = new LinkedList<>();
        for (int i = 0; i < visitados.length; i++) {
            if (!visitados[i]) {
                dfs_lista(i, grafo, visitados, lista);
            }
        }
        return lista;
    }

    private static void dfs_lista(int i, Graph<String> grafo, boolean[] visitados, List<String> lista) {
        visitados[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        lista.add(v.getData());
        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j]) {
                dfs_lista(j, grafo, visitados, lista);
            }
        }
    }

    public static void printBfs(Graph<String> grafo) {
        boolean[] visitados = new boolean[grafo.getSize()];
        for (int i = 0; i < visitados.length; i++) {
            if (!visitados[i]) {
                Bfs(i, grafo, visitados);
            }
        }
    }

    private static void Bfs(int i, Graph<String> grafo, boolean[] visitados) {
        Queue<Vertex<String>> cola = new Queue<>();
        visitados[i] = true;
        cola.enqueue(grafo.getVertex(i));
        while (!cola.isEmpty()) {
            Vertex<String> v = cola.dequeue();
            System.out.print(v.getData() + " | ");
            List<Edge<String>> ady = grafo.getEdges(v);
            for (Edge<String> edge : ady) {
                if (!visitados[edge.getTarget().getPosition()]) {
                    visitados[edge.getTarget().getPosition()] = true;
                    cola.enqueue(edge.getTarget());
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<String> grafo = crearGrafo();
        // printDfs(grafo);
        System.out.println("DFS");
        System.out.println(listaDfs(grafo));

        System.out.println("BFS");
        printBfs(grafo);
    }
}
