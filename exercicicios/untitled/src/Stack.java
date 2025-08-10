import java.util.ArrayList;
import java.util.Iterator;

public class Stack <T> implements Iterable<T>{
    private ArrayList<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        return items.remove(items.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return items.size() > count;
            }

            @Override
            public T next() {
                T item  = items.get(items.size() - 1  - count);
                count++;
                return item;
            }
        };
    }
}
