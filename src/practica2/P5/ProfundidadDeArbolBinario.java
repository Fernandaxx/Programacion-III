package practica2.P5;

import practica1.P8.Queue;
import practica2.P1.BinaryTree;

public class ProfundidadDeArbolBinario {
    private BinaryTree<Integer> ab;

    public ProfundidadDeArbolBinario() {
    }

    public ProfundidadDeArbolBinario(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    /*
     * public int sumaElementosProfundidad(int p) {
     * Queue<BinaryTree<Integer>> cola = new Queue<>();
     * cola.enqueue(this.ab);// raiz
     * cola.enqueue(null);
     * int suma = 0;
     * while (!cola.isEmpty() && p >= 0) {
     * ab = cola.dequeue();
     * if (ab != null) {
     * suma += ab.getData();
     * if (ab.hasLeftChild())
     * cola.enqueue(ab.getLeftChild());
     * if (ab.hasRightChild())
     * cola.enqueue(ab.getRightChild());
     * } else if (!cola.isEmpty()) {
     * cola.enqueue(null);
     * p--;
     * }
     * }
     * return suma;
     * }
     */

    public int sumaElementosProfundidad(int p) {
        int nivel = 0;
        int suma = 0;
        Queue<BinaryTree<Integer>> cola = new Queue<>();
        BinaryTree<Integer> nodoAct = null;
        cola.enqueue(this.ab);// raiz
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            nodoAct = cola.dequeue();
            if (nodoAct != null) {
                if (nivel == p) {
                    suma += nodoAct.getData();
                }
                if (nodoAct.hasLeftChild())
                    cola.enqueue(nodoAct.getLeftChild());
                if (nodoAct.hasRightChild())
                    cola.enqueue(nodoAct.getRightChild());
            } else if (!cola.isEmpty()) {
                cola.enqueue(null);
                nivel++;
            }
        }
        return suma;
    }

}
