public class Queue<T> {
    protected class QueueRecord {
        public T value;
        public QueueRecord nextrecord;

        public QueueRecord(T value) {
            this.value = value; this.nextrecord = null;
        }
    }

    protected int length;
    protected QueueRecord head, current;

    public int getLength() { return length; }
    public boolean isQueueEmpty() { return (length == 0); }

    public Queue() {
        length = 0; head = null; current = null;
    }

    public void enqueue(T value) {
        QueueRecord newrecord = new QueueRecord(value);

        if(head == null) { head = newrecord; current = newrecord; }
        else { current.nextrecord = newrecord; current = newrecord; }
        length++;
    }

    public T dequeue() {
        QueueRecord returnrecord = head;
        if(head == null) { return null; }
        else if(current == head) { head = null; current = null; }
        else { head = head.nextrecord; }
        length--;
        return returnrecord.value;
    }
}