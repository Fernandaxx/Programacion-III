package practica5.P;

public class Sitio {
    private int mafia;
    private String nombre;

    public int getMafia() {
        return mafia;
    }

    public Sitio(int mafia, String nombre) {
        this.mafia = mafia;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMafia(int mafia) {
        this.mafia = mafia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
