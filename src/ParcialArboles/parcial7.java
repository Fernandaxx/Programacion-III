package ParcialArboles;

import java.util.LinkedList;
import java.util.List;

import practica3.P1.GeneralTree;

public class parcial7 {

    public List<Integer> resolver(GeneralTree<Integer> ag) {
        List<Integer> lista = new LinkedList<>();
        if (ag != null && !ag.isEmpty()) {
            // int dad = ag.getData() * 2;
            Boolean corte = true;
            resolver_rec(ag, lista, 0, corte);
        }
        return lista;

    }

    private void resolver_rec(GeneralTree<Integer> ag, List<Integer> lista, int dad, Boolean condicion) {

        if (ag.getData() < dad) {
            condicion = false;
            return;
        } else
            lista.add(ag.getData());
        if (ag.hasChildren()) {
            List<GeneralTree<Integer>> children = ag.getChildren();
            dad = 2 * ag.getData();
            for (GeneralTree<Integer> child : children) {
                if (condicion)
                    resolver_rec(child, lista, dad, condicion);
                else
                    return;
            }
        }
    }
}
