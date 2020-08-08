package activity;

import java.util.LinkedList;

public class client {
    public static void main(final String[] args) {
        
        // System.out.println(555);
        // BinaryTree t = new BinaryTree();
        // System.out.println(t.size());
        // t.display();
        // System.out.println(t.size());
        // System.out.println(t.max());
        // System.out.println(t.height());
        // System.out.println(t.findNode(5));
        // t.preorder();
        // t.postorder();
        // t.inorder();
        // t.levelOrder();
        // printBinary(15);
        // int arr[] = {1, 2, 5, -1, 6, -1, -1, 3 ,7, -1, 8, 10, -1, 11, 
        //     12, -1, 13, -1, -1, -1, 9, -1, -1, 4, 14, -1, 15, -1, -1, -1,
        // };
        // GenericTree gt = new GenericTree(arr);
        // gt.display();
        BinaryTree bt = new BinaryTree();
        System.out.println(bt.findPath(90));
    }
    // private static class Pair{
    //     int num;
    //     String bin="";
    //     Pair(int num, String bin){
    //         this.num=num;
    //         this.bin=bin;
    //     }
    // }
    // public static void printBinary( int val) {
    //     LinkedList<Pair> queue = new LinkedList<>();
    //     queue.add(new Pair(1,"1"));
    //     while(queue.size()!=0){
    //         Pair pair = queue.removeFirst();
    //         System.out.println(pair.num+" -> "+pair.bin);
    //         if(pair.num *2 <= val) queue.add(new Pair(pair.num*2,pair.bin+"0"));
    //         if(pair.num *2 + 1 <= val) queue.add(new Pair(pair.num*2+1,pair.bin+"1"));
    //     }
    // }
} //    20 true 10 true 40 true 5 false false false true 50 false false true 30 false true 90 true 1 false false false