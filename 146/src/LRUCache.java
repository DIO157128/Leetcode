import java.util.HashMap;

public class LRUCache {
    class DoubleLinkedNode{
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        public DoubleLinkedNode(){}
        public DoubleLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    int size;
    HashMap<Integer,DoubleLinkedNode> cache = new HashMap<>();
    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    public LRUCache(int capacity){
        this.size = 0;
        this.capacity=capacity;
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        DoubleLinkedNode node = cache.get(key);
        if(node==null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    public void put(int key,int value){
        DoubleLinkedNode node = cache.get(key);
        if(node==null){
            DoubleLinkedNode newNode = new DoubleLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                DoubleLinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);
        }
    }
    public void addToHead(DoubleLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    public void removeNode(DoubleLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addToHead(node);
    }
    public DoubleLinkedNode removeTail(){
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
