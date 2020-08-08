package trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private Map<Character, Trie> children;
    private boolean isEndOfWord;
    public Trie(){
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }

    void insert(String word){
        System.out.println("Inserting "+word);
        Trie curr = this;
        for(char c: word.toCharArray()){
            curr.children.putIfAbsent(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.isEndOfWord = true;
    }

    boolean search(String word){
        System.out.print("Searching "+word+"  ");
        Trie curr = this;
        for(char c: word.toCharArray()){
            curr = curr.children.get(c);
            if(curr==null){
                return false;
            }
    }
    return curr.isEndOfWord;
    }
    boolean startsWith(String prefix){
        System.out.print("StartsWith "+prefix+"  ");
        Trie curr = this;
        for(char c: prefix.toCharArray()){
            curr = curr.children.get(c);
            if(curr==null){
                return false;
            }
        }
        return true;
    }
}