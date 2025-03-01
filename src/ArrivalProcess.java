public class ArrivalProcess {
    int jobcounter;
    final double arrivalrate = 0.15; //Can change throughout the day, may be implemented in traffic project
    ExponentialDistribution exponentialdistribution = new ExponentialDistribution(arrivalrate);

    public double getNextArrivalTime() { return exponentialdistribution.sample(); }
    public Job getNextJob(double currentTime) { return new Job(currentTime, jobcounter++); }
}
