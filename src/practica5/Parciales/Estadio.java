package practica5.Parciales;

public class Estadio {
    private String nombre;
    private String ciudad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Estadio(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

}
