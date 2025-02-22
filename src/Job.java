public class Job {
    private double arrivaltime;
    private double completiontime;
    private int numberofitems; //This is optional, but added in case we want to go that route.

    public Job(double arrivaltime, int numberofitems) {
        this.arrivaltime = arrivaltime;
        this.numberofitems = numberofitems;
    }

    //If any of these are unnecessary in the future we can easily remove, this function just is accessed a lot so added these to start.
    public double getArrivalTime() { return arrivaltime; }
    public void setArrivalTime(double arrivalTime) { this.arrivaltime = arrivalTime; }
    public double getCompletionTime() { return completiontime; }
    public void setCompletionTime(double completionTime) { this.completiontime = completionTime; }
    public int getNumberOfItems() { return numberofitems; }
    public void setNumberOfItems(int numberOfItems) { this.numberofitems = numberOfItems; }
}
