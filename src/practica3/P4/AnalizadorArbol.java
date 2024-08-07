/*  Se debe devolver el mayor promedio entre todos los valores promedios de los niveles.
 Para el ejemplo presentado, el promedio del nivel 0 es 14, el del nivel 1 es 16 y el del nivel 2 es 10. Por
 lo tanto, debe devolver 16.
 a) Indique y justifique qué tipo de recorrido utilizará para resolver el problema.
 b) Implementar en una clase AnalizadorArbol, el método con la siguiente firma:
 public int devolverMaximoPromedio (GeneralTree<Integer>arbol)
 Donde Integer es una clase que representa a un área de la empresa mencionada y que contiene
 la identificación de la misma representada con un String y una tardanza de transmisión de mensajes
 interna representada con int */
package practica3.P4;

import practica3.P1.GeneralTree;
import practica1.P8.Queue;

public class AnalizadorArbol {

    public int devolverMaximoPromedio(GeneralTree<Integer> arbol) {
        int maxPromedio = 0, cant = 0, promedioAct = 0;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(arbol);
        cola.enqueue(null);

        GeneralTree<Integer> treeAux;

        while (!cola.isEmpty()) {
            treeAux = cola.dequeue();
            if (treeAux != null) {
                cant++;
                promedioAct += treeAux.getData(); // .getTardanza();
                if (treeAux.hasChildren()) {
                    for (GeneralTree<Integer> i : treeAux.getChildren()) {
                        cola.enqueue(i);
                    }
                }
            } else if (!cola.isEmpty()) {
                promedioAct /= cant;
                if (promedioAct > maxPromedio)
                    maxPromedio = promedioAct;
                cant = 0;
                promedioAct = 0;
                cola.enqueue(null);
            }
        }
        return maxPromedio;
    }

}
