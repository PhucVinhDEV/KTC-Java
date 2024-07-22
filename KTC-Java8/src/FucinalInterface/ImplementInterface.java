package FucinalInterface;

import java.util.ArrayList;
import java.util.List;

public class ImplementInterface<T> implements InterfaceTest<T>{
    private List<T> items = new ArrayList<T>();
    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }
}
