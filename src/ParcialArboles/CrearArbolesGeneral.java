package ParcialArboles;

import java.util.LinkedList;
import java.util.List;

import practica1.P8.Queue;
import practica3.P1.GeneralTree;

public class CrearArbolesGeneral {

    public static void printPreOrden(GeneralTree<Integer> ag) {
        System.out.println(ag.getData());
        List<GeneralTree<Integer>> children = ag.getChildren();
        for (GeneralTree<Integer> child : children) {
            printPreOrden(child);
        }
    }

    public static void printPostOrden(GeneralTree<Integer> ag) {
        List<GeneralTree<Integer>> children = ag.getChildren();

        for (GeneralTree<Integer> child : children) {
            printPostOrden(child);
        }
        System.out.println(ag.getData());
    }

    public static void printInOrden(GeneralTree<Integer> ag) {
        if (ag.hasChildren()) {
            printInOrden(ag.getChildren().get(0));
        }
        System.out.println(ag.getData());

        List<GeneralTree<Integer>> children = ag.getChildren();
        for (int i = 1; i < children.size(); i++) {
            printInOrden(children.get(i));
        }
    }

    public static void printNivel(GeneralTree<Integer> ag) {
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        cola.enqueue(ag);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                System.out.println(aux.getData() + "-");
                List<GeneralTree<Integer>> children = aux.getChildren();
                for (GeneralTree<Integer> child : children) {
                    cola.enqueue(child);
                }

            } else if (!cola.isEmpty()) {
                System.out.println();
                cola.enqueue(null);
            }
        }
    }

    public static GeneralTree<Integer> crearAG() {

        List<GeneralTree<Integer>> hijosH1 = new LinkedList<>();
        hijosH1.add(new GeneralTree<Integer>(18));
        hijosH1.add(new GeneralTree<Integer>(20));
        GeneralTree<Integer> H1 = new GeneralTree<Integer>(8, hijosH1);
        /*
         * List<GeneralTree<Integer>> hijosH2 = new LinkedList<>();
         * hijosH2.add(new GeneralTree<Integer>(21));
         * hijosH2.add(new GeneralTree<Integer>(22));
         * hijosH2.add(new GeneralTree<Integer>(23));
         */
        GeneralTree<Integer> H2 = new GeneralTree<Integer>(3);

        List<GeneralTree<Integer>> hijosH3 = new LinkedList<>();
        hijosH3.add(new GeneralTree<Integer>(14));
        // hijosH3.add(new GeneralTree<Integer>(32));

        GeneralTree<Integer> H3 = new GeneralTree<Integer>(6, hijosH3);

        List<GeneralTree<Integer>> hijos = new LinkedList<>();
        hijos.add(H1);
        hijos.add(H2);
        hijos.add(H3);

        GeneralTree<Integer> raiz = new GeneralTree<Integer>(2, hijos);

        return raiz;

    }

    public static void buscar(GeneralTree<Integer> ag, int n) {
        if (ag.getData() == n) {
            System.out.println("Encontre el dato");
        }
        if (ag.hasChildren()) {
            for (GeneralTree<Integer> child : ag.getChildren()) {
                buscar(child, n);
            }
        }
    }

    public static int sumarnodos(GeneralTree<Integer> ag) {
        int suma = 0;
        if (ag.hasChildren()) {
            List<GeneralTree<Integer>> children = ag.getChildren();
            for (GeneralTree<Integer> child : children) {
                suma += sumarnodos(child);
            }
        }

        return suma += ag.getData();
    }

    public static int cantNodos(GeneralTree<Integer> ag) {
        int suma = 0;
        if (ag.hasChildren()) {
            List<GeneralTree<Integer>> children = ag.getChildren();
            for (GeneralTree<Integer> child : children) {
                suma += cantNodos(child);
            }
        }
        suma++;
        return suma;
    }

    /*
     * Dado un árbol implementar un
     * método que reciba un nivel y retorne una lista con los valores encontradas
     * en ese nivel.
     */

    public static List<Integer> valorPorNivel(GeneralTree<Integer> ag, int nivelPedido) {
        List<Integer> result = new LinkedList<>();
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux;
        cola.enqueue(ag);
        cola.enqueue(null);
        int nivel = 0;

        while (!cola.isEmpty() && nivel <= nivelPedido) {
            aux = cola.dequeue();
            if (aux != null) {
                if (nivel == nivelPedido)
                    result.add(aux.getData());
                if (aux.hasChildren() && nivel < nivelPedido) {
                    List<GeneralTree<Integer>> children = aux.getChildren();
                    for (GeneralTree<Integer> child : children) {
                        cola.enqueue(child);
                    }
                }
            } else {
                if (!cola.isEmpty()) {
                    nivel++;
                    cola.enqueue(null);
                }
            }
        }
        return result;
    }
    /*
     * Un árbol general es de selección si cada nodo tiene en su raíz el valor del
     * menor de sus hijos
     */

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        boolean result = true;
        if (arbol.hasChildren()) {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children) {
                result = esDeSeleccion(child);
            }
        }
        if (arbol.hasChildren() && result) {
            for (GeneralTree<Integer> child : arbol.getChildren()) {
                if (child.getData() < arbol.getData()) {
                    result = false;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GeneralTree<Integer> ag = crearAG();
        /*
         * System.out.println("PreOrden");
         * printPreOrden(ag);
         * System.out.println("PostOrden");
         * printPostOrden(ag);
         * System.out.println("EnOrden");
         * printInOrden(ag);
         * System.out.println("PorNivel");
         */
        printNivel(ag);
        parcial7 p = new parcial7();
        List<Integer> l = p.resolver(ag);
        System.out.println(l);

        // buscar(ag, 2);

        /*
         * System.out.println("suma de los nodos  " + sumarnodos(ag) +
         * " altura del arbol " + ag.altura() + "ancho del arbol" +
         * ag.ancho() + " nivel de 21 " + ag.nivel(21));
         * 
         * System.out.println("Cantidan de nodos: " + cantNodos(ag));
         */

        /*
         * List<Integer> lista = valorPorNivel(ag, 2);
         * System.out.println(lista);
         * 
         * System.out.println(esDeSeleccion(ag));
         */
    }
}
