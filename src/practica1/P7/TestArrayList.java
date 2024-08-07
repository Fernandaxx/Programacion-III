package practica1.P7;

import java.util.*;
//import java.util.List;
//import java.util.Scanner;

import practica1.P3.Estudiante;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> listaEnteros = new ArrayList<Integer>();
        cargarListaEnteros(listaEnteros, in);
        imprimirListaInt(listaEnteros);

        List<Estudiante> lista = new ArrayList<>();
        MetodoListas(lista);
        agregarEstudiante(lista, new Estudiante("Sofia", "Aguila", "G23", "luli@gmail", "La plata"));
        System.out.println(lista + "\n");

        if (esCapicua(listaEnteros)) {
            System.out.println("ES CAPICUA");
        } else
            System.out.println("NO ES CAPICUA");

        in.close();

    }

    /*
     * public LinkedList<Integer> calcularSucesion(int n) {
     * LinkedList<Integer> lista = new LinkedList<Integer>();
     * if (n == 1) {
     * lista.add(1);
     * return lista;
     * }
     * if (n % 2 == 0) {
     * lista.add(n / 2);
     * } else {
     * lista.add(3 * n + 1);
     * }
     * return calcularSucesion(n - 1);
     * 
     * }
     */

    public static void cargarListaEnteros(List<Integer> lista, Scanner in) {
        System.out.println("Ingrese un numero / Cero para finalizar");
        int num = in.nextInt();
        while (num != 0) {
            lista.add(num);
            System.out.println("Ingrese un numero: ");
            num = in.nextInt();
        }
    }

    public static void imprimirListaInt(List<Integer> lista) {
        for (Integer numero : lista) {
            System.out.print("\t" + numero);
        }
        System.out.println("\n");
    }

    public static void impimirListaEst(List<Estudiante> lista) {
        for (Estudiante estudiante : lista) {
            System.out.println("\t" + estudiante);
        }
    }

    public static void MetodoListas(List<Estudiante> lista) {
        lista.add(new Estudiante("Luli", "Aguila", "G23", "luli@gmail", "La plata"));
        lista.add(new Estudiante("Stefanny", "Avila", "G26", "steff@gmail", "La vitoria"));
        lista.add(new Estudiante("Fer", "Avila", "G25", "fer.avila@gmail", "Area 60"));

        List<Estudiante> listaClon = new ArrayList<>();
        listaClon.addAll(lista);
        impimirListaEst(lista);
        System.out.println("\n");
        impimirListaEst(listaClon);
        System.out.println("\n");
        System.out.println(lista);
        System.out.println("\n");

        // modificar
        listaClon.set(0, new Estudiante("Lorenzo", "Aguila", "G23", "luli@gmail", "La plata"));
        impimirListaEst(listaClon);
        System.out.println("\n");
        impimirListaEst(lista);
        System.out.println("\n");

    }

    public static void agregarEstudiante(List<Estudiante> lista, Estudiante e) {
        if (!lista.contains(e)) {
            lista.add(e);
        }
    }

    public static boolean esCapicua(List<Integer> lista) {
        int inicio = 0;
        int fin = lista.size() - 1;
        if (lista == null || lista.size() <= 1) {
            return false;
        }
        while (inicio > fin) {
            if (lista.get(fin).equals(lista.get(inicio))) {
                inicio++;
                fin--;
            } else
                return false;

        }
        return true;
    }

}
