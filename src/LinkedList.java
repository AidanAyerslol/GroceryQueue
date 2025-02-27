
public class LinkedList { //This function is mostly from my 201 database project, but redone to be generic. -C
    private class Node {
        Job job;
        Node next;

        public Node(Job data) {
            this.job = data;
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
    public void add(Job newdata) {
        Node newnode = new Node(newdata);

        //If (list is empty or newData should be at beginning)
        if(head == null) {
            newnode.next = head;
            head = newnode;
            return;
        }

        //Traverse to find correct insert point
        Node temp = head; 
        while(temp.next != null){
            temp = temp.next;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void initIteration() {
        current = head;
    }

    public Job next() {
        if(current == null) {
            return null;
        }

        Job data = current.job;
        current = current.next;
        return data;
    }
}
