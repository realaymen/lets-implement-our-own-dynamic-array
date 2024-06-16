import java.util.Arrays;

@SuppressWarnings("unused")
public class DynamicArray<T> {
    private static final int DEFAULT_CAPACITY = 20;
    private static final double GROWTH_FACTOR = 2.0;

    private T[] data;
    private int capacity;
    private int counter;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        capacity = initialCapacity;
        data = (T[]) new Object[capacity];
        counter = 0;
    }

    public int size() {
        return counter;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void ensureCapacity() {
        if (counter >= capacity) {
            capacity = (int) (capacity * GROWTH_FACTOR);
            data = Arrays.copyOf(data, capacity);
        }
    }

    public void insert(T element) {
        ensureCapacity();
        data[counter++] = element;
    }

    public T get(int index) {
        return data[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < counter; i++) {
            sb.append(data[i]);
            if (i < counter - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
