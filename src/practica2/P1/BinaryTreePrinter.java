/*
 * package practica2.P1;
 * 
 * import java.util.LinkedList;
 * import java.util.List;
 * 
 * public class BinaryTreePrinter<T> {
 * 
 * public void preorden(BinaryTree<T> ab) {
 * System.out.println(ab.getData());
 * if (ab.hasLeftChild()) {
 * this.preorden(ab.getLeftChild());
 * }
 * if (ab.hasRightChild()) {
 * this.preorden(ab.getRightChild());
 * }
 * }
 * 
 * public List<T> preOrdenList(BinaryTree<T> ab) {
 * List<T> result = new LinkedList<T>();
 * this.preorden_private(ab, result);
 * return result;
 * }
 * 
 * private void preorden_private(BinaryTree<T> ab, List<T> result) {
 * result.add(ab.getData());
 * if (ab.hasLeftChild()) {
 * ab.getLeftChild().printPreorden();
 * }
 * if (ab.hasRightChild()) {
 * ab.getRightChild().printPreorden();
 * }
 * }
 * }
 */