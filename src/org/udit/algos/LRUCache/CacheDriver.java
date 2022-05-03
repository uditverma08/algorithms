package org.udit.algos.LRUCache;

import java.util.Map;

public class CacheDriver {

    public static void showCache(Map<String, Node> cache){

        for(Map.Entry<String, Node> entry : cache.entrySet()){
            System.out.print(entry.getKey() + ": ");
            System.out.print(entry.getValue().getValue());
            System.out.println();
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(4);

        cache.put("udit", "engineer"); // 4, 1, 2
        cache.put("ram", "doctor"); // 3, 1, 2, 3
        cache.put("shiv", "advocate"); // 2, 3, 4, x
        cache.put("adi", "dancer"); // 1, 2, 3, 4

        showCache(cache.map);
        cache.get("udit");
        cache.get("ram");
        cache.put("kishan", "singer"); // 1
        showCache(cache.map);
        cache.put("neha", "lawyer");
        cache.put("arti", "student");
        showCache(cache.map);
    }
}
