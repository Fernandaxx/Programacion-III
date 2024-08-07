package ParcialArboles;

import java.util.LinkedList;
import java.util.List;

import practica3.P1.GeneralTree;

public class PrimerFecha {

    public static Integer buscarArchivo(GeneralTree<String> arbol, String texto) {
        Integer cant = 0;
        if (arbol.hasChildren()) {
            List<GeneralTree<String>> children = arbol.getChildren();
            for (GeneralTree<String> child : children) {
                cant += buscarArchivo(child, texto);
            }
        }
        if (arbol.isLeaf()) {
            if (arbol.getData().contains(texto))
                cant++;
        }
        return cant;
    }

    public static void main(String[] args) {
        List<GeneralTree<String>> hijos = new LinkedList<>();
        hijos.add(new GeneralTree<String>("casa"));
        hijos.add(new GeneralTree<String>("tasaz"));
        hijos.add(new GeneralTree<String>("caro"));

        GeneralTree<String> arbol = new GeneralTree<String>("raiz", hijos);
        System.out.println(buscarArchivo(arbol, "asa"));
    }
}