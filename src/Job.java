public class Job {
  
    private int joinlinetime;
    private int paidtime;
    private Customer customer;

    public Job(int arrivaltime, Customer customer) {
        this.joinlinetime = arrivaltime;
    }

    public int getJoinLineTime() {
        return joinlinetime;
    }
  
    public int getPaidTime() {
        return paidtime;
    }
    
    public void setPaidTime(int completionTime) {
        this.paidtime = completionTime;
    }
}