package queue;

public class cleint {
    public static void main(String[] args) {
        queue q = new queue(5);
        q.enqueue(1); 
        q.enqueue(2); 
        q.enqueue(3); 
        q.enqueue(4); 
        q.enqueue(5); 
        q.enqueue(6); 

        q.display();
        q.dequeue();
        q.peek();
        q.size();
        q.display();
    }
}