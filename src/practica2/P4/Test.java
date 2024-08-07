package practica2.P4;

import practica2.P1.BinaryTree;

public class Test {

    public static void añadirDato(BinaryTree<Integer> arbol, int n) {
        if (arbol.isEmpty())
            arbol.setData(n);
        else if (arbol.getData() < n) {
            if (!arbol.hasRightChild())
                arbol.addRightChild(new BinaryTree<Integer>());
            añadirDato(arbol.getRightChild(), n);
        } else if (arbol.getData() > n) {
            if (!arbol.hasLeftChild())
                arbol.addLeftChild(new BinaryTree<Integer>());
            añadirDato(arbol.getLeftChild(), n);
        }
    }

    public static BinaryTree<Integer> crearArbolInteger() {
        int aux = (int) (Math.random() * 50);
        BinaryTree<Integer> ab = new BinaryTree<>(aux);

        for (int i = 0; i < 20; i++) {
            añadirDato(ab, aux);
            aux = (int) (Math.random() * 100);
        }
        return ab;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = crearArbolInteger();
        RedBinariaLlena red = new RedBinariaLlena(ab);

        ab.entreNiveles(0, 50);

        System.out.println("\n\n\n" + red.retardoReenvio());

    }

}
