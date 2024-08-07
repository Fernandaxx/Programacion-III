package practica5.P6;

import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class test {
    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        Vertex<String> casaCaperucita = graph.createVertex("Casa Caperucita");
        Vertex<String> claro1 = graph.createVertex("Claro 1");
        Vertex<String> claro2 = graph.createVertex("Claro 2");
        Vertex<String> claro3 = graph.createVertex("Claro 3");
        Vertex<String> claro4 = graph.createVertex("Claro 4");
        Vertex<String> claro5 = graph.createVertex("Claro 5");
        Vertex<String> casaAbuelita = graph.createVertex("Casa Abuelita");

        // Conectar los vértices con sus respectivos pesos en ambas direcciones
        graph.connect(casaCaperucita, claro3, 4);
        graph.connect(claro3, casaCaperucita, 4);

        graph.connect(casaCaperucita, claro1, 3);
        graph.connect(claro1, casaCaperucita, 3);

        graph.connect(casaCaperucita, claro2, 4);
        graph.connect(claro2, casaCaperucita, 4);

        graph.connect(claro3, claro5, 15);
        graph.connect(claro5, claro3, 15);

        graph.connect(claro1, claro5, 3);
        graph.connect(claro5, claro1, 3);

        graph.connect(claro1, claro2, 4);
        graph.connect(claro2, claro1, 4);

        graph.connect(claro2, claro4, 10);
        graph.connect(claro4, claro2, 10);

        graph.connect(claro2, claro5, 11);
        graph.connect(claro5, claro2, 11);

        graph.connect(claro5, casaAbuelita, 4);
        graph.connect(casaAbuelita, claro5, 4);

        graph.connect(claro4, casaAbuelita, 9);
        graph.connect(casaAbuelita, claro4, 9);

        Caperucita c = new Caperucita(graph);
        List<List<String>> caminos = c.recorridosMasSeguro();
        System.out.println(caminos);
        // for (List<String> cam : caminos) {
        // System.out.println(cam);
        // }
    }
}
