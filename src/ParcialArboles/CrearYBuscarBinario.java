package ParcialArboles;

import practica1.P8.Queue;
import practica2.P1.BinaryTree;

public class CrearYBuscarBinario {

    public static void agregarDato(BinaryTree<Integer> ab, int n) { // ordenado
        if (ab.isEmpty()) { // caso base
            ab.setData(n);
        } else if (ab.getData() < n) {
            if (!ab.hasRightChild()) // si no tiene HD creo el nodo
                ab.addRightChild(new BinaryTree<Integer>(null));
            agregarDato(ab.getRightChild(), n); // lamado con el HD
        } else if (ab.getData() > n) {
            if (!ab.hasLeftChild())
                ab.addLeftChild(new BinaryTree<Integer>(null));
            agregarDato(ab.getLeftChild(), n); // agrega en el HI
        }
    }

    public static BinaryTree<Integer> crearAB() {
        int aux = (int) (Math.random() * 50);
        BinaryTree<Integer> ab = new BinaryTree<Integer>(aux);
        for (int i = 0; i < 20; i++) {
            agregarDato(ab, aux);
            aux = (int) (Math.random() * 100);
        }
        return ab;
    }

    // raiz , hi, hd
    public static void printPreOrden(BinaryTree<Integer> ab) {
        if (ab != null && !ab.isEmpty()) {
            System.out.println(ab.getData());

            if (ab.hasLeftChild())
                printPreOrden(ab.getLeftChild());
            if (ab.hasRightChild())
                printPreOrden(ab.getRightChild());
        }
    }

    public static void printPostOrden(BinaryTree<Integer> ab) {
        if (ab != null && !ab.isEmpty()) {
            if (ab.hasLeftChild())
                printPostOrden(ab.getLeftChild());
            if (ab.hasRightChild())
                printPostOrden(ab.getRightChild());
            System.out.println(ab.getData());
        }
    }

    public static void printInOrden(BinaryTree<Integer> ab) {
        if (ab != null && !ab.isEmpty()) {
            if (ab.hasLeftChild())
                printInOrden(ab.getLeftChild());
            System.out.println(ab.getData());
            if (ab.hasRightChild())
                printInOrden(ab.getRightChild());
        }
    }

    public static void printNivel(BinaryTree<Character> ab) {
        Queue<BinaryTree<Character>> cola = new Queue<>();
        BinaryTree<Character> aux;
        cola.enqueue(ab);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                System.out.println(aux.getData() + "-");
                if (aux.hasLeftChild())
                    cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enqueue(aux.getRightChild());
            } else if (!cola.isEmpty()) { // encontre un null en la cola->cambio de nivel->encolo otra marc d nivel null
                System.out.println();
                cola.enqueue(null);
            }
        }
    }

    /*
     * 1
     * / \
     * 15 25
     * / \ / \
     * 8 7 6 5
     */

    public static BinaryTree<Integer> crearAb2() {
        BinaryTree<Integer> ab = new BinaryTree<>(10);
        ab.addLeftChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(20));

        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(11));

        ab.addRightChild(new BinaryTree<Integer>(2));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));

        ab.getRightChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(4));

        return ab;

    }

    public static int sumar(BinaryTree<Integer> ab) {
        int suma = 0;
        if (ab != null && !ab.isEmpty()) {
            suma = ab.getData();
            if (ab.hasLeftChild())
                suma += sumar(ab.getLeftChild());
            if (ab.hasRightChild())
                suma += sumar(ab.getRightChild());
        }
        return suma;
    }

    public static void Buscar(BinaryTree<Integer> ab, int n) {
        if (ab != null) {
            if (ab.getData() == n) {
                System.out.println("Encontre");
                return;
            }
            if (ab.hasLeftChild())
                Buscar(ab.getLeftChild(), n);
            if (ab.hasRightChild())
                Buscar(ab.getRightChild(), n);
        }
    }

    public static BinaryTree<Character> crear() {
        BinaryTree<Character> ab = new BinaryTree<>('p');
        ab.addLeftChild(new BinaryTree<Character>('z'));
        ab.getLeftChild().addLeftChild(new BinaryTree<Character>('u'));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Character>('a'));
        ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Character>('b'));
        ab.getLeftChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Character>('s'));

        ab.addRightChild(new BinaryTree<Character>('g'));
        ab.getRightChild().addRightChild(new BinaryTree<Character>('o'));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Character>('t'));
        return ab;

    }

    public static void main(String[] args) {

        /*
         * BinaryTree<Integer> ab = crearAB();
         * System.out.println(ab);
         * System.out.println("Preorden");
         * printPreOrden(ab);
         * System.out.println("Postorden");
         * printPostOrden(ab);
         * System.out.println("Inorden");
         * printInOrden(ab);
         * System.out.println("NIVEL");
         * System.out.println("Suma de los nodos: " + sumar(ab));
         * Buscar(ab, 6);
         * ab.entreNiveles(0, 5);
         * ContadorArbol c = new ContadorArbol(ab);
         * 
         * List<Integer> numerosPares = c.numerosParesInOrden();
         * for (Integer integer : numerosPares) {
         * System.out.println(integer);
         * }
         * 
         * RedBinariaLlena r = new RedBinariaLlena(ab);
         * System.out.println("Retarde de reenvio " + r.retardoReenvio());
         * 
         * ab.entreNiveles(0, 5);
         * 
         * ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
         * Result resultado = p.procesar();
         * System.out.println();
         * List<Integer> listaInt = resultado.getLista();
         * 
         * for (Integer integer : listaInt) {
         * System.out.println(integer);
         * }
         * 
         * int impares = resultado.getCantidad();
         * System.out.println("Cantidad de impares" + impares);
         */

        BinaryTree<Character> a = crear();
        printNivel(a);
        ProcesadorDeArbol2 p = new ProcesadorDeArbol2(a);
        System.out.println(p.procesar(2));

    }
}
