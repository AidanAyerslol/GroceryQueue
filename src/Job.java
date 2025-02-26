public class Job {
    private int joinlinetime;
    private int paidtime;
    private Customer customer;

    public Job(int arrivaltime, Customer customer) {
        this.joinlinetime = arrivaltime;
    }

    public double getJoinLineTime() { return joinlinetime; }
    public double getPaidTime() { return paidtime; }
    public void setPaidTime(int completionTime) { this.paidtime = completionTime; }
}
