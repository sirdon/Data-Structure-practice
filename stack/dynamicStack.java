package stack;

public class dynamicStack {
    int top=-1;
    int capacity=10;
    int size=0;
    int[] arr;
	dynamicStack() {
        arr = new int[this.capacity];
	}

	public void push(int data) {
        if(isFull()){
            int[] temparr = new int[this.capacity*2];
            for(int i=0;i<capacity;i++)
                temparr[i] = arr[i];
            arr = temparr;
            this.capacity*=2;
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