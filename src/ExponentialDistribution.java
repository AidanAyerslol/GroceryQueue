public class ExponentialDistribution extends RandomDistribution {
    private double lambda; //Rate/arrival time parameter

    public ExponentialDistribution(double lambda) {
        this.lambda = lambda;
    }

    @Override
    public double sample() {
        //TODO: Generate and return sample from exponential distribution (pg 27 of 202 course notes)
        return 0.0;
    }
}
