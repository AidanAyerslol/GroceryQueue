public class NormalDistribution extends RandomDistribution {
    //Service time parameters
    private double mean;
    private double variance;

    public NormalDistribution(double mean, double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    @Override public double sample() {
        //TODO: Generate and return sample from the normal distribution (pg 31 of 202 course notes)
        return 0.0;
    }
}
