package tasks;

import java.util.ArrayList;

/**
 * Класс, реализующий структуру данных stack на основе {@link ArrayList}
 * */
public class ArrayStack<T> {

    private ArrayList<T> list;

    /**
     * Конструктор класса по умолчанию
     * */
    public ArrayStack() {
        this.list = new ArrayList<T>();
    }

    /**
     * Конструктор класса
     * @param inList список значения для добавления в stack
     * */
    public ArrayStack(ArrayList<T> inList) {
        this.list = new ArrayList<T>();
        this.list.addAll(inList);
    }

    /**
     * Получение размера stack
     * @return размер stack'а
     * */
    public Integer getSize() {return this.list.size();}

    /**
     * Добавление нового значения в stack
     * @param value новое значение для добовления
     * */
    public void push(T value) {this.list.add(value);}

    /**
     * Получение значения из stack без удаления
     * @return последнее добавленное значение
     * */
    public T get()
    {
        if (this.list.size() == 0) return null;
        else return this.list.get(this.list.size()-1);
    }

    /**
     * Получение значения из stack с удалением
     * @return последнее добавленное значение
     * */
    public T pop()
    {
        if (this.list.size() == 0) return null;
        T retValue = this.list.get(this.list.size()-1);
        this.list.remove(this.list.size()-1);
        return retValue;
    }
}
