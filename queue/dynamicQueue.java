package queue;

public class dynamicQueue {
    int size=0;
    int front=-1;
    int rear = -1;
    int capacity=10;
    int[] arr;

	dynamicQueue() {
        arr = new int[this.capacity];
        this.front=0;
	}

	public void enqueue(int data) {
        if(isFull()){
            
            int[] tempArr = new int[this.capacity*2];
            for(int i=0;i<this.capacity;i++)
                tempArr[i] = arr[i];
            arr = tempArr;
            this.capacity=this.capacity*2; 
        }
        this.rear = (this.rear+1)%this.capacity;
        arr[this.rear] = data;
        this.size++;
	}

	private boolean isFull() {
        return this.size==this.capacity;
    }

    public int dequeue() {
		if(isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        int temp = arr[this.front];
        this.front= (this.front+1)%this.capacity;
        this.size--;
        System.out.println(temp);
        return temp;
	}

	private boolean isEmpty() {
        return this.size==0;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Queue underflow");
            return -1;
        }
        System.out.println(arr[this.front]);
		return arr[this.front];
	}

	public int size() {
        System.out.println(this.size);
		return this.size;
	}

	public void display() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        if(this.rear>this.front){
            for(int i=front;i<=this.rear;i++)
            System.out.print(arr[i]+" ");
            System.out.println();
        }else{
            for(int i=front;i<this.capacity;i++){
                System.out.print(arr[i]+" ");
            }
            for(int i=this.rear;i<this.front;i++){
                System.out.println(arr[i]);
            }
        }
	}
    
}