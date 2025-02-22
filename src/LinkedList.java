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
    public void add(T newdata) {
        Node newnode = new Node(newdata);

        //If (list is empty or newData should be at beginning)
        if(head == null || newdata.compareTo(head.data) < 0) {
            newnode.next = head;
            head = newnode;
            return;
        }

        //Traverse to find correct insert point
        Node temp = head;
        while(temp.next != null && newdata.compareTo(temp.next.data) >= 0) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
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
