import java.util.Arrays;

/**
 * @param <T>
 * @author aymen
 * @version 0.9
 */
@SuppressWarnings("unused")
public class DynamicArray<T> {

    /**
     * The default initial capacity of the dynamic array.
     */
    private static final int DEFAULT_CAPACITY = 20;
    /**
     * The factor by which the array's capacity is increased when it is full.
     */
    private static final double GROWTH_FACTOR = 2.0;

    /**
     * The array to store the elements.
     */
    private T[] data;
    /**
     * The current capacity of the array.
     */
    private int capacity;

    /**
     * The number of elements currently stored in the array.
     */
    private int counter;

    /**
     * Constructs an empty dynamic array with the default initial capacity.
     */

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty dynamic array with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the array
     */
    public DynamicArray(int initialCapacity) {
        capacity = initialCapacity;
        data = (T[]) new Object[capacity];
        counter = 0;
    }

    /**
     * Returns the number of elements currently stored in the array.
     *
     * @return the number of elements in the array
     */
    public int size() {
        return counter;
    }


    /**
     * Checks if the array is empty.
     *
     * @return {@code true} if the array contains no elements, {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Ensures that the array has enough capacity to store new elements.
     * If the array is full, its capacity is increased by the growth factor.
     */
    private void ensureCapacity() {
        if (counter >= capacity) {
            capacity = (int) (capacity * GROWTH_FACTOR);
            data = Arrays.copyOf(data, capacity);
        }
    }

    /**
     * Inserts the specified element at the end of the array.
     *
     * @param element the element to be inserted
     */
    public void insert(T element) {
        ensureCapacity();
        data[counter++] = element;
    }

    /**
     * Returns the element at the specified position in the array.
     *
     * @param index the index of the element to return
     * @return the element at the specified position
     */
    public T get(int index) {
        return data[index];
    }

    /**
     * Returns a string representation of the array.
     *
     * @return a string representation of the array
     */
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
