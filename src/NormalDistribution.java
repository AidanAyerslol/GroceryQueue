import java.util.Random;

public class NormalDistribution extends RandomDistribution {
    //Service time parameters
    private double mean;
    private double variance;
    private double spare;
    private boolean hasSpare = false;
    private Random r = new Random();


    public NormalDistribution(double mean, double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    //Textbook uses Central Limit Theorem method to approximate normal, Box-Muller transform is more efficient since it directly generates a sample,
    // and is more precise because it doesn't sum uniform numbers. Based on the JavaScript example shown on the Box-Muller transform Wikipedia article.
    @Override public double sample() {
        if(hasSpare) { hasSpare = false; return mean + Math.sqrt(variance) * spare; }

        double u, v, s;
        do {
            u = 2.0 * r.nextDouble() - 1.0;
            v = 2.0 * r.nextDouble() - 1.0;
            s = (u * u) + (v * v);
        } while (s >= 1 || s == 0);

        double mult = Math.sqrt(-2.0 * Math.log(s) / s);
        spare = v * mult;
        hasSpare = true;

        return mean + Math.sqrt(variance) * (u * mult);
    }
}
