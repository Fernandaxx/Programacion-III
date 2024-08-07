package practica2.P1;

public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> Arbol = new BinaryTree<Integer>(1);
        Arbol.addLeftChild(new BinaryTree<>(2));
        Arbol.getLeftChild().addLeftChild(new BinaryTree<>(3));
        Arbol.getLeftChild().addRightChild(new BinaryTree<>(4));

        Arbol.addRightChild(new BinaryTree<>(5));
        Arbol.getRightChild().addRightChild(new BinaryTree<>(7));
        Arbol.getRightChild().addLeftChild(new BinaryTree<>(6));

        Arbol.entreNiveles(0, 2);
        System.out.println("Hojas: " + Arbol.contarHojas());
    }
}
