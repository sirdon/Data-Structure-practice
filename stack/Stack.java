package stack;

public class Stack {
    int top=-1;
    int capacity=0;
    int size=0;
    int[] arr;
	Stack(int n) {
        arr = new int[n];
        this.capacity=n;
	}

	public void push(int data) {
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        this.top = this.top+1;
        arr[this.top]=data;
        this.size++;
	}

	private boolean isFull() {
        return size==capacity;
    }

    public int pop() {
        if(isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        int temp = arr[top];
        top--;
        this.size--;
		return temp;
	}

	private boolean isEmpty() {
        return size==0;
    }

    public int peek() {
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        System.out.println(arr[top]);
        return arr[top];
	}

	public void display() {
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        for(int i=0;i<=top;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
	}

	public int size() {
        System.out.println(this.size);
        return this.size;
	}
    
}