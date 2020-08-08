package activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
    public class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;
    private int size;
    public BinaryTree(){
        this.root  = this.construct(new Scanner(System.in), null, false);
    }
    private Node construct(Scanner scn, Node parent, boolean ilc){
        if(parent == null){
            System.out.println("Enter the data for root");
        } else {
            if(ilc){
                System.out.println("Enter the data for left child of "+ parent.data);
            } else{
                System.out.println("Enter the data for right child of "+ parent.data);
            } 
        }

        int cdata = scn.nextInt();
        Node child = new Node();
        child.data = cdata;
        this.size++;

        System.out.println("Do you have a left child for  "+ child.data);
        boolean hlc = scn.nextBoolean();

        if(hlc){
            child.left = construct(scn, child, true);
        }

        System.out.println("Do you have a right child for "+ child.data);
        hlc = scn.nextBoolean();
        if(hlc){
            child.right = construct(scn, child, false);
        }

        return child;
    }
    public int size() {
        return size(root);
    }
    private int size(Node node) {
        if(node==null) return 0;
        int leftSize = size(node.left);
        int rightSize = size(node.right);

        return leftSize + rightSize +1;
    }
    public boolean isEmptye() {
        return this.size==0;
    }
    public void display() {
        display(root);
    }
    private void display(Node node) {
        if(node==null) return;
        String str = "";
        str+= node.left !=null ? node.left.data:".";
        str+= " -> "+ node.data +" <- ";
        str+= node.right !=null ? node.right.data:".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public int max() {
        return max(root);
    }
    private int max(Node node) {
        if(node == null) return Integer.MIN_VALUE;
        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(node.data, Math.max(lmax, rmax));
    }
    public int height() {
        return height(root);
    }
    private int height(Node node) {
        if(node == null) return -1;

        int lheight = height(node.left);
        int rheight = height(node.right);

        int    height = Math.max(lheight, rheight) + 1;
        return height;
    }
	public boolean findNode(int i) {
		return findNode(root,i);
	}

    private boolean findNode(Node node, int i) {
        if(node == null) return false;
        if(node.data==i) return true;

        boolean findInLeftNode = findNode(node.left , i);
        if(findInLeftNode) return true;
        boolean findInRightNode = findNode(node.right , i);
        if(findInRightNode) return true;
        return false;
    }
    public void preorder() {
        System.out.println("preorder");
        preorder(root);
        System.out.println(".");
    }

    private void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
	public void postorder() {
        System.out.println("postorder");
        postorder(root);
        System.out.println(".");
	}
	
    private void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }

    public void inorder() {
        System.out.println("inorder");
        inorder(root);
        System.out.println(".");
	}

    private void inorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        System.out.print(node.data+" ");
        postorder(node.right);
    }
	public void levelOrder() {
        System.out.println("levelOrder");
        levelOrder(root);
        System.out.println(".");
	}

    private void levelOrder(Node node) {
        LinkedList <Node> queue = new LinkedList<>();
        queue.addLast(root);
        while(queue.size()!=0){
            Node temp = queue.removeFirst();
            System.out.print(temp.data+" ");
            if(temp.left!=null) queue.addLast(temp.left);
            if(temp.right!=null) queue.addLast(temp.right);
        }
    }
	public ArrayList<Integer> findPath(int val) {
		return findPathHelper(root,val);
	}

    private ArrayList<Integer> findPathHelper(Node node, int val) {
        if(node.data==val){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(val);
            return ans;
        }
        if(node.left!=null){
            ArrayList<Integer> l1 = findPathHelper(node.left, val);
            if(l1.size()!=0){
            l1.add(node.data);
            return l1;
            }
        }
        if(node.right!=null){
            ArrayList<Integer> l1 = findPathHelper(node.right, val);
            if(l1.size()!=0){
            l1.add(node.data);
            return l1; }
        }
        return new ArrayList<>();
    }
    
}// 20 true 10 true 40 true 5 false false false true 50 false false true 30 false true 90 true 1 false false false