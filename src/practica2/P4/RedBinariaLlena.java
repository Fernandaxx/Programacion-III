package practica2.P4;

import practica2.P1.BinaryTree;

/*Los nodos que conforman una red binaria llena tiene la particularidad de que todos ellos conocen
 cuál es su retardo de reenvío. El retardo de reenvío se define como el período comprendido entre
 que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
 Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz
 hasta llegar a las hojas en una red binaria llena. En el ejemplo, debería retornar 10+3+9+12=34
 (Si hay más de un máximo retorne el último valor hallado).
 Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de
 segundos.
 a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el
 problema.
 b) Cree una clase Java llamada RedBinariaLlena donde implementará lo solicitado en el
 método retardoReenvio():int */
public class RedBinariaLlena {
    private BinaryTree<Integer> arbol;

    public RedBinariaLlena() {

    }

    public RedBinariaLlena(BinaryTree<Integer> ab) {
        this.arbol = ab;
    }

    public BinaryTree<Integer> getData() {
        return this.arbol;
    }

    public int retardoReenvio() {
        int max = -1;
        if (this.arbol != null && !this.arbol.isEmpty())
            max = retardoRenvio_priv(this.getData());
        return max;

    }

    private int retardoRenvio_priv(BinaryTree<Integer> ab) {
        int suma1 = ab.getData();
        int suma2 = ab.getData();
        if (ab.hasLeftChild())
            suma1 += retardoRenvio_priv(ab.getLeftChild());
        if (ab.hasRightChild())
            suma2 += retardoRenvio_priv(ab.getRightChild());
        if (suma1 > suma2)
            return suma1;
        else
            return suma2;
    }

}
