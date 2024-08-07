package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class EjerParcial2 {

    LinkedList<LinkedList<String>> caminosCosto10(Graph<String> grafo) {
        boolean[] visitados = new boolean[grafo.getSize()];
        LinkedList<LinkedList<String>> recorridos = new LinkedList<>();
        LinkedList<String> lista = null;
        int costo = 0;
        for (int i = 0; i < grafo.getSize(); i++) {
            lista = new LinkedList<>();
            lista.add(grafo.getVertex(i).getData());
            visitados[i] = true;
            caminosCosto10(i, grafo, visitados, recorridos, costo, lista);
            visitados[i] = false;
        }
        return recorridos;
    }

    private void caminosCosto10(int i, Graph<String> grafo, boolean[] visitado,
            LinkedList<LinkedList<String>> recorridos, int costo, LinkedList<String> lista) {
        Vertex<String> vDestino = null;
        int p = 0, j = 0;
        Vertex<String> v = grafo.getVertex(i);
        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            j = edge.getTarget().getPosition();
            if (!visitado[j]) {
                p = edge.getWeight();
                if ((costo + p) <= 10) {
                    vDestino = edge.getTarget();
                    lista.add(vDestino.getData());
                    visitado[j] = true;
                    if ((costo + p) == 10)
                        recorridos.add(new LinkedList<String>(lista));
                    else
                        caminosCosto10(j, grafo, visitado, recorridos, costo + p, lista);
                    lista.remove(vDestino.getData());
                    visitado[j] = false;
                }
            }
        }

    }
}
