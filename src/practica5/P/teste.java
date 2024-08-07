package practica5.P;

import practica5.P1.AdjListGraph;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class teste {

    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        Vertex<String> suipacha = graph.createVertex("Suipacha");
        Vertex<String> navarro = graph.createVertex("Navarro");
        Vertex<String> saladillo = graph.createVertex("Saladillo");
        Vertex<String> lobos = graph.createVertex("Lobos");
        Vertex<String> canuelas = graph.createVertex("Cañuelas");
        Vertex<String> carlosKeen = graph.createVertex("Carlos Keen");
        Vertex<String> moreno = graph.createVertex("Moreno");
        Vertex<String> abasto = graph.createVertex("Abasto");
        Vertex<String> quilmes = graph.createVertex("Quilmes");
        Vertex<String> laPlata = graph.createVertex("La Plata");
        Vertex<String> pinamar = graph.createVertex("Pinamar");

        graph.connect(navarro, suipacha, 50);
        graph.connect(suipacha, navarro, 50);

        graph.connect(navarro, saladillo, 25);
        graph.connect(saladillo, navarro, 25);

        graph.connect(navarro, lobos, 110);
        graph.connect(lobos, navarro, 110);

        graph.connect(navarro, canuelas, 200);
        graph.connect(canuelas, navarro, 200);

        graph.connect(suipacha, carlosKeen, 100);
        graph.connect(carlosKeen, suipacha, 100);

        graph.connect(carlosKeen, moreno, 100);
        graph.connect(moreno, carlosKeen, 100);

        graph.connect(moreno, abasto, 100);
        graph.connect(abasto, moreno, 100);

        graph.connect(moreno, quilmes, 100);
        graph.connect(quilmes, moreno, 100);

        graph.connect(abasto, canuelas, 100);
        graph.connect(canuelas, abasto, 100);

        graph.connect(abasto, laPlata, 100);
        graph.connect(laPlata, abasto, 100);

        graph.connect(laPlata, quilmes, 50);
        graph.connect(quilmes, laPlata, 50);

        graph.connect(laPlata, pinamar, 300);
        graph.connect(pinamar, laPlata, 300);
        Parcial3 p = new Parcial3();
        Retorno r = p.resolver(graph, "La Plata", 500);
        System.out.println(r);
    }
}