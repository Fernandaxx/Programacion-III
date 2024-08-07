/*  a) Implemente en la clase RecorridosAG los siguientes métodos:
 public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,
 Integer n)
 Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 pasados como parámetros, recorrido en preorden.
 public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,
 Integer n)
 Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 pasados como parámetros, recorrido en inorden.
 public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,
 Integer n)
 Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 pasados como parámetros recorrido en postorden.
 public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,
 Integer n)
 Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n”
 pasados como parámetros, recorrido por niveles.
 b) Si ahora tuviera que implementar estos métodos en la clase GeneralTree<T>, qué modificaciones
 haría tanto en la firma como en la implementación de los mismos? */

package practica3.P2;

import java.util.LinkedList;
import java.util.List;

import practica3.P1.GeneralTree;
import practica1.P8.Queue;

public class RecorridosAG {

    public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a, Integer n) {
        int num = a.getData();
        List<Integer> l = new LinkedList<Integer>();
        if ((num % 2 != 0) && num > n) {
            l.add(num);
        }
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> generalTree : children) {
            l.addAll(numerosImparesMayoresQuePreOrden(generalTree, n));
        }
        return l;
    }

    public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        List<GeneralTree<Integer>> children = a.getChildren();
        if (!children.isEmpty())
            l.addAll(numerosImparesMayoresQueInOrden(children.get(0), n)); // evalua el primer hijo

        int num = a.getData();
        if ((num % 2 != 0) && num > n)
            l.add(num);

        if (children.size() > 1) {
            for (int i = 1; i < children.size(); i++) {
                l.addAll(numerosImparesMayoresQueInOrden(children.get(i), n));
            }
        }
        return l;
    }

    public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        List<GeneralTree<Integer>> children = a.getChildren();
        for (GeneralTree<Integer> generalTree : children) {
            l.addAll(numerosImparesMayoresQuePreOrden(generalTree, n));
        }
        int num = a.getData();
        if ((num % 2 != 0) && num > n) {
            l.add(num);
        }
        return l;
    }

    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n) {
        List<Integer> l = new LinkedList<Integer>();
        GeneralTree<Integer> aux;

        Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
        cola.enqueue(a);
        while (!cola.isEmpty()) {
            aux = cola.dequeue();
            int num = aux.getData();
            if ((num % 2 != 0) && num > n) {
                l.add(num);
            }
            List<GeneralTree<Integer>> children = aux.getChildren();
            for (GeneralTree<Integer> child : children) {
                cola.enqueue(child);
            }
        }
        return l;
    }

}
