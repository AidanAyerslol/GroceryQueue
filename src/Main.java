public class Main {
    public static void main(String[] args) {

        // setting simulation parameters
        int simulationRunTime = 560; // 9 hours * 60 minutes (we can change it later)
        double arrivalRate = 0.15; //  assume 0.15 arrivals per minute (1 arrival in every 6.67 minutes)
        double shoppingRate = 0.1; // assume average shopping time 10 minutes
        double checkoutRate = 0.02; // assume average checkout time 5 minutes

        //Initializing and running the simulation with and without the bagger
        Simulation noBaggerSim = new Simulation(simulationRunTime, arrivalRate, shoppingRate, checkoutRate, false); //No bagger present
        noBaggerSim.setup(); //Sets up the simulation by creating first arrival events
        noBaggerSim.run(simulationRunTime); //Run the simulation for a specified time
        noBaggerSim.process(); //Processes and displays results of Simulation


        Simulation baggerSim = new Simulation(simulationRunTime, arrivalRate, shoppingRate, checkoutRate, true); //bagger present
        baggerSim.setup(); //Sets up the simulation by creating first arrival events
        baggerSim.run(simulationRunTime); //Run the simulation for a specified time
        baggerSim.process(); //Processes and displays results of Simulation
    }
}

