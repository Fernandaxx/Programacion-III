package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Temaiken2 {
    public static int resolver(Graph<Recinto> sitios, int tiempo) {
        List<Recinto> lista = new LinkedList<>();
        // Recinto R = new Recinto("Entrada", 15);
        // Vertex<Recinto> origen = sitios.search(R);
        int or = -1;
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        for (Vertex<Recinto> vertex : vertices) {
            if (vertex.getData().getNombre().equals("Entrada")) {
                or = vertex.getPosition();
            }
        }
        Vertex<Recinto> origen = sitios.getVertex(or);
        if (origen != null) {
            boolean[] visitados = new boolean[sitios.getSize()];
            List<Recinto> caminoAct = new LinkedList<>();
            dfs(origen.getPosition(), visitados, lista, caminoAct, tiempo, sitios);
        }
        System.out.println(lista);
        return lista.size();
    }

    private static void dfs(int pos, boolean[] visitados, List<Recinto> lista, List<Recinto> caminoAct,
            int tiempo, Graph<Recinto> grafo) {
        visitados[pos] = true;
        Vertex<Recinto> v = grafo.getVertex(pos);
        caminoAct.add(v.getData());
        tiempo -= v.getData().getTiempo();
        if (caminoAct.size() > lista.size() && tiempo >= 0) {
            lista.clear();
            lista.addAll(caminoAct);
        }
        List<Edge<Recinto>> ady = grafo.getEdges(v);
        for (Edge<Recinto> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j] && tiempo > edge.getWeight()) {
                dfs(j, visitados, lista, caminoAct, tiempo - edge.getWeight(), grafo);
            }
        }
        visitados[pos] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {
        Graph<Recinto> grafo = new AdjListGraph<>();

        Vertex<Recinto> entrada = grafo.createVertex(new Recinto("Entrada", 15));
        Vertex<Recinto> flamencos = grafo.createVertex(new Recinto("Flamencos", 10));
        Vertex<Recinto> tigres = grafo.createVertex(new Recinto("Tigres", 10));
        Vertex<Recinto> cebras = grafo.createVertex(new Recinto("Cebras", 10));
        Vertex<Recinto> murcielagos = grafo.createVertex(new Recinto("Murciélagos", 20));
        Vertex<Recinto> wallabies = grafo.createVertex(new Recinto("Wallabies", 30));
        Vertex<Recinto> tortugas = grafo.createVertex(new Recinto("Tortugas", 10));
        Vertex<Recinto> pumas = grafo.createVertex(new Recinto("Pumas", 10));

        // Crear aristas con pesos
        grafo.connect(entrada, flamencos, 25);
        grafo.connect(flamencos, entrada, 25);

        grafo.connect(entrada, tigres, 15);
        grafo.connect(tigres, entrada, 15);

        grafo.connect(entrada, cebras, 10);
        grafo.connect(cebras, entrada, 10);

        grafo.connect(entrada, murcielagos, 20);
        grafo.connect(murcielagos, entrada, 20);

        grafo.connect(flamencos, murcielagos, 25);
        grafo.connect(murcielagos, flamencos, 25);

        grafo.connect(murcielagos, wallabies, 10);
        grafo.connect(wallabies, murcielagos, 10);

        grafo.connect(cebras, tigres, 8);
        grafo.connect(tigres, cebras, 8);

        grafo.connect(cebras, tortugas, 5);
        grafo.connect(tortugas, cebras, 5);

        grafo.connect(tortugas, wallabies, 10);
        grafo.connect(wallabies, tortugas, 10);

        grafo.connect(tortugas, pumas, 15);
        grafo.connect(pumas, tortugas, 15);

        System.out.println(resolver(grafo, 100));

    }
}
