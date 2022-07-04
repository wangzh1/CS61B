public class LinkedListDeque <T>{
    public static class Node <T> {
        T item;
        Node<T> next;
        Node<T> front;
        Node(T i, Node<T> n, Node<T> f) {
            item = i;
            next = n;
            front = f;
        }
    }

    public Node<T> first;
    public Node<T> end;
    public int size;

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

    public void addLast(T item) {
        if (end != null) {
            end.next = new Node<>(item, null, end);
            end = end.next;
        } else {
            end = new Node<>(item, null,null);
            first = end;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> temp = first;
        for (int i = 0; i < size; ++i) {
            if (temp.next != null) System.out.print(temp.item + " ");
            else System.out.println(temp.item);
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (size == 1) {
            first = null;
            end = null;
            size--;
            return null;
        } else {
            size--;
            first = first.next;
            first.front = null;
            return first.item;
        }
    }

    public T removeLast() {
        if (size == 1) {
            first = null;
            end = null;
            size--;
            return null;
        } else {
            size--;
            end = end.front;
            end.next = null;
            return end.item;
        }
    }

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

    public T getRecursive_Node(int index, Node<T> iter) {
        if (index == 0) return iter.item;
        return getRecursive_Node(index - 1, iter.next);
    }
    public T getRecursive(int index) {
        if (size == 0 || index < 0 || index >= size) return null;
        else return getRecursive_Node(index, first);
    }
}
