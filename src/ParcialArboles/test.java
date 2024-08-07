package ParcialArboles;

import java.util.List;

import practica2.P1.BinaryTree;

public class test {

    /*
     * 2
     * / \
     * / \
     * 1 5
     * / \ / \
     * / \ / \
     * 16 6 25 8
     * \ /
     * \ /
     * 64 22
     */

    public class ParcialTest {

        public static void main(String[] args) {
            BinaryTree<Integer> a = new BinaryTree<Integer>(2);

            BinaryTree<Integer> b = new BinaryTree<Integer>(1);
            BinaryTree<Integer> c = new BinaryTree<Integer>(5);

            BinaryTree<Integer> d = new BinaryTree<Integer>(16);
            BinaryTree<Integer> e = new BinaryTree<Integer>(6);

            BinaryTree<Integer> f = new BinaryTree<Integer>(8);

            BinaryTree<Integer> g = new BinaryTree<Integer>(22);

            // BinaryTree<Integer> h = new BinaryTree<Integer>(12);

            // BinaryTree<Integer> i = new BinaryTree<Integer>(64);

            a.addLeftChild(b);
            a.addRightChild(c);

            b.addLeftChild(d);
            b.addRightChild(e);

            c.addRightChild(f);
            // c.addLeftChild(h);

            f.addLeftChild(g);

            // h.addRightChild(i);

            Parcial4 test = new Parcial4();

            List<Integer> l = test.resolver(a);

            System.out.println(l);
        }

    }

}
