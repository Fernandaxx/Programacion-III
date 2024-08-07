package practica1.P7;

import java.util.ArrayList;
import java.util.LinkedList;

public class EjercicioSucesion {

    public static ArrayList<Integer> calcularSucesion(int n) {
        ArrayList<Integer> sucesion = new ArrayList<>();
        if (n == 1) {
            sucesion.add(n);
            return sucesion;
        }
        sucesion.add(n);
        int nextElement = n % 2 == 0 ? n / 2 : 3 * n + 1;
        sucesion.addAll(calcularSucesion(nextElement));
        return sucesion;
    }

    public static void invertirArrayList(ArrayList<Integer> lista) {
        if (lista.size() <= 1)
            return;
        int aux = lista.remove(0);
        invertirArrayList(lista);
        lista.add(aux);
    }

    /*
     * Implemente un método recursivo que calcule la suma de los elementos en un
     * LinkedList.
     * public int sumarLinkedList(LinkedList<Integer> lista)
     */
    public static int sumarLinkedList(LinkedList<Integer> lista) {
        if (lista.isEmpty()) {
            return 0;
        }
        int valorNodoActual = lista.remove(0); // forma de avanza sin remover?
        int suma = valorNodoActual + sumarLinkedList(lista);
        lista.add(valorNodoActual);
        return suma;
    }

    public static ArrayList<Integer> combinarOrdenado(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        ArrayList<Integer> listaFinal = new ArrayList<>();
        int indice1 = 0;
        int indice2 = 0;
        while (indice1 < lista1.size() && indice2 < lista2.size()) {
            if (lista1.get(indice1) <= lista2.get(indice2)) {
                listaFinal.add(lista1.get(indice1));
                indice1++;
            } else {
                listaFinal.add(lista2.get(indice2));
                indice2++;
            }
        }
        while (indice1 < lista1.size()) {
            listaFinal.add(lista1.get(indice1));
            indice1++;
        }
        while (indice2 < lista2.size()) {
            listaFinal.add(lista2.get(indice2));
            indice2++;
        }
        return listaFinal;
    }

    public static void main(String[] args) {

        System.out.println(calcularSucesion(6));
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(8);
        lista.add(9);
        lista.add(19);
        lista.add(20);
        System.out.println("Lista 1 \n " + lista);

        invertirArrayList(lista);
        System.out.println(lista);
        LinkedList<Integer> listaLink = new LinkedList<>();

        listaLink.add(1);
        listaLink.add(3);
        listaLink.add(8);
        listaLink.add(9);
        listaLink.add(5);
        listaLink.add(6);
        System.out.println(sumarLinkedList(listaLink));
        System.out.println(listaLink);

        ArrayList<Integer> lista2 = new ArrayList<>();
        lista2.add(2);
        lista2.add(12);
        lista2.add(47);
        lista2.add(49);
        lista2.add(55);
        lista2.add(63);
        lista2.add(90);

        System.out.println("Lista 2 \n " + lista2);

        System.out.println("MERGE \n " + combinarOrdenado(lista, lista2));

    }
}
