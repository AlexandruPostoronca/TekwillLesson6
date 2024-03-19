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
        simpleTest("2\n5 3\n", "15");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("3\n10 8 4\n", "80");
    }

    @Test
    public void test1() {
        simpleTest("5\n2 5 3 4 5\n", "20");
    }

    @Test
    public void test2() {
        simpleTest("6\n1000 10 1000 10 10 1001\n", "10010");
    }

    @Test
    public void test3() {
        simpleTest("1\n42\n", "0");
    }

    @Test
    public void test5() {
        simpleTest("3\n-1 -2 -3\n", "6");
    }

    @Test
    public void test6() {
        simpleTest("4\n-5 0 5 -5\n", "0");
    }

    @Test
    public void test7() {
        simpleTest("1\n1000", "0");// array with a single element
    }

    @Test
    public void test8() {
        simpleTest("2\n1000 2000", "2000000");// array with two elements, one is maximum
    }

    @Test
    public void test9() {
        simpleTest("2\n2000 2000", "4000000");// array with two elements, both are maximum
    }

    @Test
    public void test10() {
        simpleTest("7\n1 2 3 2 1 2 1", "6");// array with repeated elements
    }

    @Test
    public void test11() {
        simpleTest("6\n-5 -10 -3 -5 -5 -5", "50");// array with negative elements
    }

    @Test
    public void test12() {
        simpleTest("4\n7 7 7 7", "49");// array with all elements equal
    }

    @Test
    public void test13() {
        simpleTest("4\n1 2 3 4", "12");// array with maximum at the end
    }

    @Test
    public void test14() {
        simpleTest("4\n4 3 2 1", "12");// array with maximum at the beginning
    }

    @Test
    public void test15() {
        simpleTest("5\n1 2 5 4 3", "20");// array with maximum in the middle
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