package oct2021;

class Trie {
    Trie[] children;
    String word=null;
    public Trie() {
        children= new Trie[26];
    }

    public void insert(String word) {
        Trie node=this;
        for(char c: word.toCharArray()){
            if(node.children[c-'a'] ==null)
                node.children[c - 'a']=new Trie();
            node = node.children[c - 'a'];
        }
        node.word=word;
    }

    public boolean search(String word) {
        Trie root=this;
        for(char c: word.toCharArray()){
            root=root.children[c - 'a'];
            if(root ==null )
                return false;
        }
        return root.word== null ? false : word.equals(root.word);

    }

    public boolean startsWith(String prefix) {
        Trie root=this;
        for(char c: prefix.toCharArray()){
            root=root.children[c - 'a'];
            if(root ==null )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie= new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }
}
