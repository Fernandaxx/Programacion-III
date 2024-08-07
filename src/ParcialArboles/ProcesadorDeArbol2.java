package ParcialArboles;

import practica2.P1.BinaryTree;

public class ProcesadorDeArbol2 {
    private BinaryTree<Character> arbol;

    public ProcesadorDeArbol2() {
    }

    public ProcesadorDeArbol2(BinaryTree<Character> arbol) {
        this.arbol = arbol;
    }

    public int procesar(int k) {
        int cant_caminos = 0;
        if (this.arbol != null && !this.arbol.isEmpty()) {
            cant_caminos = procesar_rec(arbol, k, 0);
        }
        return cant_caminos;
    }

    private int procesar_rec(BinaryTree<Character> ab, int k, int cant) {
        int caminos = 0;
        if ((ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild())) {
            cant++;
        }
        if ((cant == k) && (ab.isLeaf()))
            caminos++;

        if (ab.hasLeftChild()) {

            caminos += procesar_rec(ab.getLeftChild(), k, cant);
        }

        if (ab.hasRightChild()) {

            caminos += procesar_rec(ab.getRightChild(), k, cant);
        }

        return caminos;
    }
}
