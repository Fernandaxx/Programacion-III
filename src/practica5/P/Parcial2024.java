package practica5.P;

import java.util.*;
import java.util.LinkedList;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Parcial2024 {

    public static List<String> obtenerCamino(Graph<String> grafo) {
        Result R = new Result();

        Vertex<String> origen = grafo.search("CC");
        Vertex<String> destino = grafo.search("J");
        if (origen != null && destino != null) {
            boolean[] visitados = new boolean[grafo.getSize()];
            List<String> caminoAct = new LinkedList<>();
            int canImperdible = 0;
            dfs(origen.getPosition(), destino, grafo, visitados, caminoAct, R, canImperdible);
        }

        return R.getCamino();
    }

    private static void dfs(int pos, Vertex<String> destino, Graph<String> grafo, boolean[] visitados,
            List<String> caminoAct, Result R, int cantImperdible) {

        Vertex<String> v = grafo.getVertex(pos);
        visitados[pos] = true;
        caminoAct.add(v.getData());

        if (v.getData().equals(destino.getData())) {
            if (cantImperdible > R.getCantImperdibles()
                    || (R.getCantImperdibles() == cantImperdible && R.getCamino().size() > caminoAct.size())) {
                R.getCamino().clear();
                R.getCamino().addAll(caminoAct);
                R.setCantImperdibles(cantImperdible);
            }
        }
        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j]) {
                // cantImperdible += edge.getWeight();
                dfs(j, destino, grafo, visitados, caminoAct, R, cantImperdible + edge.getWeight());
                // cantImperdible -= edge.getWeight();
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {

        /*
         * Graph<String> grafo = new AdjListGraph<>();
         * 
         * Vertex<String> CC = grafo.createVertex("Cedar Creek");
         * Vertex<String> LP = grafo.createVertex("LP");
         * Vertex<String> M = grafo.createVertex("M");
         * Vertex<String> CH = grafo.createVertex("CH");
         * Vertex<String> A = grafo.createVertex("A");
         * Vertex<String> GP = grafo.createVertex("GP");
         * Vertex<String> J = grafo.createVertex("Joshua");
         * 
         * grafo.connect(CC, LP, 0);
         * grafo.connect(LP, CC, 0);
         * 
         * grafo.connect(LP, CH, 1);
         * grafo.connect(CH, LP, 1);
         * 
         * grafo.connect(LP, M, 1);
         * grafo.connect(M, LP, 1);
         * 
         * grafo.connect(CH, A, 1);
         * grafo.connect(A, CH, 1);
         * 
         * grafo.connect(CH, M, 0);
         * grafo.connect(M, CH, 0);
         * 
         * grafo.connect(M, GP, 1);
         * grafo.connect(GP, M, 1);
         * 
         * grafo.connect(GP, J, 0);
         * grafo.connect(J, GP, 0);
         * 
         * grafo.connect(J, M, 0);
         * grafo.connect(M, J, 0);
         * 
         * List<String> lista = obtenerCamino(grafo);
         * System.out.println(lista);
         */

        Graph<String> grafo = new AdjListGraph<>();

        Vertex<String> v1 = grafo.createVertex("CC");
        Vertex<String> v2 = grafo.createVertex("LP");
        Vertex<String> v3 = grafo.createVertex("CH");
        Vertex<String> v4 = grafo.createVertex("A");
        Vertex<String> v5 = grafo.createVertex("M");
        Vertex<String> v6 = grafo.createVertex("GP");
        Vertex<String> v7 = grafo.createVertex("J");

        grafo.connect(v1, v2, 0);
        grafo.connect(v2, v1, 0);

        grafo.connect(v2, v3, 1);
        grafo.connect(v3, v2, 1);

        grafo.connect(v2, v5, 1);
        grafo.connect(v5, v2, 1);

        grafo.connect(v3, v4, 1);
        grafo.connect(v4, v3, 1);

        grafo.connect(v3, v5, 1);
        grafo.connect(v5, v3, 1);

        grafo.connect(v5, v6, 1);
        grafo.connect(v6, v5, 1);

        grafo.connect(v5, v7, 0);
        grafo.connect(v7, v5, 0);

        grafo.connect(v6, v7, 0);
        grafo.connect(v7, v6, 0);

        grafo.connect(v6, v4, 0);
        grafo.connect(v4, v6, 0);

        grafo.connect(v4, v1, 1);
        grafo.connect(v1, v4, 1);

        grafo.connect(v1, v3, 1);
        grafo.connect(v3, v1, 1);

        List<String> lista = obtenerCamino(grafo);
        System.out.println(lista);

    }

}
