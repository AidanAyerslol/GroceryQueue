public class ArrivalProcess {
    int jobcounter;
    double arrivalrate; //Can change throughout the day, may be implemented in traffic project
    ExponentialDistribution exponentialdistribution = new ExponentialDistribution(arrivalrate);

    // constructor
    ArrivalProcess(double arrivalrate) {
        this.arrivalrate = arrivalrate;
    }

    public double getNextArrivalTime() { return exponentialdistribution.sample(); }
    public Job getNextJob(double currentTime) { return new Job(currentTime, jobcounter++); }
}
