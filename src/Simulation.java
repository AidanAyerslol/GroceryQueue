public class Simulation {
    private double currentTime;
    private double simulationRunTime;
    private ArrivalProcess arrivalProcess;
    private SingleServerQueue singleServerQueue;
    private ExponentialDistribution shoppingTimeDistribution;
    private int completedJobs = 0;  // Track total completed jobs
    private double totalJobCompletionTime = 0.0;  // Track total time spent on completed jobs
    private double AverageJobCompletionTime = 0.0; // Track average time it takes to complete a job
    private boolean bagger; // Whether there is or isn't a bagger present

    // Simulation constructor
    public Simulation(double simulationEndTime, double arrivalRate, double shoppingRate, double checkoutRate, Boolean bagger) {
        this.simulationRunTime = simulationEndTime;
        this.currentTime = 0.0;
        this.bagger = bagger;

        // shopping time distribution
        this.shoppingTimeDistribution = new ExponentialDistribution(shoppingRate);
        this.arrivalProcess = new ArrivalProcess(arrivalRate); // initialize arrival process with arrival rate form main function
        this.singleServerQueue = new SingleServerQueue(checkoutRate, bagger); // initialize single server queue with checkout rate from main function

        // other initialization process ... to be done
    }


    //TODO -- START REVIEW HERE -- TODO//

    // Setup simulation (initialize any other state if necessary)
    public void setup() {
        // Schedule the first arrival event
        scheduleNextArrival();
    }

    // Run the simulation for the given length of time
    public void run(double simulationLength) {
        // Start the simulation loop
        while (currentTime < simulationLength) {
            // Get the next event to process (arrival or departure)
            startNextEvent();
        }
    }

    // Process the next event based on the current simulation time
    private void startNextEvent() {
        // Handle arrival event
        if (isArrivalTime()) {
            processArrival();
        }
        // Handle departure event
        else if (isDepartureTime()) {
            processDeparture();
        }
    }

    // Determine if we should process an arrival event
    private boolean isArrivalTime() {
        return currentTime + arrivalProcess.getNextArrivalTime() <= simulationRunTime;
    }

    // Determine if we should process a departure event
    private boolean isDepartureTime() {
        return singleServerQueue.getLength() > 0;
    }

    // Handle arrival event
    private void processArrival() {
        // Get the next job from the arrival process
        Job newJob = arrivalProcess.getNextJob(currentTime);

        System.out.println("New Job Arrived at " + currentTime); //TODO REMOVE AFTER TEST

        // If there's no job in service, start servicing this job immediately
        if (singleServerQueue.getLength() == 0) {
            singleServerQueue.add(newJob, currentTime);
            scheduleNextDeparture(newJob); // Schedule the departure for this job
        } else {
            // Add the job to the queue if the server is busy
            singleServerQueue.add(newJob, currentTime);
        }

        // Schedule the next arrival
        scheduleNextArrival();
    }

    // Handle departure event (job completion)
    private void processDeparture() {
        // Complete the current job
        Job completedJob = singleServerQueue.complete(currentTime);
        completedJob.completed(currentTime);  // Mark the job as completed

        //Updates the job and related time count
        completedJobs++;
        totalJobCompletionTime += (completedJob.getEndTime() - completedJob.getTimeOfCreation());
        System.out.println("Job Completed at " + currentTime); //TODO REMOVE AFTER TEST

        // Update the average job completion time
        if (completedJobs > 0) {
            AverageJobCompletionTime = totalJobCompletionTime / completedJobs;
        }
    }

    // Schedule the next arrival event based on the arrival rate
    private void scheduleNextArrival() {
        currentTime += arrivalProcess.getNextArrivalTime();
    }

    // Schedule a departure event for the next job in the queue
    private void scheduleNextDeparture(Job job) {
        double departureTime = currentTime + singleServerQueue.getEndServiceTime();
        currentTime = departureTime;  // Update the current time to the departure time
    }

    //TODO -- END REVIEW HERE -- TODO//

    // Process and display the results of the simulation (metrics)
    public void process() {
        System.out.println("\nSimulation complete.");
        System.out.println("Total simulation time: " + getTotalTime() + " minutes.");
        if (bagger) {
            System.out.println("Bagger present: Yes");
        } else {
            System.out.println("Bagger present: No");
        }
        System.out.println("Total jobs completed: " + getCompletedJobs());
        System.out.println("Average job completion time: " + getAverageJobCompletionTime() + " minutes.\n");
        //TODO Display REST OF Simulation Information
    }

    // Return total time the simulation ran for
    private double getTotalTime() {
        return simulationRunTime;
    }

    // Return total number of completed jobs
    private int getCompletedJobs() {
        return completedJobs;
    }

    // Return average job completion time
    private double getAverageJobCompletionTime() {
        if (completedJobs == 0) {
            return 0;
        }
        return totalJobCompletionTime / completedJobs;
    }


    //Initializing and running the simulation with and without the bagger
    public static UnitTestResult UnitTest() {
        UnitTestResult result = new UnitTestResult();

        //Simulation parameters
        int simulationRunTime = 560; // 9 hours * 60 minutes (we can change it later)
        double arrivalRate = 0.15; //  assume 0.15 arrivals per minute (1 arrival in every 6.67 minutes)
        double shoppingRate = 0.1; // assume average shopping time 10 minutes
        double checkoutRate = 0.02; // assume average checkout time 5 minutes

        //Run simulation WITHOUT a bagger
        Simulation noBaggerSim = new Simulation(simulationRunTime, arrivalRate, shoppingRate, checkoutRate, false);
        noBaggerSim.setup(); //Sets up the simulation by creating first arrival events
        noBaggerSim.run(simulationRunTime); //Run the simulation for a specified time
        noBaggerSim.process(); //Processes and displays results of Simulation


        //Run simulation WITH a bagger
        Simulation baggerSim = new Simulation(simulationRunTime, arrivalRate, shoppingRate, checkoutRate, true);
        baggerSim.setup(); //Sets up the simulation by creating first arrival events
        baggerSim.run(simulationRunTime); //Run the simulation for a specified time
        baggerSim.process(); //Processes and displays results of Simulation

        return result;
    }
}