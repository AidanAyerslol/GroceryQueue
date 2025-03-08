public class Simulation {
    private double currentTime;
    private double simulationEndTime;
    private ArrivalProcess arrivalProcess;
    private SingleServerQueue singleServerQueue;
    private ExponentialDistribution shoppingTimeDistribution;
    private boolean bagger;

    // Simulation constructor
    public Simulation(double simulationEndTime, double arrivalRate, double shoppingRate, double checkoutRate, Boolean bagger) {
        this.simulationEndTime = simulationEndTime;
        this.currentTime = 0.0;
        this.bagger = bagger;

        // shopping time distribution
        this.shoppingTimeDistribution = new ExponentialDistribution(shoppingRate);
        this.arrivalProcess = new ArrivalProcess(arrivalRate); // initialize arrival process with arrival rate form main function
        this.singleServerQueue = new SingleServerQueue(checkoutRate, bagger); // initialize single server queue with checkout rate from main function

        // other initialization process ... to be done
    }

    // run method which starts the simulation
    public void run() {
        // run functionality: I am thinking of using priority queue to determine which even happens first,
        // also thinking of writing an Event class to record timing and state of the program for priority queue
    }
}