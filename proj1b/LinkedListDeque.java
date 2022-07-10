public class LinkedListDeque<T> implements Deque<T> {
    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> front;
        Node(T i, Node<T> n, Node<T> f) {
            item = i;
            next = n;
            front = f;
        }
    }

    private Node<T> first;
    private Node<T> end;
    private int size;

    @Override
    public void addFirst(T item) {
        if (first != null) {
            first.front = new Node<>(item, first, null);
            first = first.front;
        } else {
            first = new Node<>(item, null, null);
            end = first;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        if (end != null) {
            end.next = new Node<>(item, null, end);
            end = end.next;
        } else {
            end = new Node<>(item, null, null);
            first = end;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> temp = first;
        for (int i = 0; i < size; ++i) {
            if (temp.next != null) {
                System.out.print(temp.item + " ");
            } else {
                System.out.print(temp.item);
            }
            temp = temp.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 1) {
            T a = first.item;
            first = null;
            end = null;
            size--;
            return a;
        } else if (size == 0) {
            return null;
        } else {
            size--;
            T a = first.item;
            first = first.next;
            first.front = null;
            return a;
        }
    }

    @Override
    public T removeLast() {
        if (size == 1) {
            T a = end.item;
            first = null;
            end = null;
            size--;
            return a;
        } else if (size == 0) {
            return null;
        } else {
            size--;
            T a = end.item;
            end = end.front;
            end.next = null;
            return a;
        }
    }

    @Override
    public T get(int index) {
        Node<T> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    public LinkedListDeque() {
        size = 0;
    }

    private T getRecursiveNode(int index, Node<T> iter) {
        if (index == 0) {
            return iter.item;
        }
        return getRecursiveNode(index - 1, iter.next);
    }
    public T getRecursive(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        } else {
            return getRecursiveNode(index, first);
        }
    }
}
