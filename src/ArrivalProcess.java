public class ArrivalProcess {
    private int jobcounter;
    private double arrivalRate;
    private ExponentialDistribution exponentialdistribution;

    // constructor
    ArrivalProcess(double arrivalRate) {
        this.arrivalRate = arrivalRate;
        exponentialdistribution = new ExponentialDistribution(arrivalRate);
    }

    public double getNextArrivalTime() { return exponentialdistribution.sample(); }
    public Job getNextJob(double currentTime) { return new Job(currentTime, jobcounter++); }
}
