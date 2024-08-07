
package practica2.P3;

import java.util.*;

import practica2.P1.BinaryTree;

public class ContadorArbol {
    private BinaryTree<Integer> arbol;

    public ContadorArbol() {

    }

    public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public BinaryTree<Integer> getData() {
        return this.arbol;
    }

    public void setarbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> numerosParesInOrden() {
        List<Integer> lista = new LinkedList<>();
        numerosParesInOrden_priv(this.getData(), lista);
        return lista;
    }

    private void numerosParesInOrden_priv(BinaryTree<Integer> arbol, List<Integer> lista) {
        if (arbol != null) {
            if (arbol.hasLeftChild())
                numerosParesInOrden_priv(arbol.getLeftChild(), lista);
            if (arbol.getData() % 2 == 0)
                lista.add(arbol.getData());
            if (arbol.hasRightChild())
                numerosParesInOrden_priv(arbol.getRightChild(), lista);
        }
    }

    /*
     * private void numerosParesAux1(BinaryTree<Integer> ab, List<Integer> numeros)
     * {
     * if (ab.hasLeftChild()) {
     * numerosParesAux1(ab.getLeftChild(), numeros);
     * if (ab.getarbol() % 2 == 0) {
     * numeros.add(ab.getarbol());
     * }
     * if (ab.hasRightChild())
     * numerosParesAux1(ab.getRightChild(), numeros);
     * }
     * }
     * 
     * public List<Integer> numerosParesInOrden() {
     * List<Integer> numeros = new LinkedList<Integer>();
     * if ((this.getarbol() != null) && !(this.getarbol().isEmpty()))
     * numerosParesAux1(this.getarbol(), numeros);
     * return numeros;
     * }
     * 
     * private void numerosParesAux2(BinaryTree<Integer> ab, List<Integer> numeros)
     * {
     * if (ab.hasLeftChild())
     * numerosParesAux2(ab.getLeftChild(), numeros);
     * if (ab.hasRightChild())
     * numerosParesAux2(ab.getRightChild(), numeros);
     * 
     * if (ab.getarbol() % 2 == 0) {
     * numeros.add(ab.getarbol());
     * }
     * }
     * 
     * public List<Integer> numerosParesPostOrden() {
     * List<Integer> numeros = new ArrayList<>();
     * if ((this.getarbol() != null) && !(this.getarbol().isEmpty()))
     * numerosParesAux2(this.getarbol(), numeros);
     * return numeros;
     * }
     */

}
