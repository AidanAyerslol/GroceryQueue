public class ArrivalProcess {
    int jobCounter;
    final double arrivalRate = 0.15; //Can change throughout the day, may be implemented in traffic project
    ExponentialDistribution exponentialDistribution = new ExponentialDistribution(arrivalRate);

    public double getNextArrivalTime() { return exponentialDistribution.sample(); }
    public Job getNextJob(double currentTime) { return new Job(currentTime, jobCounter++); }
}
