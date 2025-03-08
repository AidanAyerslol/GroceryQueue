public class SingleServerQueue {
    private Queue<Job> queue;
    private Job jobinservice;
    private double nextendservicetime;
    private double checkoutRate;
    private ExponentialDistribution servicetimedistribution;

    private boolean doubleStaffed;

    private final double DOUBLESTAFF_RATE = 0.5;

    public SingleServerQueue(double checkoutRate, boolean bagger) {
        queue = new Queue<Job>();
        jobinservice = null;
        nextendservicetime = Double.MAX_VALUE;
        this.checkoutRate = checkoutRate;
        servicetimedistribution = new ExponentialDistribution(checkoutRate);
        doubleStaffed = bagger;
    }

    public int getLength() { return queue.getLength(); }

    public void add(Job job, double currenttime) {
        if(jobinservice == null) {
            jobinservice = job;
            if (doubleStaffed){nextendservicetime = (currenttime + (servicetimedistribution.sample() * DOUBLESTAFF_RATE)); }
            else {nextendservicetime = (currenttime + servicetimedistribution.sample());}
        }
        else { queue.enqueue(job); }
    }

    public double getEndServiceTime() {
        return nextendservicetime;
    }

    public Job complete(double currentTime) {
        Job jobtocomplete = jobinservice;
        jobtocomplete.completed(currentTime);
        if(queue.isQueueEmpty()) { jobinservice = null; nextendservicetime = Double.MAX_VALUE; }
        else { jobinservice = queue.dequeue();
            if (doubleStaffed){nextendservicetime = (currentTime + (servicetimedistribution.sample() * DOUBLESTAFF_RATE)); }
            else {nextendservicetime = (currentTime + servicetimedistribution.sample());} }
        return jobtocomplete;
    }

    public static UnitTestResult UnitTest() {
        UnitTestResult result = new UnitTestResult();

        int jobId = 1;
        double currentTime = 0.0;
        double checkoutRate = 1.0;
        SingleServerQueue queue = new SingleServerQueue(checkoutRate, false);

        // Test initial state
        result.recordNewTask(queue.getLength() == 0);
        result.recordNewTask(queue.getEndServiceTime() == Double.MAX_VALUE);

        // Test adding first job
        Job job1 = new Job(currentTime, jobId++);
        queue.add(job1, currentTime);
        result.recordNewTask(queue.getLength() == 0); // Job should be in service, not queue
        result.recordNewTask(queue.getEndServiceTime() != Double.MAX_VALUE);

        // Test adding second job
        Job job2 = new Job(currentTime, jobId++);
        queue.add(job2, currentTime);
        result.recordNewTask(queue.getLength() == 1); // Job should be in queue

        // Test adding third job
        Job job3 = new Job(currentTime, jobId++);
        queue.add(job3, currentTime);
        result.recordNewTask(queue.getLength() == 2); // Queue should now have two jobs

        // Test completing first job
        double endTime1 = queue.getEndServiceTime();
        Job completedJob1 = queue.complete(endTime1);
        result.recordNewTask(completedJob1 == job1);
        result.recordNewTask(queue.getLength() == 1); // Job2 should now be in service
        result.recordNewTask(queue.getEndServiceTime() != Double.MAX_VALUE);

        // Test completing second job
        double endTime2 = queue.getEndServiceTime();
        Job completedJob2 = queue.complete(endTime2);
        result.recordNewTask(completedJob2 == job2);
        result.recordNewTask(queue.getLength() == 0); // Job3 should now be in service
        result.recordNewTask(queue.getEndServiceTime() != Double.MAX_VALUE);

        // Test completing third job
        double endTime3 = queue.getEndServiceTime();
        Job completedJob3 = queue.complete(endTime3);
        result.recordNewTask(completedJob3 == job3);
        result.recordNewTask(queue.getLength() == 0);
        result.recordNewTask(queue.getEndServiceTime() == Double.MAX_VALUE);

        return result;
    }
}