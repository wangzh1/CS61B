public class ArrayDeque<T> {
    private T[] aDeque;
    private int size;

    public void addFirst(T item) {
        T[] temp;
        if (aDeque.length == size) {
            temp = (T[]) new Object[size * 2];
        } else {
            temp = (T[]) new Object[aDeque.length];
        }
        System.arraycopy(aDeque, 0, temp, 1, size);
        temp[0] = item;
        aDeque = temp;
        ++size;
    }

    public void addLast(T item) {
        if (aDeque.length == size) {
            T[] temp = (T[]) new Object[size * 2];
            System.arraycopy(aDeque, 0, temp, 0, size);
            temp[size] = item;
            aDeque = temp;
        } else {
            aDeque[size] = item;
        }
        ++size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; ++i) {
            if (i != size - 1) {
                System.out.print(aDeque[i] + " ");
            } else {
                System.out.println(aDeque[i]);
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size <= aDeque.length / 4) {
            --size;
            T a = aDeque[0];
            T[] temp = (T[]) new Object[size];
            System.arraycopy(aDeque, 1, temp, 0, size);
            aDeque = temp;
            return a;
        } else {
            --size;
            T a = aDeque[0];
            T[] temp = (T[]) new Object[size];
            System.arraycopy(aDeque, 1, temp, 0, size);
            aDeque = temp;
            return a;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size <= aDeque.length / 4) {
            T a = aDeque[size - 1];
            --size;
            T[] temp = (T[]) new Object[size];
            System.arraycopy(aDeque, 0, temp, 0, size);
            aDeque = temp;
            return a;
        } else {
            --size;
            T a = aDeque[size - 1];
            T[] temp = (T[]) new Object[size];
            System.arraycopy(aDeque, 0, temp, 0, size);
            aDeque = temp;
            return a;
        }
    }

    public T get(int index) {
        return aDeque[index];
    }

    public ArrayDeque() {
        aDeque = (T[]) new Object[8];
        size = 0;
    }
}
