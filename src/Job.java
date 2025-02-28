public class Job {
    private double timeOfCreation;
    private double serviceLength;
    private double endTime;
    private int jobID;

    public double getTimeOfCreation() { return timeOfCreation; }
    public double getServiceLength() { return serviceLength; }
    public double getEndTime() { return endTime; }
    public double getJobID() { return jobID; }

    public Job(double currentTime, int ID) { timeOfCreation = currentTime; jobID = ID; }

    public void completed(double currentTime) { serviceLength = currentTime - timeOfCreation; endTime = currentTime; }

    public String toString() {
        return "temp";
    }
}