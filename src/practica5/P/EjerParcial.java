package practica5.P;

import java.util.List;

import practica1.P8.Queue;
import practica5.P1.Edge;
import practica5.P1.Graph;
import practica5.P1.Vertex;

/* Un poderoso e inteligente virus de computadora infecta cualquier computadora 
en 1 minuto, logrando infectar toda la red de una empresa con cientos de 
computadoras. Dado un grafo que representa las conexiones entre las 
computadoras de la empresa, y una computadora ya infectada, escriba un 
programa en Java que permita determinar el tiempo que demora el virus en 
infectar el resto de las computadoras. Asuma que todas las computadoras 
pueden ser infectadas, no todas las computadoras tienen conexión directa entre 
sí, y un mismo virus puede infectar un grupo de computadoras al mismo tiempo 
sin importar la cantidad. */

public class EjerParcial {

    public static int calcularTiempoInfeccion(Graph<String> g, Vertex<String> inicial) {
        int tiempo = 0;
        boolean[] visitados = new boolean[g.getSize()];
        Queue<Vertex<String>> cola = new Queue<>();
        visitados[inicial.getPosition()] = true;
        cola.enqueue(inicial);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            Vertex<String> v = cola.dequeue();
            if (v != null) {
                List<Edge<String>> ady = g.getEdges(v);
                for (Edge<String> edge : ady) {
                    Vertex<String> w = edge.getTarget();
                    if (!visitados[w.getPosition()]) {
                        visitados[w.getPosition()] = true;
                        cola.dequeue();
                    }
                }
            } else if (!cola.isEmpty()) {
                tiempo++;
                cola.enqueue(null);
            }
        }
        return tiempo;
    }
}
