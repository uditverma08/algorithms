package org.udit.algos.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public Map<String, Node> map;
    private final Integer capacity;

    private Node head = null;
    private Node tail = null;

    public LRUCache(Integer capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public String get(String key) {
        if(!map.containsKey(key))
            return "cache miss!";

        Node valueNode = map.get(key);

        deleteFromList(valueNode);
        addToListHead(valueNode);

        return valueNode.getValue();
    }

    public void put(String key, String value) {

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.setValue(value);

            deleteFromList(node);
            addToListHead(node);
        }
        else {
            if(map.size() >= capacity) {
                map.remove(tail.getKey());
                deleteFromList(tail);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            addToListHead(node);
        }
    }

    private void deleteFromList(Node node) {

        if(head == null || node == null)
            return;

        Node curr = head;
        while(curr != node && curr != tail) {
            curr = curr.getNext();
        }

        if(curr == tail) {
            tail = curr.getPrev();
        }
        else if(curr == head){
            head = curr.getNext();
        }
        else {
            curr.getNext().setPrev(curr.getPrev());
            curr.getPrev().setNext(curr.getNext());
        }
    }

    private void addToListHead(Node node) {

        if(head == null)
            tail = node;
        else {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
    }
}
