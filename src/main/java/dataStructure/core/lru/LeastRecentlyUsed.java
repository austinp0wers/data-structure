package dataStructure.core.lru;

import dataStructure.core.list.DoublyLinkedNode;
import org.springframework.cache.Cache;

import java.util.HashMap;

public class LeastRecentlyUsed {
    CacheItem head;
    CacheItem tail;
    HashMap<Integer, CacheItem>map;
    int capacity;
    public LeastRecentlyUsed(int capacity){
        this.head = null;
        this.tail = null;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        if(!map.containsKey(key)) {
            return -1;
        }else{
            CacheItem cur = map.get(key);
            // move to head
            if(cur != head ){
                if(cur== tail){
                    tail = tail.prev;
                }
            }
            if(cur.prev!=null) cur.prev.next = cur.next;
            if(cur.next!=null) cur.next.prev = cur.prev;
            cur.next = head;
            head.prev = cur;
            head = cur;
            return cur.value;
        }
    }

    public void put(int key, int value){
        if(get(key)==-1){
            CacheItem cur = new CacheItem(key, value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.next = head;
                head.prev = cur;
                head = cur;
            }
            // move to head
            map.put(key, cur);
            if(map.size() > capacity){
                System.out.println("SIZE OVER!! ");
                //delete cache item at tail
                map.remove(tail.key);
                tail.prev.next = null;
                tail.prev = null;
                tail.prev = tail;
            }
        }else{
            // no need to delete, just add at front
            CacheItem cur = map.get(key);

            cur.next = head;
            head.prev = cur;
            head = cur;
            cur.prev = null;
        }
    }
}
