package practica5.P4;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class test {
    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        // Crear los vértices
        Vertex<String> ayuntamiento = graph.createVertex("Ayuntamiento");
        Vertex<String> museoMunch = graph.createVertex("Museo Munch");
        Vertex<String> elTigre = graph.createVertex("El Tigre");
        Vertex<String> laOpera = graph.createVertex("La Opera");
        Vertex<String> fortalezaAkershus = graph.createVertex("Fortaleza Akershus");
        Vertex<String> parqueBotanico = graph.createVertex("Parque Botánico");
        Vertex<String> galeriaNacional = graph.createVertex("Galería Nacional");
        Vertex<String> palacioReal = graph.createVertex("Palacio Real");
        Vertex<String> akkerBrigge = graph.createVertex("Akker Brigge");
        Vertex<String> parqueVigeland = graph.createVertex("Parque Vigeland");
        Vertex<String> holmenkollen = graph.createVertex("Holmenkollen");
        Vertex<String> folkMuseum = graph.createVertex("FolkMuseum");
        Vertex<String> museoFram = graph.createVertex("Museo Fram");
        Vertex<String> museoVikingo = graph.createVertex("Museo Vikingo");
        Vertex<String> museoBarcoPolar = graph.createVertex("Museo del Barco Polar");

        // Conectar los vértices con sus respectivos pesos
        graph.connect(ayuntamiento, elTigre, 15);
        graph.connect(elTigre, ayuntamiento, 15);

        graph.connect(museoMunch, elTigre, 15);
        graph.connect(elTigre, museoMunch, 15);

        graph.connect(parqueBotanico, galeriaNacional, 15);
        graph.connect(galeriaNacional, parqueBotanico, 15);

        graph.connect(galeriaNacional, parqueVigeland, 10);
        graph.connect(parqueVigeland, galeriaNacional, 10);

        graph.connect(folkMuseum, parqueVigeland, 20);
        graph.connect(parqueVigeland, folkMuseum, 20);

        graph.connect(folkMuseum, museoFram, 5);
        graph.connect(museoFram, folkMuseum, 5);

        graph.connect(museoFram, museoBarcoPolar, 5);
        graph.connect(museoBarcoPolar, museoFram, 5);

        graph.connect(museoBarcoPolar, museoVikingo, 5);
        graph.connect(museoVikingo, museoBarcoPolar, 5);

        graph.connect(laOpera, fortalezaAkershus, 10);
        graph.connect(fortalezaAkershus, laOpera, 10);

        graph.connect(ayuntamiento, parqueBotanico, 10);
        graph.connect(parqueBotanico, ayuntamiento, 10);

        graph.connect(parqueBotanico, museoMunch, 1);
        graph.connect(museoMunch, parqueBotanico, 1);

        graph.connect(parqueVigeland, holmenkollen, 30);
        graph.connect(holmenkollen, parqueVigeland, 30);

        graph.connect(galeriaNacional, parqueVigeland, 10);
        graph.connect(parqueVigeland, galeriaNacional, 10);

        graph.connect(akkerBrigge, museoVikingo, 30);
        graph.connect(museoVikingo, akkerBrigge, 30);

        graph.connect(ayuntamiento, akkerBrigge, 20);
        graph.connect(akkerBrigge, ayuntamiento, 20);

        graph.connect(ayuntamiento, palacioReal, 5);
        graph.connect(palacioReal, ayuntamiento, 5);

        graph.connect(palacioReal, folkMuseum, 5);
        graph.connect(folkMuseum, palacioReal, 5);

        // Grafo creado según el diagrama

        List<String> lista = new LinkedList<>();
        lista.add("Akker Brigge");
        lista.add("Palacio Real");
        VisitaOslo v = new VisitaOslo();
        Integer tiempo = 0;
        List<String> list = v.paseoEnBici(graph, "Museo Vikingo", 120, lista, tiempo);
        System.out.println(list);
        System.out.println(tiempo);
    }
}
