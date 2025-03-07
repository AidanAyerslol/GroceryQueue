public class SingleServerQueue {
    private Queue<Job> queue;
    private Job jobinservice;
    private double nextendservicetime;
    private double checkoutRate;
    private ExponentialDistribution servicetimedistribution;

    public SingleServerQueue(double checkoutRate) {
        queue = new Queue<Job>();
        jobinservice = null;
        nextendservicetime = Double.MAX_VALUE;
        this.checkoutRate = checkoutRate;
        servicetimedistribution = new ExponentialDistribution(checkoutRate);
    }

    public int getLength() { return queue.getLength(); }

    public void add(Job job, double currenttime) {
        if(jobinservice == null) { jobinservice = job; nextendservicetime = (currenttime + servicetimedistribution.sample()); }
        else { queue.enqueue(job); }
    }

    public double getEndServiceTime() {
        return nextendservicetime;
    }

    public Job complete(double currentTime) {
        Job jobtocomplete = jobinservice;
        jobtocomplete.completed(currentTime);
        if(queue.isQueueEmpty()) { jobinservice = null; nextendservicetime = Double.MAX_VALUE; }
        else { jobinservice = queue.dequeue(); nextendservicetime = currentTime + servicetimedistribution.sample(); }
        return jobtocomplete;
    }
}