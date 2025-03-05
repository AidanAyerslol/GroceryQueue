public class main {
    // setting simulation parameters
    final double averageShoppingRate = 0.1; // assume average shopping time 10 minutes
    final double arrivalRate = 0.15; //  assume average arrival time 15 jobs per minute
    ExponentialDistribution exponentialDistribution = new ExponentialDistribution(averageShoppingRate);

    int simulationEndTime = 560; // 9 hours * 60 minutes (we can change it later)
    double shoppingTimeDistribution = exponentialDistribution.sample();


}
