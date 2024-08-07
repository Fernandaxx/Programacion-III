package practica5.P;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Parcial3 {

    public Retorno resolver(Graph<String> ciudades, String origen, int maxMonto) {
        Retorno R = new Retorno();
        R.setMontoSobrante(maxMonto);
        Vertex<String> inicio = ciudades.search(origen);
        if (inicio != null) {
            List<String> caminoAct = new LinkedList<>();
            boolean[] visitados = new boolean[ciudades.getSize()];
            dfs(inicio.getPosition(), visitados, ciudades, maxMonto, R, caminoAct);
        }
        return R;
    }

    private void dfs(int pos, boolean[] visitados, Graph<String> grafo, int maxMonto, Retorno R,
            List<String> caminoAct) {
        Vertex<String> v = grafo.getVertex(pos);
        visitados[pos] = true;
        caminoAct.add(v.getData());

        if (caminoAct.size() > R.getCamino().size()
                || (caminoAct.size() == R.getCamino().size() && R.getMontoSobrante() < maxMonto)) {
            R.getCamino().clear();
            R.getCamino().addAll(caminoAct);
            R.setMontoSobrante(maxMonto);
        }

        List<Edge<String>> ady = grafo.getEdges(v);
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j] && maxMonto - edge.getWeight() >= 0) {
                dfs(j, visitados, grafo, maxMonto - edge.getWeight(), R, caminoAct);
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

}
