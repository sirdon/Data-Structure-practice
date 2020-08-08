package LinkedList;

public class LinkedList {
    Node head;
    Node tail;
    int size=0;
    LinkedList(){
        this.head=null;
        this.tail=null;
    }
	public void addFirst(int data) {
        Node node = new Node(data);
        if(size==0){
            head=tail=node;
        }else{
        node.next = head;
        head=node;
        this.size++;
        }
        System.out.println("addfirst");
	}

	public void addLast(int data) {
        if(size==0){
            addFirst(data);
        }else{
            Node node = new Node(data);
            this.tail.next = node;
            this.tail = node;
            size++;
        }
        System.out.println("addlast");
	}

	public void addAt(int index, int data) {
        if(index>size){
            System.out.println("error");
            return;
        }
        if(index==0){
            addFirst(data);
        }else if(index==size){
            addLast(data);
        }else{
            Node temp = this.head;
            int i=0;
            while(i!=index-1){
                temp=temp.next;
            }
            Node node = new Node(data);
            node.next = temp.next;
            temp.next = node;
            size++;
        }
        System.out.println("addat"+index);
	}

	public int removeFirst() {
        if(size==0){
            System.out.println("error");
            return -1;
        }
        int val = this.head.data;
        this.head=this.head.next;
        size--;
        System.out.println("removefirst");
        return val;
	}

	public int removeLast() {
        if(size==0){
            System.out.println("error");
            return -1;
        }
        int i=0;
        int val = tail.data;
        Node temp=head;
        while(i!=size-2){
            temp=temp.next;
        }
        tail=temp;
        temp.next=null;
        size--;
        System.out.println("removelast");
        return val;
	}

	public int removeAt(int index) {
        if(index>size){
            System.out.println("error");
            return -1;
        }
        if(index==0){
            return removeFirst();
        }else if(index==size-1){
            return removeLast();
        }else{
            int i=0;
            Node temp = head;
            while(i!=index-1){
                temp=temp.next;
            }
            int val = temp.next.data;
            temp.next=temp.next.next;
            size--;
            System.out.println("removeat"+index);
            return val;
        }
	}

	public int getFirst() {
        if(size==0){
            System.out.println("error");
            return -1;
        }
        System.out.println("getfirst");
        return head.data;
	}

	public int getAt(int index) {
        Node temp=head;
        int i=0;
        while(i!=index){
            temp=temp.next;
        }
        System.out.println("getat"+index);
        return temp.data;
	}

	public int getLast() {
        if(size==0){
            System.out.println("error");
            return -1;
        }
        System.out.println("getlast");
        return tail.data;
	}

	public void display() {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
        System.out.println();
	}
	public int size() {
        return size;
	}
    
}