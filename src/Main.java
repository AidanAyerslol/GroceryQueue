public class Main {
    public static void main(String[] args) {
    // setting simulation parameters
    int simulationEndTime = 560; // 9 hours * 60 minutes (we can change it later)
    double arrivalRate = 0.15; //  assume 0.15 arrivals per minute (1 arrival in every 6.67 minutes)
    double shoppingRate = 0.1; // assume average shopping time 10 minutes
    double checkoutRate = 0.02; // assume average checkout time 5 minutes

        Simulation simulation = new Simulation(simulationEndTime, arrivalRate, shoppingRate, checkoutRate);
        simulation.run();
    }
}
