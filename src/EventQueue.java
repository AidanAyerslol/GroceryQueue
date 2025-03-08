public class EventQueue extends Queue<Event> {

    @Override
    public void enqueue(Event newEvent) {
        QueueRecord newRecord = new QueueRecord(newEvent);
        if (head == null) {
            head = newRecord;
            current = newRecord;
            length++;
            return;
        }
        if ((head.value).getTime() > newEvent.getTime()) {
            newRecord.nextrecord = head;
            head = newRecord;
            length++;
            return;
        }

        QueueRecord currentRecord = head;
        while (currentRecord.nextrecord != null && (currentRecord.nextrecord.value).getTime() <= newEvent.getTime()) {
            currentRecord = currentRecord.nextrecord;
        }

        newRecord.nextrecord = currentRecord.nextrecord;
        currentRecord.nextrecord = newRecord;

        if (newRecord.nextrecord == null) {
            current = newRecord;
        }

        length++;
    }

    // To Test if the enqueue method is working fine
    public Event peekHead() {
        if (head == null) return null;
        return head.value;
    }
}
