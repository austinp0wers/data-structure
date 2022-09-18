package dataStructure.core.lru;

public class CacheItem {
    int key;
    int value;
    CacheItem prev;
    CacheItem next;
    public CacheItem(int key, int value){
        this.key = key;
        this.value = value;
    }
}
