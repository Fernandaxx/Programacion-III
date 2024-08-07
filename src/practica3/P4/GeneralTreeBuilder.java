package practica3.P4;
/*
 * package Practica3.P5;
 * 
 * import java.util.*;
 * 
 * import Practica3.P1.GeneralTree;
 * 
 * public class GeneralTreeBuilder<T> {
 * 
 * private Scanner scanner;
 * 
 * public GeneralTreeBuilder() {
 * this.scanner = new Scanner(System.in);
 * }
 * 
 * public GeneralTree<T> buildTree() {
 * System.out.print("Raiz: \n");
 * T data = readData();
 * 
 * GeneralTree<T> root = new GeneralTree<>(data);
 * root.setChildren(buildChildren(root));
 * 
 * return root;
 * }
 * 
 * private List<GeneralTree<T>> buildChildren(GeneralTree<T> parent) {
 * List<GeneralTree<T>> children = new LinkedList<>();
 * 
 * System.out.print("Do you want to add a child to " + parent.getData() +
 * "? (yes/no): ");
 * String answer = scanner.nextLine();
 * 
 * while (answer.equalsIgnoreCase("yes")) {
 * System.out.print("Enter data for the child node: ");
 * T childData = readData();
 * 
 * GeneralTree<T> child = new GeneralTree<>(childData);
 * child.setChildren(buildChildren(child));
 * 
 * children.add(child);
 * 
 * System.out.print("Do you want to add another child to " + parent.getData() +
 * "? (yes/no): ");
 * answer = scanner.nextLine();
 * }
 * 
 * return children;
 * }
 * 
 * private Integer readData() {
 * String input = scanner.nextLine();
 * try {
 * return Integer.parseInt(input);
 * } catch (NumberFormatException e) {
 * System.out.println("Invalid input: Please enter an integer value.");
 * return readData(); // Recursively call to get valid integer input
 * }
 * }
 * 
 * public static void main(String[] args) {
 * GeneralTreeBuilder<Integer> builder = new GeneralTreeBuilder<>();
 * GeneralTree<Integer> tree = builder.buildTree();
 * 
 * System.out.println("Created GeneralTree:");
 * printTree(tree);
 * 
 * AnalizadorArbol analizador = new AnalizadorArbol();
 * int maxPromedio = analizador.devolverMaximoPromedio(tree);
 * System.out.println("Máximo promedio entre niveles: " + maxPromedio);
 * }
 * 
 * private static void printTree(GeneralTree<Integer> tree) {
 * if (tree == null) {
 * return;
 * }
 * 
 * System.out.print(tree.getData() + " ");
 * for (GeneralTree<Integer> child : tree.getChildren()) {
 * printTree(child);
 * }
 * }
 * }
 */