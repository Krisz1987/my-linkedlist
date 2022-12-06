package linkedlist;

public class Node<T> {

    Node<T> next = null;
    T data;

    public Node(T d) {
        data = d;
    }

    public void add(Node<T> newElement) {
        if (next != null) {
            next.add(newElement);
        } else {
            next = newElement;
        }
    }

    public T get(int index) {
        if (next != null && index > 0) {
            index--;
            return next.get(index);
        } else if (index == 0) {
            return this.data;
        } else {
            throw new IndexOutOfBoundsException("The index is too big!");
        }
    }

    public void remove(int counter, int removeIndex) {
        if (counter + 1 == removeIndex) {
            this.next = this.next.next;
        } else if (this.next != null) {
            this.next.remove(counter + 1, removeIndex);
        }
    }

    public boolean contains(T d) {
        if (this.data == d) {
            return true;
        } else if (this.next != null) {
            return next.contains(d);
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + data + (next != null ? ", " + next : "");
    }
}
