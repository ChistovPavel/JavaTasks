package Tasks;

import java.util.ArrayList;

/**
 * Класс, реализующий структуру данных очередь на основе {@link ArrayStack}
 * */
public class ArrayStackQueue<T> {

    ArrayStack<T> fwd;
    ArrayStack<T> bwd;

    /**
     * Конструктор класса по умолчанию
     * */
    public ArrayStackQueue()
    {
        this.fwd = new ArrayStack<T>();
        this.bwd = new ArrayStack<T>();
    }

    /**
     * Конструктор класса
     * @param list список значения для добавления в очередь
     * */
    public ArrayStackQueue(ArrayList<T> list)
    {
        this.fwd = new ArrayStack<T>();
        this.bwd = new ArrayStack<T>(list);
    }

    /**
     * Получение размера очереди
     * @return размер очереди
     * */
    public Integer getSize(){return this.fwd.getSize()+this.bwd.getSize();}

    /**
     * Получение значения из очереди без удаления
     * @return значение, которое было добавленно ранее сотальных
     * */
    public T get()
    {
        if (fwd.getSize() == 0) this.shift();
        return this.fwd.get();
    }

    /**
     * Получение значения из очереди с удалением
     * @return значение, которое было добавленно ранее сотальных
     * */
    public T pop()
    {
        if (fwd.getSize() == 0) this.shift();
        return this.fwd.pop();
    }

    /**
     * Добавление нового значения в очередь
     * @param value новое значение для добовления
     * */
    public void push(T value)
    {
        bwd.push(value);
    }

    /**
     * Копирование данных из одного stack'a в другой. Первый stack копируется во второй в обратном порядке.
     * */
    private void shift()
    {
        if (fwd.getSize() > 0)return;
        while(bwd.get() != null)
        {
            fwd.push(bwd.pop());
        }
    }
}
