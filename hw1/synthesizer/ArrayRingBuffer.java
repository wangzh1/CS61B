package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.first = 0;
        this.last = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        if (capacity != 1 && fillCount == 0) {
            first = 1;
        }
        if (last == capacity - 1) {
            rb[0] = x;
            last = 0;
        } else {
            rb[last + 1] = x;
            last += 1;
        }
        fillCount += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T temp = rb[first];
        rb[first] = null;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first += 1;
        }
        fillCount -= 1;
        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new BufferIter();
    }

    public class BufferIter implements Iterator<T> {
        private int ptr;
        public BufferIter() {
            ptr = first;
        }
        public boolean hasNext() {
            if (last == capacity - 1) {
                return ptr != 0;
            } else {
                return ptr != (last + 1);
            }
        }
        public T next() {
            T returnItem = rb[ptr];
            if (ptr == capacity - 1) {
                ptr = 0;
            } else {
                ptr += 1;
            }
            return returnItem;
        }
    }
}
