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
        simpleTest("3\n1 2 3\n", "6");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("5\n-1 0 1 2 -2\n", "0");
    }

    @Test
    public void test1() {
        simpleTest("0", "0"); // empty array
    }

    @Test
    public void test2() {
        simpleTest("1\n5", "5"); // single element array
    }

    @Test
    public void test3() {
        simpleTest("2\n0 0", "0"); // array with all elements being 0
    }

    @Test
    public void test4() {
        simpleTest("5\n-10 -5 0 5 10", "0"); // array with both negative and positive elements
    }

    @Test
    public void test5() {
        simpleTest("100000\n" + "1 ".repeat(99999) + "1", "100000"); // large input array with all elements being 1
    }

    @Test
    public void test6() {
        simpleTest("100001\n" + "1 ".repeat(100000) + "0", "100000"); // large input array with one element being 0
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