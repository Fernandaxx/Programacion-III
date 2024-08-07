package ParcialArboles;

import practica3.P1.GeneralTree;

public class ParcialTest {

    public static void main(String[] args) {
        GeneralTree<Integer> a = new GeneralTree<Integer>(10);
        GeneralTree<Integer> b = new GeneralTree<Integer>(20);
        GeneralTree<Integer> c = new GeneralTree<Integer>(30);
        GeneralTree<Integer> d = new GeneralTree<Integer>(40);

        GeneralTree<Integer> e = new GeneralTree<Integer>(1);
        GeneralTree<Integer> f = new GeneralTree<Integer>(2);
        GeneralTree<Integer> g = new GeneralTree<Integer>(300);

        GeneralTree<Integer> h = new GeneralTree<Integer>(100);
        GeneralTree<Integer> i = new GeneralTree<Integer>(200);

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        c.addChild(e);
        c.addChild(f);
        c.addChild(g);

        d.addChild(h);
        d.addChild(i);

        BuscadorDeArbol test = new BuscadorDeArbol(a);

        System.out.println(test.buscarMayorEnPostOrden());
    }

}
