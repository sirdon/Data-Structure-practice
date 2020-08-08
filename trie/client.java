package trie;
public class client {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("apple");
        System.out.println(tr.search("apple"));
        System.out.println(tr.search("app"));
        System.out.println(tr.startsWith("app"));
        tr.insert("app");
        System.out.println(tr.search("app"));
    }
}