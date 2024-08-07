package practica3.P3;

import java.util.LinkedList;
import java.util.List;

import practica3.P1.GeneralTree;

public class Test {
    /*
     * public static void main(String[] args) {
     * GeneralTree<Integer> tree = new GeneralTree<>(10);
     * tree.addChild(new GeneralTree<>(5));
     * tree.addChild(new GeneralTree<>(15));
     * tree.getChildren().get(0).addChild(new GeneralTree<>(3));
     * tree.getChildren().get(1).addChild(new GeneralTree<>(18));
     * tree.getChildren().get(1).addChild(new GeneralTree<>(12));
     * 
     * System.out.println("Altura del árbol: " + tree.altura());
     * // System.out.println("Nivel del dato 15: " + tree.nivel(15));
     * // System.out.println("Ancho del árbol: " + tree.ancho());
     * }
     */

    public static void main(String[] args) {
        GeneralTree<String> a1 = new GeneralTree<String>("1");
        List<GeneralTree<String>> children2 = new LinkedList<GeneralTree<String>>();
        children2.add(new GeneralTree<String>("21"));
        children2.add(new GeneralTree<String>("22"));
        children2.add(new GeneralTree<String>("23"));
        GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
        List<GeneralTree<String>> children3 = new LinkedList<GeneralTree<String>>();
        children3.add(new GeneralTree<String>("31"));
        children3.add(new GeneralTree<String>("32"));
        children3.add(new GeneralTree<String>("32"));
        GeneralTree<String> a3 = new GeneralTree<String>("3", children3);
        List<GeneralTree<String>> childen = new LinkedList<GeneralTree<String>>();
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        GeneralTree<String> a = new GeneralTree<String>("0", childen);
        System.out.println("Altura del Arbol: " + a.altura());
        System.out.println("Nivel del dato 32: " + a.nivel("32"));
        System.out.println("Ancho del árbol: " + a.ancho());

    }
}