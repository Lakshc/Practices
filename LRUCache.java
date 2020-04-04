/*
*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
*get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
*put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*The cache is initialized with a positive capacity.
*Follow up:
*Could you do both operations in O(1) time complexity?
**/

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer,Node> map=new HashMap<Integer,Node>();
        int capacity;
        Node head=new Node(0,0);
        Node tail=new Node(0,0);
        public LRUCache(int c) {
            capacity=c;
             head.prev=null;
            head.next=tail;
            tail.prev=head;
            tail.next=null;
        }
        
        public int get(int key) {
            Integer k=new Integer(key);
            if(map.containsKey(k)){
                Node n=map.get(k);
                int result=n.value;
                deleteNode(n);
                addtoHead(n);
                return result;
            }
            else return -1;
            
        }
        
        public void put(int key, int value) {
            Integer k=new Integer(key);
            if(map.containsKey(k)){
                Node cur=map.get(k);
                deleteNode(cur);
                cur.value=value;
                addtoHead(cur);            
                map.put(k,cur);
            }
            else{
                if(map.size()==capacity){
                    map.remove(tail.prev.key);
                    deleteNode(tail.prev);                    
                    Node latest=new Node(key,value);
                    addtoHead(latest);
                    map.put(k,latest);
                }
                else{
                    Node latest=new Node(key,value);
                    addtoHead(latest);
                    map.put(k,latest);
                }
            }
            
        }
        
        
        class Node{
            int key;
            int value;
            Node prev;
            Node next;
            public Node(int k,int v){
                key=k;
                value=v;
                next=null;
            }
        }
        public void addtoHead(Node n){
            n.next=head.next;
            n.next.prev=n;
            n.prev=head;
            head.next=n;
            
        }
        public void deleteNode(Node n){
            n.next.prev=n.prev;
            n.prev.next=n.next;        
        }
        

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1,1);
        lRUCache.put(2,2);
        lRUCache.get(1);
        lRUCache.put(3,3);
        lRUCache.get(2);
        lRUCache.put(4,4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
        
    }
}
