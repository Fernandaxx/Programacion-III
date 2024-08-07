package practica5.Parciales;

import java.util.LinkedList;
import java.util.List;

import practica5.P1.AdjListGraph;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

public class Transbordos {

    public static List<Estacion> menosTransbordos(Graph<String> maps, String Origen) {
        Vertex<String> origen = maps.search(Origen);
        boolean[] visitados = new boolean[maps.getSize()];
        List<Estacion> lista = new LinkedList<>();
        Estacion aux = new Estacion(" ", 99999);
        dfs(origen.getPosition(), maps, visitados, lista, aux, 0);
        return lista;
    }

    private static void dfs(int pos, Graph<String> maps, boolean[] visitados,
            List<Estacion> lista, Estacion aux, int trans) {
        visitados[pos] = true;
        Vertex<String> v = maps.getVertex(pos);
        List<Edge<String>> ady = maps.getEdges(v);
        if (ady.size() == 1 && pos != maps.search(maps.getVertex(0).getData()).getPosition()) {
            lista.add(new Estacion(v.getData(), trans));
            System.out.println(trans);
            // aux.setMinTransbordos(9999);
        }
        // if (ady.size() > 2) {
        for (Edge<String> edge : ady) {
            int j = edge.getTarget().getPosition();
            if (!visitados[j]) {
                int newtrans = trans;
                if (ady.size() > 2) {
                    newtrans++;
                }
                dfs(j, maps, visitados, lista, aux, newtrans);
            }
        }
        visitados[pos] = false;

    }

    public static void main(String[] args) {
        Graph<String> graph = new AdjListGraph<>();

        // Componente 1
        Vertex<String> villaLobos = graph.createVertex("Villa Lobos");
        Vertex<String> cUniversitaria = graph.createVertex("C. Universitaria");
        Vertex<String> butanta = graph.createVertex("Butantá");
        Vertex<String> pinheiros = graph.createVertex("Pinheiros");
        Vertex<String> hebraica = graph.createVertex("Hebraica");
        Vertex<String> cidadeJardim = graph.createVertex("Cidade Jardim");
        Vertex<String> vilaOlimpia = graph.createVertex("Vila Olímpia");
        Vertex<String> fariaLima = graph.createVertex("Faria Lima");

        graph.connect(villaLobos, cUniversitaria);
        graph.connect(cUniversitaria, villaLobos);

        graph.connect(cUniversitaria, pinheiros);
        graph.connect(pinheiros, cUniversitaria);

        graph.connect(pinheiros, butanta);
        graph.connect(butanta, pinheiros);

        graph.connect(pinheiros, hebraica);
        graph.connect(hebraica, pinheiros);

        graph.connect(pinheiros, fariaLima);
        graph.connect(fariaLima, pinheiros);

        graph.connect(hebraica, cidadeJardim);
        graph.connect(cidadeJardim, hebraica);

        graph.connect(cidadeJardim, vilaOlimpia);
        graph.connect(vilaOlimpia, cidadeJardim);

        // Componente 2
        Vertex<String> vilaMadalena = graph.createVertex("Vila Madalena");
        Vertex<String> clinicas = graph.createVertex("Clínicas");
        Vertex<String> paulista = graph.createVertex("Paulista");
        Vertex<String> trianon = graph.createVertex("Trianon");
        Vertex<String> brigadeiro = graph.createVertex("Brigadeiro");

        graph.connect(vilaMadalena, clinicas);
        graph.connect(clinicas, vilaMadalena);

        graph.connect(clinicas, paulista);
        graph.connect(paulista, clinicas);

        graph.connect(paulista, fariaLima);
        graph.connect(fariaLima, paulista);

        graph.connect(paulista, trianon);
        graph.connect(trianon, paulista);

        graph.connect(trianon, brigadeiro);
        graph.connect(brigadeiro, trianon);

        // Componente 3
        Vertex<String> armenia = graph.createVertex("Armênia");
        Vertex<String> tiradentes = graph.createVertex("Tiradentes");
        Vertex<String> republica = graph.createVertex("República");
        Vertex<String> luz = graph.createVertex("Luz");
        Vertex<String> paraiso = graph.createVertex("Paraíso");
        Vertex<String> saude = graph.createVertex("Saúde");

        graph.connect(armenia, tiradentes);
        graph.connect(tiradentes, armenia);

        graph.connect(tiradentes, republica);
        graph.connect(republica, tiradentes);

        graph.connect(tiradentes, paulista);
        graph.connect(paulista, tiradentes);

        graph.connect(republica, luz);
        graph.connect(luz, republica);

        graph.connect(republica, paraiso);
        graph.connect(paraiso, republica);

        graph.connect(paraiso, saude);
        graph.connect(saude, paraiso);

        graph.connect(paulista, republica);
        graph.connect(republica, paulista);

        List<Estacion> aux = menosTransbordos(graph, "Butantá");
        for (int i = 0; i < aux.size(); i++) {
            System.out.println(aux.get(i).toString());
        }
    }
}
