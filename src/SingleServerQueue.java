public class SingleServerQueue {
    //Put queue here when ya do that
    private Job jobInService;
    private double nextEndServiceTime;
    private RandomDistribution serviceTimeDistribution;

    public SingleServerQueue(RandomDistribution serviceTimeDistribution) {
        this.serviceTimeDistribution = serviceTimeDistribution;
        jobInService = null;
        nextEndServiceTime = Double.MAX_VALUE;
    }

    public void add(Job job, double currentTime) {
        //TODO: If no other jobs are going on, jump to service right away. Otherwise, add to queue and schedule service time
    }

    public double getEndServiceTime() {
        //TODO: Return time that current job is estimated to end, or Double.MAX_VALUE if no job in service
        return nextEndServiceTime;
    }

    public Job complete(double currentTime) {
        //TODO: Complete job in service, record finish time, start next queued up job and update nextEndServiceTime
        return null;
    }
}
