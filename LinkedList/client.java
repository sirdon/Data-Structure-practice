package LinkedList;

public class client {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(5);
        list.addLast(3);
        list.addLast(5);
        list.addLast(6);
        list.addLast(8);
        list.addAt(2,6);
        list.display();
        list.removeFirst();
        list.removeLast();
        list.removeAt(0);
        list.getFirst();
        list.getAt(2);
        list.getLast();
        list.display();
        list.size();
    }
}