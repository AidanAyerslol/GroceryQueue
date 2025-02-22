public class SingleServerQueue {
    //Put queue here when ya do that
    private Job jobinservice;
    private double nextendservicetime;
    private RandomDistribution servicetimedistribution;

    public SingleServerQueue(RandomDistribution serviceTimeDistribution) {
        this.servicetimedistribution = serviceTimeDistribution;
        jobinservice = null;
        nextendservicetime = Double.MAX_VALUE;
    }

    public void add(Job job, double currenttime) {
        //TODO: If no other jobs are going on, jump to service right away. Otherwise, add to queue and schedule service time
    }

    public double getEndServiceTime() {
        //TODO: Return time that current job is estimated to end, or Double.MAX_VALUE if no job in service
        return nextendservicetime;
    }

    public Job complete(double currentTime) {
        //TODO: Complete job in service, record finish time, start next queued up job and update nextEndServiceTime
        return null;
    }
}
