package Tasks;

import java.util.ArrayList;

public class NumberTasks {

    /**
     * Проверка числа на простоту
     * */
    public static boolean isPrime(Integer value)
    {
        for (int i = 2; i <= Math.sqrt(value); i++)
        {
            if (value % i == 0) return false;
        }
        return true;
    }

    /**
     * Проверка числа на палиндром
     * */
    public static boolean isPalindrome(Integer value)
    {
        int divider = 1, tmp = value;
        while (tmp > 10){
            tmp/=10;
            divider*=10;
        }

        tmp = value;
        while (tmp > 10)
        {
            if (tmp/divider != tmp%10)return false;
            tmp%=divider;
            tmp/=10;
            divider/=100;
        }
        return true;
    }

    /**
     * Получение числе Фибоначчи от 0 до bound
     * */
    public static ArrayList<Integer> getFibonacci(Integer bound)
    {
        int currentNumber = 1, lastNumber = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(lastNumber);
        list.add(currentNumber);

        while (list.get(list.size()-1)+list.get(list.size()-2) < bound)
        {
            list.add(list.get(list.size()-1)+list.get(list.size()-2));
        }
        return list;
    }
}
