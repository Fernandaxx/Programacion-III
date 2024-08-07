/*
 * package tp5.ejercicio1;
 * 
 * import java.util.LinkedList;
 * import java.util.List;
 * 
 * import tp5.ejercicio1.listaAdy.AdjListGraph;
 * 
 * public class parcialTransbordos {
 * public static void main(String[] args) {
 * Graph<String> graph = new AdjListGraph<>();
 * 
 * // Componente 1
 * Vertex<String> villaLobos = graph.createVertex("Villa Lobos");
 * Vertex<String> cUniversitaria = graph.createVertex("C. Universitaria");
 * Vertex<String> butanta = graph.createVertex("Butantá");
 * Vertex<String> pinheiros = graph.createVertex("Pinheiros");
 * Vertex<String> hebraica = graph.createVertex("Hebraica");
 * Vertex<String> cidadeJardim = graph.createVertex("Cidade Jardim");
 * Vertex<String> vilaOlimpia = graph.createVertex("Vila Olímpia");
 * Vertex<String> fariaLima = graph.createVertex("Faria Lima");
 * 
 * graph.connect(villaLobos, cUniversitaria);
 * graph.connect(cUniversitaria, villaLobos);
 * 
 * graph.connect(cUniversitaria, pinheiros);
 * graph.connect(pinheiros, cUniversitaria);
 * 
 * graph.connect(pinheiros, butanta);
 * graph.connect(butanta, pinheiros);
 * 
 * graph.connect(pinheiros, hebraica);
 * graph.connect(hebraica, pinheiros);
 * 
 * graph.connect(pinheiros, fariaLima);
 * graph.connect(fariaLima, pinheiros);
 * 
 * graph.connect(hebraica, cidadeJardim);
 * graph.connect(cidadeJardim, hebraica);
 * 
 * graph.connect(cidadeJardim, vilaOlimpia);
 * graph.connect(vilaOlimpia, cidadeJardim);
 * 
 * // Componente 2
 * Vertex<String> vilaMadalena = graph.createVertex("Vila Madalena");
 * Vertex<String> clinicas = graph.createVertex("Clínicas");
 * Vertex<String> paulista = graph.createVertex("Paulista");
 * Vertex<String> trianon = graph.createVertex("Trianon");
 * Vertex<String> brigadeiro = graph.createVertex("Brigadeiro");
 * 
 * graph.connect(vilaMadalena, clinicas);
 * graph.connect(clinicas, vilaMadalena);
 * 
 * graph.connect(clinicas, paulista);
 * graph.connect(paulista, clinicas);
 * 
 * graph.connect(paulista, fariaLima);
 * graph.connect(fariaLima, paulista);
 * 
 * graph.connect(paulista, trianon);
 * graph.connect(trianon, paulista);
 * 
 * graph.connect(trianon, brigadeiro);
 * graph.connect(brigadeiro, trianon);
 * 
 * // Componente 3
 * Vertex<String> armenia = graph.createVertex("Armênia");
 * Vertex<String> tiradentes = graph.createVertex("Tiradentes");
 * Vertex<String> republica = graph.createVertex("República");
 * Vertex<String> luz = graph.createVertex("Luz");
 * Vertex<String> paraiso = graph.createVertex("Paraíso");
 * Vertex<String> saude = graph.createVertex("Saúde");
 * 
 * graph.connect(armenia, tiradentes);
 * graph.connect(tiradentes, armenia);
 * 
 * graph.connect(tiradentes, republica);
 * graph.connect(republica, tiradentes);
 * 
 * graph.connect(tiradentes, paulista);
 * graph.connect(paulista, tiradentes);
 * 
 * graph.connect(republica, luz);
 * graph.connect(luz, republica);
 * 
 * graph.connect(republica, paraiso);
 * graph.connect(paraiso, republica);
 * 
 * graph.connect(paraiso, saude);
 * graph.connect(saude, paraiso);
 * 
 * graph.connect(paulista, republica);
 * graph.connect(republica, paulista);
 * 
 * List<transbordos> aux = menosTransbordos(graph, "Butantá");
 * for (int i = 0; i < aux.size(); i++) {
 * System.out.println(aux.get(i).toString());
 * }
 * }
 * 
 * public static List<transbordos> menosTransbordos(Graph<String> maps, String
 * origen) {
 * List<transbordos> lista = new LinkedList<>();
 * transbordos camino = new transbordos(0, "");
 * boolean[] visitados = new boolean[maps.getSize()];
 * Vertex<String> or = maps.search(origen);
 * if (or != null) {
 * dfs(or.getPosition(), maps, lista, visitados, camino);
 * }
 * return lista;
 * }
 * 
 * private static void dfs(int actual, Graph<String> grafo, List<transbordos>
 * lista, boolean[] visitados,
 * transbordos camino) {
 * visitados[actual] = true;
 * Vertex<String> v = grafo.getVertex(actual);
 * camino.setEstacion(v.getData());
 * List<Edge<String>> ady = grafo.getEdges(v);
 * if (ady.size() == 1) {
 * boolean cambio = false;
 * for (transbordos t : lista) {
 * if (t.getEstacion().equals(v.getData())) {
 * cambio = true;
 * if (t.getCantTransbordos() > camino.getCantTransbordos()) {
 * t.setCantTransbordos(camino.getCantTransbordos());
 * }
 * }
 * }
 * if (!cambio) {
 * lista.addLast(new transbordos(camino.getCantTransbordos(),
 * camino.getEstacion()));
 * 
 * }
 * }
 * if (ady.size() > 2) {
 * camino.setCantTransbordos(camino.getCantTransbordos() + 1);
 * }
 * for (Edge<String> edge : ady) {
 * int j = edge.getTarget().getPosition();
 * if (!visitados[j]) {
 * dfs(j, grafo, lista, visitados, camino);
 * }
 * }
 * visitados[actual] = false;
 * if (ady.size() > 2) {
 * camino.setCantTransbordos(camino.getCantTransbordos() - 1);
 * }
 * }
 * }
 */