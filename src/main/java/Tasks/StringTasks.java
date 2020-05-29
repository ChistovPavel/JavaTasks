package Tasks;

import java.util.HashMap;
import java.util.Iterator;

public class StringTasks {

    /**
     * Переворачивание строки
     * */
    public static String reverseString(String str)
    {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    /**
     * Изменение порядка слов в строке
     * */
    public static String reverseStringParts(String str)
    {
        char[] array = str.toCharArray();

        int index = 0, newIndex;
        while (true)
        {
            newIndex = str.indexOf(" ", index);
            if (newIndex == -1)
            {
                reverse(index, str.length(), array);
                break;
            }
            reverse(index, newIndex, array);
            index = newIndex+1;
        }

        reverse(0, str.length(), array);

        return String.valueOf(array);
    }

    /**
     * Ручное переворачивание строки
     * */
    public static void reverse( int start, int end, char[] array)
    {
        for (int i = start; i < start+((end-start)/2); i++)
        {
            array[i]^=array[start+end-1-i];
            array[start+end-1-i]^=array[i];
            array[i]^=array[start+end-1-i];
        }
    }

    /**
     * Проверка строки на палиндроом
     * */
    public static boolean isPalindrome(String value)
    {
        StringBuilder sb = new StringBuilder(value);
        if (sb.reverse().toString().equals(value))return true;
        return false;
    }

    /**
     * Получение всех дуюлирующихся символов
     * */
    public static HashMap<Character, Integer> getDuplicateCharacters(String str)
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++)
        {
            if (map.containsKey(str.charAt(i)))map.put(str.charAt(i), map.get(str.charAt(i))+1);
            else map.put(str.charAt(i), 1);
        }

        for (Iterator<Character> iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            Character key = iterator.next();
            if (map.get(key) == 1)
            {
                iterator.remove();
                map.remove(key);
            }
        }

        return map;
    }
}
