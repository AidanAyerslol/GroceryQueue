public class Queue<T> {
    private class QueueRecord {
        public T value;
        public QueueRecord nextRecord;

        public QueueRecord(T value) {
            this.value = value; this.nextRecord = null;
        }
    }

    private int length;
    private QueueRecord head, current;

    public int getLength() { return length; }
    public boolean isQueueEmpty() { return (length == 0); }

    public Queue() {
        length = 0; head = null; current = null;
    }

    public void enqueue(T value) {
        QueueRecord newRecord = new QueueRecord(value);

        if(head == null) { head = newRecord; current = newRecord; }
        else { current.nextRecord = newRecord; current = newRecord; }
        length++;
    }

    public T dequeue() {
        QueueRecord returnRecord = head;
        if(head == null) { return null; }
        else if(current == head) { head = null; current = null; }
        else { head = head.nextRecord; }
        length--;
        return returnRecord.value;
    }
}