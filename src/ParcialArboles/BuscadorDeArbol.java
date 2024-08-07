package ParcialArboles;

import java.util.List;

import practica3.P1.GeneralTree;

public class BuscadorDeArbol {
    private GeneralTree<Integer> arbol;

    public GeneralTree<Integer> getArbol() {
        return this.arbol;
    }

    public BuscadorDeArbol(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public Integer buscarMayorEnPostOrden() {
        Integer max = Integer.MIN_VALUE;
        if (!arbol.isEmpty())
            max = buscar_rec(arbol);
        return max;
    }

    private int buscar_rec(GeneralTree<Integer> ag) {
        int mayor = -1; // Integer.MIN_VALUE;
        if (ag.hasChildren()) {
            List<GeneralTree<Integer>> children = ag.getChildren();
            for (GeneralTree<Integer> child : children) {
                int mayorHijo = buscar_rec(child);
                mayor = (mayorHijo >= mayor) ? mayorHijo : mayor;
            }
        }

        return (mayor >= ag.getData()) ? mayor : ag.getData();
    }
}
