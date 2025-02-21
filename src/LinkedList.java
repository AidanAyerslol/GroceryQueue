public class LinkedList<T extends Comparable<T>> { //This function is mostly from my 201 database project, but redone to be generic. -C
    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node current;

    public LinkedList() {
        head = null;
        current = null;
    }

    //Sorted insert
    public void add(T newData) {
        Node newNode = new Node(newData);

        //If (list is empty or newData should be at beginning)
        if(head == null || newData.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        //Traverse to find correct insert point
        Node temp = head;
        while(temp.next != null && newData.compareTo(temp.next.data) >= 0) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void initIteration() {
        current = head;
    }

    public T next() {
        if(current == null) {
            return null;
        }

        T data = current.data;
        current = current.next;
        return data;
    }
}
