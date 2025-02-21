package UnitTest;

public class UnitTestResult
{
    private int testsRun, testsFinished;

    public UnitTestResult()
    {
        testsRun = 0;
        testsFinished = 0;
    }

    public UnitTestResult(int testsPerformed, int testsPassed)
    {
        testsRun = testsPerformed;
        testsFinished = testsPassed;
    }

    public int getTestsRun() { return testsRun; }
    public int getTestsFinished() { return testsFinished; }

    public void factorResults(UnitTestResult ut)
    {
        testsRun += ut.getTestsRun();
        testsFinished += ut.getTestsFinished();
    }

    public void recordNewTask(boolean success)
    {
        testsRun++;
        if(success)
        {
            testsFinished++;
        }
    }
}
