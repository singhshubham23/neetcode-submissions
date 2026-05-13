class LRUCache {
     class Node{
            int key, value;
            Node prev, next;
            Node(int k, int v){
                this.key = k;
                this.value = v;
            }
        }
    private final int capacity;
    private final Map<Integer, Node>map;
    private final Node head, tail;

    public LRUCache(int capacity) {
       this.capacity = capacity;
       this.map = new HashMap<>();

       head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
           Node old = map.get(key);
           remove(old);
           map.remove(key);
        }

        if(map.size() == capacity){
            Node lru = tail.prev;
            map.remove(lru.key);
            remove(lru);
        }
        Node newNode = new Node(key, value);
        insertAtHead(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
