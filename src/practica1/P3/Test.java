package practica1.P3;

public class Test {

    public static void main(String[] args) {

        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Luli");
        estudiante1.setApellido("Aguila");
        estudiante1.setComision("G23");
        estudiante1.setDireccion("La plata 3 y 47");
        estudiante1.setEmail("luli.aguila@gmail.com");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Stefanny");
        estudiante2.setApellido("Avila");
        estudiante2.setComision("G26");
        estudiante2.setDireccion("Area 60");
        estudiante2.setEmail("stefanny.avila@gmail.com");

        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Damian");
        profesor1.setApellido("Gulich");
        profesor1.setCatedra("Fisica2");
        profesor1.setFacultad("Ingenieria");
        profesor1.setEmail("damianG@gmail.com");

        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Gustavo");
        profesor2.setApellido("Bustos");
        profesor2.setCatedra("matematica B");
        profesor2.setFacultad("Ingenieria");
        profesor2.setEmail("bustosGus@gmail.com");

        Profesor profesor3 = new Profesor();
        profesor3.setNombre("Nefran");
        profesor3.setApellido("Avila");
        profesor3.setCatedra("Electronica");
        profesor3.setFacultad("Ingenieria");
        profesor3.setEmail("nefran.avila@gmail.com");

        Estudiante[] estudiantes = { estudiante1, estudiante2 };
        Profesor[] profesores = { profesor1, profesor2, profesor3 };

        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
        }

        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }
    }
}
