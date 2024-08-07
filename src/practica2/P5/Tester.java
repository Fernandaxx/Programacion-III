/* package practica2.P5;

import practica2.P1.BinaryTree;

public class TestProfundidad {
    /*
     * public static void añadirDato(BinaryTree<Integer> arbol, int n) {
     * if (arbol.isEmpty())
     * arbol.setData(n);
     * else if (arbol.getData() < n) {
     * if (!arbol.hasRightChild())
     * arbol.addRightChild(new BinaryTree<Integer>());
     * añadirDato(arbol.getRightChild(), n);
     * } else if (arbol.getData() > n) {
     * if (!arbol.hasLeftChild())
     * arbol.addLeftChild(new BinaryTree<Integer>());
     * añadirDato(arbol.getLeftChild(), n);
     * }
     * }
     * 
     * public static BinaryTree<Integer> crearArbolInteger() {
     * int aux = 1;
     * BinaryTree<Integer> ab = new BinaryTree<>(aux);
     * 
     * for (int i = 0; i < 20; i++) {
     * añadirDato(ab, aux);
     * aux *= 2;
     * }
     * return ab;
     * }
     

    public static BinaryTree<Integer> crear() {
        BinaryTree<Integer> ab = new BinaryTree<>(10);
        ab.addLeftChild(new BinaryTree<Integer>(20));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(40));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(60));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(90));
        return ab;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = crear();
        ProfundidadDeArbolBinario p = new ProfundidadDeArbolBinario(ab);

        ab.entreNiveles(0, 50);
        System.out.println("\n\n\n" + p.sumaElementosProfundidad(2));

    }

}
 */
package practica2.P5;

import practica2.P1.BinaryTree;

public class Tester {

    public static void main(String[] args) {
        // Create some test binary trees
        BinaryTree<Integer> tree1 = createBinaryTree1();
        BinaryTree<Integer> tree2 = createBinaryTree2();
        tree1.entreNiveles(0, 10);
        System.out.println("\n\n");
        tree2.entreNiveles(0, 10);
        System.out.println("\n\n");

        // Test sumaElementosProfundidad() for different depths
        testSumaElementosProfundidad(tree1, 0);
        testSumaElementosProfundidad(tree1, 1);
        testSumaElementosProfundidad(tree1, 2);
        testSumaElementosProfundidad(tree2, 0);
        testSumaElementosProfundidad(tree2, 1);
        testSumaElementosProfundidad(tree2, 2);
    }

    private static void testSumaElementosProfundidad(BinaryTree<Integer> tree, int depth) {
        ProfundidadDeArbolBinario obj = new ProfundidadDeArbolBinario(tree);
        int suma = obj.sumaElementosProfundidad(depth);

        System.out.println("Suma de elementos en profundidad " + depth + ":");
        // System.out.println(tree);
        System.out.println("Suma: " + suma);
        System.out.println("------------------------------------");
    }

    private static BinaryTree<Integer> createBinaryTree1() {
        // Create a binary tree with the following structure:
        //
        // 1
        // / \
        // 2 3
        // / \ /
        // 4 5 6
        BinaryTree<Integer> root = new BinaryTree<>(1);
        root.addLeftChild(new BinaryTree<>(2));
        root.addRightChild(new BinaryTree<>(3));
        root.getLeftChild().addLeftChild(new BinaryTree<>(4));
        root.getLeftChild().addRightChild(new BinaryTree<>(5));
        root.getRightChild().addLeftChild(new BinaryTree<>(6));
        return root;
    }

    private static BinaryTree<Integer> createBinaryTree2() {
        // Create a binary tree with the following structure:
        //
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        BinaryTree<Integer> root = new BinaryTree<>(1);
        root.addLeftChild(new BinaryTree<>(2));
        root.addRightChild(new BinaryTree<>(3));
        root.getLeftChild().addLeftChild(new BinaryTree<>(4));
        root.getRightChild().addRightChild(new BinaryTree<>(5));
        return root;
    }
}
