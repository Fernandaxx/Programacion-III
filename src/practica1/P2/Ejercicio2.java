/* Escriba un método de clase que dado un número n devuelva un nuevo arreglo de tamaño n
con los n primeros múltiplos enteros de n mayores o iguales que 1.
Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {n*k donde k : 1..k}
Agregue al programa la posibilidad de probar con distintos valores de n ingresandolos por
teclado, mediante el uso de System.in. La clase Scanner permite leer de forma sencilla
valores de entrada. */

package practica1.P2;

import java.util.Scanner;

public class Ejercicio2 {
    public static int[] arrayMultiplos(int n) {
        int[] Vector = new int[n];
        for (int i = 0; i < Vector.length; i++) {
            Vector[i] = n * (i + 1);
        }
        return Vector;
    }

    public static void main(String[] args) {
        System.out.println("Ingrese un numero");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] V = arrayMultiplos(n);
        for (int i : V) {
            System.out.println(i);
        }
        in.close();
    }

}
