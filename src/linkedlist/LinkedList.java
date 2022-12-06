package linkedlist;

public class LinkedList<T> {

    private Node<T> root;

    public void add(T data) {
        Node<T> newElement = new Node<>(data);

        if (root != null) {
            root.add(newElement);
        } else {
            root = newElement;
        }
    }

    public T get(int index) {
        if (root == null) {
            throw new NullPointerException();
        } else if (index == 0) {
            return root.data;
        } else {
            return root.get(index);
        }
    }

    public void remove(int removeIndex) {
        if (removeIndex == 0) {
            root = root.next;
        } else {
            root.remove(0, removeIndex);
        }
    }

    public boolean contains(T d) {
        if (root == null) {
            return false;
        } else if (root.data == d) {
            return true;
        } else {
            return root.contains(d);
        }
    }

    public void removeDuplications() {
        Node<T> n = root;
        Node<T> m = n;
        while (n.next != null) {
            m = n;
            while (m.next != null) {
                if (n.data == m.next.data) {
                    m.next = m.next.next;
                } else {
                    m = m.next;
                }
            }
            n = n.next;
        }
    }

    @Override
    public String toString() {
        return root + "";
    }

}










