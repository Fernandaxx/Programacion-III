package practica2.P1;

import practica1.P8.Queue;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree() {
        super();
    }

    public BinaryTree(T data, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * Preguntar antes de invocar si hasLeftChild()
     * 
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    /**
     * Preguntar antes de invocar si hasRightChild()
     * 
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty() {
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    @Override
    public String toString() {
        return this.getData().toString();
    }

    // Devuelve la cantidad de árbol/subárbol hojas del árbol receptor
    public int contarHojas() {
        if (this.isLeaf()) {
            return 1;
        } else {
            int total = 0;
            if (this.hasLeftChild())
                total += this.leftChild.contarHojas();
            if (this.hasRightChild())
                total += this.rightChild.contarHojas();
            return total;
        }
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> arbolEspejo = new BinaryTree<>(this.data);
        if (this.hasLeftChild())
            arbolEspejo.addRightChild(this.leftChild.espejo());
        if (this.hasRightChild())
            arbolEspejo.addLeftChild(this.rightChild.espejo());
        return arbolEspejo;
    }

    // 0<=n<=m Imprime el recorrido por niveles de los elementos del árbol
    // receptor entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)

    public void entreNiveles2(int n, int m) {

        BinaryTree<T> nodoAct = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        int nivel = 0;
        while (!cola.isEmpty() && n <= m) {
            nodoAct = cola.dequeue();
            if (nodoAct != null) {
                if (nivel == n)
                    System.out.print(nodoAct.getData() + " ");
                if (nodoAct.hasLeftChild()) {
                    cola.enqueue(nodoAct.getLeftChild());
                }
                if (nodoAct.hasRightChild()) {
                    cola.enqueue(nodoAct.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                if (nivel == n)
                    System.out.println();
                cola.enqueue(null);
                nivel++;
                if (nivel > n)
                    n++;
            }
        }
    }

    public void entreNiveles(int n, int m) {
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        BinaryTree<T> aux;
        int nivel = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty() && nivel <= m) {
            aux = cola.dequeue();
            if (aux != null) {
                if (nivel >= n)
                    System.out.print(aux.getData() + "-");
                if (aux.hasLeftChild())
                    cola.enqueue(aux.getLeftChild());
                if (aux.hasRightChild())
                    cola.enqueue(aux.getRightChild());
            } else if (!cola.isEmpty()) {
                if (nivel >= n)
                    System.out.println();
                cola.enqueue(null);
                nivel++;
            }
        }
    }

}