public class Main {
    public static void main(String[] args) {
    // setting simulation parameters
    int simulationEndTime = 560; // 9 hours * 60 minutes (we can change it later)
    double arrivalRate = 0.15; //  assume average arrival time 15 jobs per minute
    double averageShoppingRate = 0.1; // assume average shopping time 10 minutes

    ExponentialDistribution shoppingTimeDistribution = new ExponentialDistribution(averageShoppingRate);
    // create a functionality for exponential distribution for checkout time and change the hard coded distribution in Single Ever Queue class


    }
}
