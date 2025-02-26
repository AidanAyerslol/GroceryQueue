public class SingleServerQueue {
    //Put queue here when ya do that
    private Job jobinservice;
    private int nextendservicetime;
    private RandomDistribution servicetimedistribution;

    private LinkedList checkoutline;

    }
    public SingleServerQueue(RandomDistribution serviceTimeDistribution) {
        this.servicetimedistribution = serviceTimeDistribution;
        jobinservice = null;
        nextendservicetime = 1000000000;
        checkoutline = new LinkedList();
    }

    public void add(Job job, double currenttime) {
        //TODO: If no other jobs are going on,generate a service time, and jump to service right away. Otherwise, add to queue and schedule service time
    }

    public double getEndServiceTime(RandomDistribution servicetimedistribution) {
        //TODO: Generate an end service time using normal distribution
        return nextendservicetime;
    }

    public Job complete(double currentTime) {
        //TODO: Complete job in service, record finish time, start next queued up job and run generate service time
        return null;
    }
}
