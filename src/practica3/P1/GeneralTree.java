/* / Considere la siguiente especificación de la clase GeneralTree (con la representación de Lista de Hijos)
 El constructor GeneralTree(T value) inicializa un árbol que tiene como raíz un nodo y este nodo
 tiene el dato pasado como parámetro y una lista vacía.
 El constructor GeneralTree (T data, List<GeneralTree <T>> children) inicializa un árbol que
 tiene como raíz a un nodo y este nodo tiene el dato pasado como parámetro y como hijos a la lista:
 El método getData():T retorna el dato almacenado en la raíz del árbol.
 El método getChildren():Lista<GeneralTree <T>>, retorna la lista de hijos de la raíz del árbol.
 El método addChild(GeneralTree <T> child) agrega un hijo al final de la lista de hijos del árbol
 El método removeChild(GeneralTree <T> child) elimina del árbol el hijo pasado como parámetro.
 El método hasChildren() devuelve verdadero si la lista de hijos del árbol no es null y tampoco es
 vacía
 El método isEmpty() devuelve verdadero si el dato del árbol es null y además no tiene hijos.
 Los métodos altura(), nivel(T) y ancho() se resolverán en el ejercicio 3.
 Analice la implementación en JAVA de las clases GeneralTree brindada por la cátedra. / */

package practica3.P1;

import java.util.List;

import practica1.P8.Queue;

import java.util.LinkedList;

public class GeneralTree<T> {

    private T data;
    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return children != null && !children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren()) {
            List<GeneralTree<T>> children = this.getChildren();
            if (children.contains(child))
                children.remove(child);
        }
    }

    public int altura() {
        if (this.isEmpty()) {
            return 0;
        }

        int maxAltura = 0;
        for (GeneralTree<T> child : this.getChildren()) {
            int childAltura = child.altura();
            if (childAltura > maxAltura) {
                maxAltura = childAltura;
            }
        }
        return 1 + maxAltura;
    }

    public int nivel(T dato) {
        if (this.getData().equals(dato)) {
            return 0;
        }
        for (GeneralTree<T> child : this.getChildren()) {
            int childNivel = child.nivel(dato);
            if (childNivel != -1) {
                return 1 + childNivel;
            }
        }
        return -1;
    }

    // devuelve true si el valor “a” es ancestro del valor “b”.
    public boolean esAncestro(T a, T b) {
        return false;
    }

    public int ancho() {
        GeneralTree<T> aux;
        Queue<GeneralTree<T>> cola = new Queue<>();
        cola.enqueue(this);
        cola.enqueue(null);
        int nodosMax = -1;
        int nodos = 0;

        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            if (aux != null) {
                nodos++;
                if (aux.hasChildren()) {
                    for (GeneralTree<T> child : aux.getChildren()) {
                        cola.enqueue(child);
                    }
                }
            } else {
                if (nodos > nodosMax)
                    nodosMax = nodos;
                nodos = 0;
                if (!cola.isEmpty())
                    cola.enqueue(null);
            }
        }
        return nodosMax;
    }

}
