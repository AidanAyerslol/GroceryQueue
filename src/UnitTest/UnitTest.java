package UnitTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import UnitTest.UnitTestResult;

public class UnitTest
{
    private static UnitTestResult totalTests = new UnitTestResult();

    public static void main(String[] args)
    {
        System.out.println("Running all unit tests");
        doTests();
        System.out.println(totalTests.getTestsFinished() + " of " + totalTests.getTestsRun() + " passed.");
        if(totalTests.getTestsFinished() == totalTests.getTestsRun())
        {
            System.out.println("SUCCESS");
        }
        else
        {
            System.out.println("FAIL");
        }
    }

    private static void doTests()
    {
        //PUT ALL UNIT TESTS HERE. Run this to perform Unit Tests. Below is example structure for adding Unit Tests of a class.
        //totalTests.factorResults(ExampleClass.UnitTest());
    }
}
