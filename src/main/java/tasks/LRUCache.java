package tasks;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache
{
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> list;
    private Integer capacity;

    public LRUCache(int inCapacity) {
        this.map = new HashMap<Integer, Integer>(inCapacity+1, 1);
        this.list = new LinkedList<Integer>();
        this.capacity = inCapacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        list.remove((Object)key);
        list.addLast(key);
        return map.get(key);
    }

    public void put(int key, int value)
    {
        if (map.size() == capacity)
        {
            if (!map.containsKey(key))
            {
                map.remove(this.list.getFirst());
                list.removeFirst();
                list.addLast(key);
            }
            else
            {
                list.remove((Object)key);
                list.addLast(key);
            }
        }
        else
        {
            if (!map.containsKey(key))
            {
                list.addLast(key);
            }
            else
            {
                list.remove((Object)key);
                list.addLast(key);
            }
        }
        map.put(key, value);
    }
}