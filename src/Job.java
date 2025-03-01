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
        //TODO: Properly implement toString method for Job
        return "temp";
    }
}