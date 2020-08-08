package activity;

import java.util.ArrayList;

public class GenericTree {
    public class Node{
        int data;
        ArrayList<Node> children;
        Node(int data) {
            this.data = data;
            this.children =new ArrayList<Node>();
        }
    }
    
    Node root;
    public GenericTree(int[] arr){
        idx= 0;
        this.root = populateTree(arr);
    }
    static int idx = 0;
    private Node populateTree(int[] data){
        //base case
        
        //my work
        Node node = new Node(data[idx]);
        idx++;
        //recursive calls
        while(data[idx]!=-1){
            Node child = populateTree(data);
            node.children.add(child);
        }
        idx++;
        return node;
    }
    public void display() {
        displayHelper(this.root);
    }
    
    private void displayHelper(Node node) {
        System.out.print(node.data + " -> ");
    
        for(Node child : node.children){
            System.out.print((child.data +","));
        }
        System.out.println(".");
        for(Node child : node.children){
            displayHelper(child);
        }
    }
}

