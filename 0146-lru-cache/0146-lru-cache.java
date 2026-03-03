class LRUCache {

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insertNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.val=value;
            remove(node);
            insertNode(node);
        }else{
            if(map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode=new Node(key,value);
            map.put(key,newNode);
            insertNode(newNode);
        }
    }

    private void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void insertNode(Node node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */