class LRUCache {
    class node{
        int key;
        int value;
        node next;
        node prev;

        node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    node head= new node(-1,-1);
    node tail= new node(-1,-1);
    int cap;
    HashMap<Integer,node> map=new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    
    }
    
    public void add(node newNode){
        node temp= head.next;
        head.next=newNode;
        newNode.prev=head;
        newNode.next=temp;
        temp.prev=newNode;
    }

    public void delete(node deleteNode){
        node prevv=deleteNode.prev;
        node nextt=deleteNode.next;

        prevv.next=nextt;
        nextt.prev=prevv;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            node resNode=map.get(key);
            int value=resNode.key;

            map.remove(key);
            delete(resNode);
            add(resNode);

            map.put(key,head.next); 

            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node curr=map.get(key);
            map.remove(key);
            delete(curr);
        }

        if(map.size()==cap){
            map.remove(tail.prev.key);
            delete(tail.prev);
        }

        add(new node(key,value));
        map.put(key,head.next);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */