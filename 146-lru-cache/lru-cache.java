class LRUCache {
    private Map<Integer, DoublyLinkedList> keys;
    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int currSize;
    private int capacity;

    public LRUCache(int capacity) {
        this.keys = new HashMap<>();
        this.head = new DoublyLinkedList();
        this.tail = new DoublyLinkedList();
        head.next = tail;
        tail.previous = head;
        this.currSize = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        //System.out.println("get key=" + key);
        if (!keys.containsKey(key)) {
            return -1;
        }
        DoublyLinkedList entry = keys.get(key);
        removeEntry(entry);
        addEntry(entry);
        return entry.value;
    }
    
    public void put(int key, int value) {
        //System.out.println("put key=" + key + ", value=" + value);
        if (keys.containsKey(key)) {
            DoublyLinkedList entry = keys.get(key);
            entry.value = value;
            removeEntry(entry);
            addEntry(entry);
        } else {
            if (currSize == capacity) {
                DoublyLinkedList first = head.next;
                removeEntry(first);
            }

            DoublyLinkedList entry = new DoublyLinkedList();
            entry.key = key;
            entry.value = value;
            addEntry(entry);
        }
    }

    private void removeEntry(DoublyLinkedList entry) {
        entry.previous.next = entry.next;
        entry.next.previous = entry.previous;
        
        entry.previous = null;
        entry.next = null;

        keys.remove(entry.key);

        currSize--;
    }

    private void addEntry(DoublyLinkedList entry) {
        DoublyLinkedList last = tail.previous;

        last.next = entry;
        tail.previous = entry;

        entry.previous = last;
        entry.next = tail;

        keys.put(entry.key, entry);

        currSize++;
    }

    private static class DoublyLinkedList {
        private DoublyLinkedList previous;
        private DoublyLinkedList next;
        private int key;
        private int value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */