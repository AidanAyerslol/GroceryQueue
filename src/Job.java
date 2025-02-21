public class Job {
    private double arrivalTime;
    private double completionTime;
    private int numberOfItems; //This is optional, but added in case we want to go that route.

    public Job(double arrivalTime, int numberOfItems) {
        this.arrivalTime = arrivalTime;
        this.numberOfItems = numberOfItems;
    }

    //If any of these are unnecessary in the future we can easily remove, this function just is accessed a lot so added these to start.
    public double getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(double arrivalTime) { this.arrivalTime = arrivalTime; }
    public double getCompletionTime() { return completionTime; }
    public void setCompletionTime(double completionTime) { this.completionTime = completionTime; }
    public int getNumberOfItems() { return numberOfItems; }
    public void setNumberOfItems(int numberOfItems) { this.numberOfItems = numberOfItems; }
}
