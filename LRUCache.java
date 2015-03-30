/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingexcercise;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author yoli
 */
public class LRUCache {
    
    private static final ConcurrentMap<Integer, Integer> dict = new ConcurrentHashMap<>();
    private static final ConcurrentMap<Integer, Integer> count = new ConcurrentHashMap<>();
    private int capacity = 0;
    public LRUCache(int capacity)
    {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int ret = dict.getOrDefault(key, -1);
        if(ret != -1)
        {
            count.replace(key, count.get(key) + 1);
        }
        return ret;
    }
    
    public void set(int key, int value) {
        if(dict.size() < this.capacity)
        {
            if(dict.containsKey(key))
            {
                dict.replace(key, value);
                count.replace(key, count.get(key) + 1);
            }
            else
            {    
                dict.put(key, value);
                count.put(key, 0);
            }
        }
        else
        {
            // remove lru and then add the entry
            int min = Integer.MAX_VALUE;
            int k = -1;
            for(Map.Entry<Integer, Integer> me : count.entrySet())
            {
                int i = me.getValue();
                if(i <= 0)
                {
                    k = me.getKey();
                    break;
                }
                else if(i < min)
                {
                    k = me.getKey();
                }
            }
            dict.remove(k);
            dict.put(key, value);
            count.put(key, 0);
        }
    }
}
