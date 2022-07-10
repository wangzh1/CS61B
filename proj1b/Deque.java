public interface Deque<T> {
    /** Add item to the first of the deque. */
    public void addFirst(T item);

    /** Add item to the last of the deque. */
    public void addLast(T item);

    /** If the deque is empty, return true. */
    public boolean isEmpty();

    /** Return the size of the deque. */
    public int size();

    /** Print the deque. */
    public void printDeque();

    /** Remove the last item of the deque. */
    public T removeFirst();

    /** Remove the last item of the deque. */
    public T removeLast();

    /** Get the item at the given index. */
    public T get(int index);

}
