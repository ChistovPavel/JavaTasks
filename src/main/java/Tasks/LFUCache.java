package Tasks;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache
{
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> weight;
    private HashMap<Integer, LinkedHashSet<Integer>> invertWeight;
    private int capacity;

    public LFUCache(int inCapacity)
    {
        this.map = new HashMap<Integer, Integer>(inCapacity+1, 1);
        this.weight = new HashMap<Integer, Integer>(inCapacity+1, 1);
        this.invertWeight = new HashMap<Integer, LinkedHashSet<Integer>>();
        this.capacity = inCapacity;
    }

    public int get(int key)
    {
        if (!map.containsKey(key))return -1;
        update(key);
        return map.get(key);
    }

    public void put(int key, int value)
    {
        if (capacity == 0) return;
        if (map.size() == capacity)
        {
            if (!map.containsKey(key))
            {
                int target = invertWeight.keySet().iterator().next();
                int oldKey = invertWeight.get(target).iterator().next();
                invertWeight.get(target).remove(oldKey);
                if (invertWeight.get(target).isEmpty())
                {
                    invertWeight.remove(target);
                }
                map.remove(oldKey);
                weight.remove(oldKey);
                addWeight(key);
            }
            else
            {
                update(key);
                map.remove(key);
            }
        }
        else
        {
            if (map.containsKey(key))
            {
                update(key);
                map.remove(key);
            }
            else
            {
                addWeight(key);
            }
        }
        map.put(key, value);
    }

    private void addWeight(int key)
    {
        weight.put(key, 1);
        if (!invertWeight.containsKey(1))
        {
            invertWeight.put(1, new LinkedHashSet<Integer>(capacity+1, 1));
        }
        invertWeight.get(1).add(key);
    }

    private void update(int key)
    {
        int weightValue = weight.get(key);
        if (invertWeight.get(weightValue).size() == 1)
        {
            invertWeight.remove(weightValue);
        }
        else
        {
            invertWeight.get(weightValue).remove(key);
        }
        if (!invertWeight.containsKey(weightValue+1))
        {
            invertWeight.put(weightValue+1, new LinkedHashSet<Integer>(capacity+1, 1));
        }
        invertWeight.get(weightValue+1).add(key);
        weight.put(key, weightValue+1);
    }
}
