
package practica1.P1;

public class Ejercicio1 {

    public static void MetodoA(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    public static void MetodoB(int a, int b) {
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }

    public static void MetodoC(int a, int b) {
        System.out.println(a);
        a++;
        if (a <= b) {
            MetodoC(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println("MetodoA");
        MetodoA(2, 5);
        System.out.println("MetodoB");
        MetodoB(2, 5);
        System.out.println("MetodoC");
        MetodoC(2, 5);
    }
}
