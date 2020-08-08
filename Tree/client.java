package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class client {
    public static void main(String[] args) {
     int n=9999;
    ArrayList<Integer> primeSet = getPrimeSet(n);
    System.out.println(primeSet);
    ArrayList<ArrayList<Integer>> graph = getGraph(primeSet);
    }
    
    private static ArrayList<ArrayList<Integer>> getGraph(ArrayList<Integer> primeSet) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<primeSet.size();i++){
            for(int j=i+1;j<primeSet.size();j++){
                if(compare(primeSet.get(i),primeSet.get(j))){
                    graph.
                    
                }
            }
        }
        return null;
    }

    private static ArrayList<Integer> getPrimeSet(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] notPrime  = new boolean[n+1];
        for(int p=2;p*p<=n;p++){
            if(notPrime[p]==false){
               for(int i=p*p;i<=n;i+=p){
                   notPrime[i] = true;
               }
            }
        }
        for(int i=1000;i<=n;i++){
            if(!notPrime[i]){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean compare(int num1, int num2) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        int countDigits=0;
        if(str1.charAt(0)==str2.charAt(0))
            countDigits++;
        if(str1.charAt(1)==str2.charAt(1))
            countDigits++;
        if(str1.charAt(2)==str2.charAt(2))
            countDigits++;
        if(str1.charAt(3)==str2.charAt(3))
            countDigits++;
        return countDigits==1;
    }
}
