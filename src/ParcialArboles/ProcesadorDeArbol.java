package ParcialArboles;

import practica2.P1.BinaryTree;

public class ProcesadorDeArbol {
    private BinaryTree<Integer> arbol;

    public BinaryTree<Integer> getDato() {
        return arbol;
    }

    public Result procesar() {
        Result resultado = new Result();
        if ((this.getDato() != null) && (!this.getDato().isEmpty())) {
            procesar_postOrden(this.getDato(), resultado);
        }
        return resultado;
    }

    public ProcesadorDeArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    private void procesar_postOrden(BinaryTree<Integer> ab, Result r) {
        if (ab != null) {
            if (ab.hasLeftChild())
                procesar_postOrden(ab.getLeftChild(), r);
            if (ab.hasRightChild())
                procesar_postOrden(ab.getRightChild(), r);
            if (ab.getData() % 2 == 1) {
                r.incrementarCant();
                if (ab.hasLeftChild() && !ab.hasRightChild())
                    r.agregarDato(ab.getData());
                if (!ab.hasLeftChild() && ab.hasRightChild())
                    r.agregarDato(ab.getData());
            }
        }
    }
}
