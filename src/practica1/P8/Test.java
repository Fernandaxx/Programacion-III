package practica1.P8;

public class Test {
    public static void main(String[] args) {

        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("completo  " + q);
        q.dequeue();
        System.out.println("dequeue " + q);
        System.out.println("cabeza" + q.head());
        CircularQueue<Integer> c = new CircularQueue<Integer>();
        c.enqueue(1);
        c.enqueue(2);
        c.enqueue(3);
        c.enqueue(4);
        System.out.println("normal" + c.toString());
        c.shift();
        System.out.println("shift " + c.toString());
        c.shift();
        System.out.println("shift " + c.toString());
    }

}
