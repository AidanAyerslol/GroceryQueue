public class Event implements Comparable<Event>{
    public enum EventType {ARRIVAL, AISLE_DEPARTURE, CHECKOUT_DEPARTURE}

    private EventType type;
    private double time;
    private Job job;

    public Event(EventType type, double time, Job job) {
        this.type = type;
        this.time = time;
        this.job = job;
    }

    public EventType getType() { return  type; }
    public double getTime() { return time; }
    public Job getJob() { return job; }

    // to compare the timing of two different events in timeline
    @Override
    public int compareTo(Event other) {
        return Double.compare(this.time, other.time); // compare function returns int values, either -1, 0, or 1
    }

    @Override
    public String toString() {
        return "Event(" + type + ", time = " + time + ", job = " + job + ")";
    }
}
