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
        simpleTest("6\n1 2 3 4 2 1\n2", "2"); // n occurs multiple times
    }

    @Test
    public void testFromProblem2() {
        simpleTest("9\n1 2 3 4 5 4 3 2 1\n7", "0"); // n doesn't occur in the array
    }

    @Test
    public void test1() {
        simpleTest("1\n1\n1", "1"); // single element array where n occurs
    }

    @Test
    public void test2() {
        simpleTest("5\n0 0 0 0 0\n0", "5"); // array with all elements being n
    }

    @Test
    public void test3() {
        simpleTest("100000\n" + "0 ".repeat(99999) + "1\n1", "1"); // large input array with only one element being n
    }

    @Test
    public void test4() {
        simpleTest("100000\n" + "1 ".repeat(99999) + "0\n0", "1"); // large input array with n being 0
    }

    @Test
    public void test5() {
        simpleTest("3\n1 2 3\n4", "0"); // n doesn't occur in the array
    }

    @Test
    public void test6() {
        simpleTest("4\n-1 -2 -3 -4\n-3", "1"); // n occurs once in the array
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