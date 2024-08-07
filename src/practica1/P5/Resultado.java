package practica1.P5;

public class Resultado {
    private int max;
    private int min;
    private float promedio;

    public Resultado() {
    }

    public Resultado(int max, int min, float promedio) {
        this.max = max;
        this.min = min;
        this.promedio = promedio;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Resultado [max=" + max + ", min=" + min + ", promedio=" + promedio + "]";
    }

}
