package tasks;

import java.util.*;

public class CollectionTasks {

    /**
     * получение количества заданного слова в строке
     * */
    public static Integer getWordCount(String src, String target)
    {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String[] array = src.split(" ");

        for (int i = 0; i < array.length; i++)
        {
            if (map.containsKey(array[i]))map.put(array[i], map.get(array[i])+1);
            else map.put(array[i], 1);
        }

        return map.get(target);
    }

    /**
     * Пример итерация HashMap
     * */
    public static void hashMapIteration(HashMap<String, Integer> map)
    {
        System.out.println("while iteration: ");

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext())
        {
            String key = iterator.next();
            System.out.println(new StringBuilder("key: ")
                    .append(key)
                    .append("\tvalue: ")
                    .append(map.get(key)).toString());
        }

        System.out.println("for iteration: ");

        for (String key : map.keySet())
        {
            System.out.println(new StringBuilder("key: ")
                    .append(key)
                    .append("\tvalue: ")
                    .append(map.get(key)).toString());
        }
    }

    /**
     * Пример итерации ArrayList
     * */
    public static void arrayListIteration(ArrayList<Integer> list)
    {
        System.out.println("while iteration: ");

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext())
        {
            Integer value = iterator.next();
            System.out.println(new StringBuilder("value: ")
                    .append(value).toString());
        }

        System.out.println("for iteration: ");

        for (Integer i : list)
        {
            System.out.println(new StringBuilder("value: ")
                    .append(i).toString());
        }

        System.out.println("advanced for iteration: ");

        for (Iterator<Integer> i = list.iterator(); i.hasNext();)
        {
            System.out.println(new StringBuilder("value: ")
                    .append(i.next()).toString());
        }
    }

    /**
     * Получение второго по величине числа массива
     * */
    public static Integer getSecondMax(Integer[] array)
    {
        if (array.length == 0) return null;
        if (array.length == 1) return array[0];
        if (array.length == 2) return array[0] > array[1] ? array[1] : array[0];
        else
        {
            int first, second;
            if (array[0] > array[1])
            {
                first = array[0];
                second = array[1];
            }
            else
            {
                first = array[1];
                second = array[0];
            }

            for (int i = 2; i < array.length; i++)
            {
                if (array[i] > first)
                {
                    second = first;
                    first = array[i];
                }
                else if (array[i] > second && array[i] < first) second = array[i];
            }
            return second;
        }
    }

    /**
     * Переворачивание списка итерационно
     * */
    public static void reverseIteratively(LinkedList<Integer> list)
    {
        ListIterator<Integer> fwd = list.listIterator();
        ListIterator<Integer> bwd = list.listIterator(list.size());

        for (int i = 0; i < list.size()>>1; i++)
        {
            Integer tmp = fwd.next();
            fwd.set(bwd.previous());
            bwd.set(tmp);
        }
    }

    /**
     * Метод рекурсии для переворачивания списка
     * */
    private static void recursion(ListIterator<Integer> fwd, ListIterator<Integer> bwd)
    {
        if (fwd.nextIndex() >= bwd.nextIndex())return;
        else
        {
            Integer tmp = fwd.next();
            fwd.set(bwd.previous());
            bwd.set(tmp);
            recursion(fwd, bwd);
        }
    }

    /**
     * Переворачивание списка рекурсивно
     * */
    public static void reverseRecursively(LinkedList<Integer> list)
    {
        ListIterator<Integer> fwd = list.listIterator();
        ListIterator<Integer> bwd = list.listIterator(list.size());

        recursion(fwd, bwd);
    }
}
