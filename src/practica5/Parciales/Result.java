package practica5.Parciales;

public class Result {
    private int cantUsers;
    private boolean popularidad;

    public int getCantUsers() {
        return cantUsers;
    }

    public void setCantUsers(int cantUsers) {
        this.cantUsers = cantUsers;
    }

    public boolean isPopularidad() {
        return popularidad;
    }

    public Result(int cantUsers, boolean popularidad) {
        this.cantUsers = cantUsers;
        this.popularidad = popularidad;
    }

    public void setPopularidad(boolean popularidad) {
        this.popularidad = popularidad;
    }

    @Override
    public String toString() {
        return "Result [cantUsers=" + cantUsers + ", popularidad=" + popularidad + "]";
    }

}
