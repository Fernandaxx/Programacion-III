package practica2.P6;

import practica2.P1.BinaryTree;

/* Cree una clase Java llamada Transformacion que tenga como variable de instancia un árbol
 binario de números enteros y un método de instancia suma (): BinaryTree<Integer> el cuál
 devuelve el árbol en el que se reemplazó el valor de cada nodo por la suma de todos los
 elementos presentes en su subárbol izquierdo y derecho. Asuma que los valores de los subárboles
 vacíos son ceros. Por ejemplo ¿Su solución recorre una única vez cada subárbol? En el caso que no, ¿Puede mejorarla para que
 sí lo haga?*/

public class Transformacion {
    private BinaryTree<Integer> ab;

    public Transformacion(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    public Transformacion() {
    }

    public BinaryTree<Integer> getData() {
        return ab;
    }

    public void setData(BinaryTree<Integer> treeNode) {
        this.ab = treeNode;
    }

    public BinaryTree<Integer> suma() {
        if (this.ab != null) {
            if (!this.ab.isLeaf()) {
                int izq = 0, der = 0;
                if (this.ab.hasLeftChild())
                    izq = sumaAux(this.ab.getLeftChild()); // HELPER
                if (this.ab.hasRightChild())
                    der = sumaAux(this.ab.getRightChild()); // HELPER
                this.ab.setData(izq + der);
            } else
                this.ab.setData(0);
        }

        return this.ab;

    }

    private int sumaAux(BinaryTree<Integer> arbol) {
        int sum = 0;
        if (arbol.hasLeftChild())
            sum += sumaAux(arbol.getLeftChild());
        if (arbol.hasRightChild())
            sum += sumaAux(arbol.getRightChild());
        arbol.setData(sum);
        return (sum + arbol.getData());
    }
}
