
package ParcialArboles;

import java.util.*;

import practica2.P1.BinaryTree;

public class Parcial4 {

    public List<Integer> resolver(BinaryTree<Integer> arbol) {
        List<Integer> l = new LinkedList<Integer>();
        if ((arbol != null) && (!arbol.isEmpty()))
            resolver_rec(arbol, l);
        return l;

    }

    private int resolver_rec(BinaryTree<Integer> a, List<Integer> l) {
        int cant = 0;
        int cantizq = 0;
        int cantder = 0;

        if (a.isLeaf())
            l.addLast(a.getData());
        else {
            if (a.hasLeftChild()) {
                cantizq += resolver_rec(a.getLeftChild(), l);
                cant += cantizq;
            }
            if (a.hasRightChild()) {
                cantder += resolver_rec(a.getRightChild(), l);
                cant += cantder;
            }
            if (cantder == cantizq)
                l.addLast(a.getData());
        }
        return cant + 1;
    }

}
