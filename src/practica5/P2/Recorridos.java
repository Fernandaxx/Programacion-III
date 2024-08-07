package practica5.P2;

import java.util.LinkedList;
import java.util.List;

import practica1.P8.Queue;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Recorridos<T> {

    public void dfs(Graph<T> grafo) {
        boolean[] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitado[i]) {
                dfs(i, grafo, visitado);
            }
        }
    }

    private void dfs(int i, Graph<T> grafo, boolean[] visitado) {
        visitado[i] = true;
        Vertex<T> vertice = grafo.getVertex(i);
        System.out.println(vertice.getData()); // procesa
        List<Edge<T>> adyacentes = grafo.getEdges(vertice); // lista de adyacentes
        for (Edge<T> edge : adyacentes) {
            int j = edge.getTarget().getPosition();
            if (!visitado[j]) {
                dfs(j, grafo, visitado);
            }
        }

    }

    public List<T> dfs_list(Graph<T> grafo) {
        boolean[] visitado = new boolean[grafo.getSize()];
        List<T> recorridoList = new LinkedList<>();
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitado[i]) {
                dfs_list(i, grafo, visitado, recorridoList);
            }
        }
        return recorridoList;
    }

    private void dfs_list(int i, Graph<T> grafo, boolean[] visitado, List<T> lista) {
        visitado[i] = true;
        Vertex<T> vertice = grafo.getVertex(i);
        lista.add(vertice.getData());
        List<Edge<T>> ady = grafo.getEdges(vertice);
        for (Edge<T> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitado[j])
                dfs_list(j, grafo, visitado, lista);
        }
    }

    public void bfs(Graph<T> grafo) {
        boolean[] visitado = new boolean[grafo.getSize()];
        for (int i = 0; i < grafo.getSize(); i++) {
            if (!visitado[i]) {
                bfs(i, grafo, visitado);
            }
        }
    }

    private void bfs(int i, Graph<T> grafo, boolean[] visitado) {
        Queue<Vertex<T>> cola = new Queue<>();
        cola.enqueue(grafo.getVertex(i));
        visitado[i] = true;
        while (!cola.isEmpty()) {
            Vertex<T> v = cola.dequeue();
            System.out.println(v.getData());
            List<Edge<T>> ady = grafo.getEdges(v);
            for (Edge<T> edge : ady) {
                int j = edge.getTarget().getPosition();
                if (!visitado[j]) {
                    visitado[j] = true;
                    cola.enqueue(edge.getTarget());
                }
            }
        }
    }

}
