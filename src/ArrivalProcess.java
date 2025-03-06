public class ArrivalProcess {
    int jobcounter;
    double arrivalRate; //Can change throughout the day, may be implemented in traffic project
    ExponentialDistribution exponentialdistribution = new ExponentialDistribution(arrivalRate);

    // constructor
    ArrivalProcess(double arrivalRate) {
        this.arrivalRate = arrivalRate;
    }

    public double getNextArrivalTime() { return exponentialdistribution.sample(); }
    public Job getNextJob(double currentTime) { return new Job(currentTime, jobcounter++); }
}
