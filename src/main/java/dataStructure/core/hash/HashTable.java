package dataStructure.core.hash;

import java.util.LinkedList;

public class HashTable {
    public class Node {
        String key;
        int value;
        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
        int value() {
            return value;
        }
        void value(int value){
            this.value = value;
        }
    }
    LinkedList<Node> [] data;
    public HashTable(int size){
        this.data = new LinkedList[size];
    }

    int getHash(String key){
        int hashCode = 0;
        for(char c : key.toCharArray()){
            hashCode += c;
        }
        return hashCode;
    }

    int getHashIndex(int hashcode){
        return hashcode % data.length;
    }
    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    //inserting
    public void insert(String key, int value){
        int hashCode = this.getHash(key);
        int index = this.getHashIndex(hashCode);
        LinkedList<Node> list = data[index];
        if(list == null){
            list = new LinkedList<Node>();
            data[index] = list;
        }
        Node node = searchKey(list, key);
        if(node == null){
            list.addLast(new Node(key, value));
        }else {
            node.value(value);
        }
    }
    public int get(String key){
        int hashcode = this.getHash(key);
        int index= this.getHashIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        return node == null? -1 : node.value();
    }
    //removing
}
