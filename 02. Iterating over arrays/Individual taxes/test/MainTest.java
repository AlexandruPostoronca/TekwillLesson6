import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testFromProblem1() {
        simpleTest("1\n1\n1", "1"); //single company, single tax rate
    }

    @Test
    public void testFromProblem2() {
        simpleTest("2\n50 100\n10 10", "2"); //multiple companies, different tax rates
    }

    @Test
    public void test1() {
        simpleTest("3\n50 100 300\n100 20 0", "1"); //multiple companies, some have 0 taxes, some have same payment sizes
    }

    @Test
    public void test2() {
        simpleTest("4\n10 20 30 40\n25 50 75 100", "4"); // multiple companies, different tax rates, descending order
    }

    @Test
    public void test3() {
        simpleTest("5\n50 10 20 30 40\n10 10 10 10 10", "1"); // multiple companies, different tax rates, ascending order
    }

    @Test
    public void test4() {
        simpleTest("2\n1000000000 999999999\n99 100", "2"); // large incomes, different tax rates
    }

    @Test
    public void test5() {
        simpleTest("1\n1000000\n42\n", "1"); // one company with very high income and high taxes
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});
        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}