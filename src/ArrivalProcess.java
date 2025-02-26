public class ArrivalProcess {
    ExponentialDistribution distribution;
    int nextArrivalTime;

    public int generateArrivalTime(){
        //TODO: create an arrival time using exponential distribution, and return said arrival time as an int
    }

    public Job createJob(Customer customer, int arrivaltime) {
        Job job = new Job(arrivaltime, customer);
        return job;
    }
}
