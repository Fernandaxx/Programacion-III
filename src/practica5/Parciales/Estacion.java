package practica5.Parciales;

public class Estacion {
    private String nombre;
    private int minTransbordos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMinTransbordos() {
        return minTransbordos;
    }

    public Estacion() {
    }

    public void setMinTransbordos(int minTransbordos) {
        this.minTransbordos = minTransbordos;
    }

    public Estacion(String nombre, int minTransbordos) {
        this.nombre = nombre;
        this.minTransbordos = minTransbordos;
    }

    @Override
    public String toString() {
        return "Estacion [nombre=" + nombre + ", minTransbordos=" + minTransbordos + "]";
    }

}
