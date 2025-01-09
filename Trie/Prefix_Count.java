// Remember a concept of making sure that count for a particular string will be in next node which is end of node

class Solution {
    class Node{
        Node links[];
        boolean isEnd;
        int prefixCount;

        Node(){
            links = new Node[26];
            isEnd = false;
            prefixCount = 0;
        }

        public boolean contains(char ch){
            return links[ch-'a'] != null;
        }
        public Node getNode(char ch){
            return links[ch-'a'];
        }
        public void setEnd(){
            isEnd = true;
        }
        public void put(char ch , Node node){
            links[ch-'a']  = node;
        }
        public boolean isEndOfWord() {
            return isEnd;
        }
        public void increasePrefix(){
            this.prefixCount++;
        }
    }
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        public void insert(String word){
            Node node = root;

            for(int i =0;i<word.length();i++){
                char curr = word.charAt(i);

                if(!node.contains(curr)){
                    node.put(curr , new Node());
                }
                node = node.getNode(curr);
                node.increasePrefix();
            }
            node.setEnd();
        }
       
        public int totalCount(String pref){
            Node node = root;

            for(int i = 0;i<pref.length();i++){
                char ch = pref.charAt(i);
                if(!node.contains(ch)){
                    return 0;
                }
                node = node.getNode(ch);
            }
            return node.prefixCount;
        }
    }
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();

        

        for(int i = 0;i<words.length;i++){
            trie.insert(words[i]);
        }

      return trie.totalCount(pref);
    }
}
