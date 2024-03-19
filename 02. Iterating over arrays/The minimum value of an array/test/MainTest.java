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
        simpleTest("5\n5 1 4 2 3", "1");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("3\n-1 -2 -3", "-3");
    }

    @Test
    public void test1() {
        simpleTest("1\n0", "0");
    }

    @Test
    public void test2() {
        simpleTest("2\n-100 100", "-100");
    }

    @Test
    public void test3() {
        simpleTest("4\n5 5 5 5", "5");
    }

    @Test
    public void test4() {
        simpleTest("3\n0 0 0", "0"); // all elements are 0
    }

    @Test
    public void test5() {
        simpleTest("4\n10 8 6 4", "4"); // elements are in descending order
    }

    @Test
    public void test6() {
        simpleTest("6\n-4 -1 0 1 4 8", "-4"); // elements are a mix of negative and positive numbers
    }

    @Test
    public void test8() {
        simpleTest("100000\n" + "0 ".repeat(99999) + "0", "0"); // large input array with all elements being 0
    }

    @Test
    public void test9() {
        simpleTest("6\n-2 -2 1 3 -2 0", "-2"); // minimum value appears multiple times
    }

    @Test
    public void test10() {
        simpleTest("5\n-5 0 1 2 3", "-5"); // minimum value at the beginning of the array
    }

    @Test
    public void test11() {
        simpleTest("5\n5 4 3 2 -10", "-10"); // minimum value at the end of the array
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