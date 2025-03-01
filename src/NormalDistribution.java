import java.util.Random;

public class NormalDistribution extends RandomDistribution {
    //Service time parameters
    private double mean;
    private double variance;
    private double spare;
    private boolean hasspare = false;
    private Random r = new Random();


    public NormalDistribution(double mean, double variance) {
        this.mean = mean;
        this.variance = variance;
    }

    //Textbook uses Central Limit Theorem method to approximate normal, Box-Muller transform is more efficient since it directly generates a sample,
    // and is more precise because it doesn't sum uniform numbers. Based on the JavaScript example shown on the Box-Muller transform Wikipedia article.
    @Override public double sample() {
        if(hasspare) { hasspare = false; return mean + Math.sqrt(variance) * spare; }

        double u, v, s;
        do {
            u = 2.0 * r.nextDouble() - 1.0;
            v = 2.0 * r.nextDouble() - 1.0;
            s = (u * u) + (v * v);
        } while (s >= 1 || s == 0);

        double mult = Math.sqrt(-2.0 * Math.log(s) / s);
        spare = v * mult;
        hasspare = true;

        return mean + Math.sqrt(variance) * (u * mult);
    }

    public static UnitTestResult UnitTest() {
        UnitTestResult result = new UnitTestResult();

        // Test 1: Check statistical properties over many samples.
        // Create a NormalDistribution with known mean and variance, using Central Limit Theorem method.
        double expectedMean = 10.0;
        double expectedVariance = 4.0;
        NormalDistribution nd = new NormalDistribution(expectedMean, expectedVariance);

        int sampleCount = 10000;
        double sum = 0.0;
        double sumSq = 0.0;
        for (int i = 0; i < sampleCount; i++) {
            double sample = nd.sample();
            sum += sample;
            sumSq += sample * sample;
        }
        double sampleMean = sum / sampleCount;
        // Calculate variance using E[X^2] - (E[X])^2
        double sampleVariance = (sumSq / sampleCount) - (sampleMean * sampleMean);

        // Set acceptable tolerances (loose enough to account for random variation).
        double toleranceMean = 0.1;
        double toleranceVariance = 0.1;

        boolean meanTestPassed = Math.abs(sampleMean - expectedMean) <= toleranceMean;
        boolean varianceTestPassed = Math.abs(sampleVariance - expectedVariance) <= toleranceVariance;

        result.recordNewTask(meanTestPassed);
        result.recordNewTask(varianceTestPassed);

        // Test 2: Check that consecutive calls yield distinct results (i.e. results are truly random).
        double sample1 = nd.sample();
        double sample2 = nd.sample();
        boolean distinctSamples = sample1 != sample2;  // Extremely unlikely to be equal. Still technically possible
        result.recordNewTask(distinctSamples);

        return result;
    }
}
