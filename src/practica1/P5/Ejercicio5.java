package practica1.P5;

/* Dado un arreglo de valores tipo entero se desea calcular el valor máximo, mínimo, y promedio
en un único método. Escriba tres métodos de clase, donde respectivamente:
a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede ser de
tipo arreglo).
c. Devuelva lo pedido sin usar parámetros ni la sentencia "return". */

public class Ejercicio5 {

    public static String ValorMaxMinPromA(int[] vector) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        float promedio = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min)
                min = vector[i];
            if (vector[i] > max)
                max = vector[i];
            promedio += vector[i];
        }
        promedio /= vector.length;

        return "Maximo: " + max + " minimo: " + min + " promedio " + promedio;
    }

    public static void ValorMaxMinPromB(int[] vector, Resultado result) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        float promedio = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < min)
                min = vector[i];
            if (vector[i] > max)
                max = vector[i];
            promedio += vector[i];
        }
        promedio /= vector.length;

        result.setMax(max);
        result.setMin(min);
        result.setPromedio(promedio);
    }

    // METODO C imprimiendo directamente en el metodo?

    public static void main(String[] args) {
        int[] vector = { 10, 15, 1, 13, 20 };
        System.out.println("metodo1");
        System.out.println(ValorMaxMinPromA(vector));
        System.out.println("metodo2");
        Resultado resultado = new Resultado();
        ValorMaxMinPromB(vector, resultado);
        System.out.println(resultado);
    }

}
