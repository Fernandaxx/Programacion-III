package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Temaiken {

    public static int resolver(Graph<Recinto> sitios, int tiempo) {
        boolean[] visitados = new boolean[sitios.getSize()];
        List<String> listaRecintos = new LinkedList<>();
        Recinto r = new Recinto("Entrada", 15);
        Vertex<Recinto> entrada = sitios.search(r);
        int maxRecintos = 0;
        if (entrada != null) {
            maxRecintos = dfs(entrada.getPosition(), sitios, tiempo, 0, 0, visitados, listaRecintos);
        }
        return maxRecintos;
    }

    private static int dfs(int pos, Graph<Recinto> sitios, int tiempo, int cantRecintos, int maxRecintos,
            boolean[] visitados, List<String> lista) {
        visitados[pos] = true;
        Vertex<Recinto> v = sitios.getVertex(pos);
        tiempo -= v.getData().getTiempo();
        lista.add(v.getData().getNombre());
        cantRecintos += 1;
        if (cantRecintos > maxRecintos) {
            maxRecintos = cantRecintos;
        }
        System.out.println("Entrada: " + v.getData().getNombre() + " tiempo disp " + tiempo + "");
        System.out.println(lista);
        System.out.println();
        List<Edge<Recinto>> ady = sitios.getEdges(v);
        for (Edge<Recinto> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j] && tiempo > edge.getWeight() + edge.getTarget().getData().getTiempo()) {
                maxRecintos = dfs(j, sitios, tiempo - edge.getWeight(), cantRecintos, maxRecintos, visitados, lista);
            }
        }
        // System.out.println(v.getData().getNombre() + " tiempo disp " + tiempo +
        // "\n");
        System.out.println("Salida:" + v.getData().getNombre() + " \n");
        visitados[pos] = false;
        lista.remove(lista.size() - 1);

        return maxRecintos;

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

        grafo.connect(tortugas, wallabies, 1000);
        grafo.connect(wallabies, tortugas, 1000);

        grafo.connect(tortugas, pumas, 15);
        grafo.connect(pumas, tortugas, 15);

        System.out.println(resolver(grafo, 100));

    }
}
