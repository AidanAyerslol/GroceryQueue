public class Job {
    private double timeofcreation;
    private double servicelength;
    private double endtime;
    private int jobID;

    public double getTimeOfCreation() { return timeofcreation; }
    public double getServiceLength() { return servicelength; }
    public double getEndTime() { return endtime; }
    public double getJobID() { return jobID; }

    public Job(double currentTime, int ID) { timeofcreation = currentTime; jobID = ID; }

    public void completed(double currentTime) { servicelength = currentTime - timeofcreation; endtime = currentTime; }

    public String toString() {
        return "ID:" + getJobID() + " Creation Time:" + getTimeOfCreation() + " Service Length:" + getServiceLength() + " Job End Time:" + getEndTime();
    }

    public static UnitTestResult UnitTest() {
        UnitTestResult result = new UnitTestResult();

        Job job = new Job(0.001, 5308);
        result.recordNewTask(job.toString().equals("ID:5308.0 Creation Time:0.001 Service Length:0.0 Job End Time:0.0"));
        job.completed(1);
        result.recordNewTask(job.toString().equals("ID:5308.0 Creation Time:0.001 Service Length:0.999 Job End Time:1.0"));

        return result;
    }
}