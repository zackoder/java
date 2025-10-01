public class DoubleLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    @Override
    public int at(int index) {
        if (index < 0 || index >= size)
            return -1;

        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node current = head;
            int counter = 0;
            while (counter < index) {
                current = current.next;
                counter++;
            }

            if (index > size / 2) {
                prev(current);
            } else {
                next(current);
            }

            return current.value;
        }
    }

    @Override
    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size)
            return;

        if (index == 0) {
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node current = head;
            int counter = 0;
            while (counter != index) {
                counter++;
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    /*
     * public void remove(int index) {
     * if (index < 0 || index >= size) return;
     * 
     * if (index == 0) {
     * head = head.next;
     * if (head != null) head.prev = null;
     * } else if (index == size - 1) {
     * tail = tail.prev;
     * if (tail != null) tail.next = null;
     * } else {
     * Node current = head;
     * int counter = 0;
     * while (counter < index) {
     * current = next(current);
     * counter++;
     * }
     * current.prev.next = current.next;
     * current.next.prev = current.prev;
     * }
     * size--;
     * }
     */

    @Override
    public int size() {
        return size;
    }

    private Node next(Node node) {
        System.out.println("Go to next node");
        return node.next; // ✅ fixed
    }

    private Node prev(Node node) {
        System.out.println("Go to previous node");
        return node.prev;
    }
}
