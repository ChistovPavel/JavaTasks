package tasks;

import java.util.LinkedHashMap;

public class LRUCacheN
{
    private LinkedHashMap<Integer, Integer> map;
    private Integer capacity;

    public LRUCacheN(int inCapacity) {
        this.map = new LinkedHashMap<Integer, Integer>(inCapacity+1, 1);
        this.capacity = inCapacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value)
    {
        if (map.size() == capacity)
        {
            if (!map.containsKey(key))
            {
                map.remove(map.keySet().iterator().next());
            }
            else
            {
                map.remove(key);
            }
        }
        else
        {
            if (map.containsKey(key))
            {
                map.remove(key);
            }
        }
        map.put(key, value);
    }
}