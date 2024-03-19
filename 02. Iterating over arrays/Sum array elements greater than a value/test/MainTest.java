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
        simpleTest("5\n5 8 11 2 10\n8", "21");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("4\n-5 -4 -6 -11\n-10", "-15");
    }

    @Test
    public void test1() {
        simpleTest("1\n1\n1", "0");
    }

    @Test
    public void test2() {
        simpleTest("3\n1 2 3\n4", "0");
    }

    @Test
    public void test3() {
        simpleTest("5\n5 8 11 2 10\n5", "29"); // all elements are greater than n
    }

    @Test
    public void test4() {
        simpleTest("5\n5 8 11 2 10\n15", "0"); // no elements are greater than n
    }

    @Test
    public void test5() {
        simpleTest("3\n-5 -6 -7\n-8", "-18"); // all elements are less than n (negative numbers)
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