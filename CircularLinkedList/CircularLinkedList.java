interface LinkedList {
    int at(int index);

    void add(int value);

    void remove(int index);

    int size();
}

public class CircularLinkedList implements LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public int at(int index) {
        if (index < 0)
            return -1;

        Node target = head;

        for (int i = 0; i < index; i++) {
            target = next(target);
        }
        return target.value;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node current = head;
            int count = 0;
            while (count < this.size - 1) {
                current = current.next;
                count++;
                if (count > 0) {
                    next(current);
                }
            }
            newNode.next = head;
            current.next = newNode;
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size)
            return;

        if (index == 0) {
            head = head.next;
            tail.next = head;
            this.size--;
            return;
        }
        Node tarrget = head;
        Node current = head;
        for (int i = 0; i < index % this.size; i++) {
            current = tarrget;
            tarrget = next(tarrget);
        }
        current.next = tarrget.next;
        this.size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    private Node next(Node node) {
        System.out.println("Go to next node");
        return node.next;
    }
}