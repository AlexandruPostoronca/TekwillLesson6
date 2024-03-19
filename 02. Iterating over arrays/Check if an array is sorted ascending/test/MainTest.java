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
        simpleTest("4\n1 2 3 4", "true"); // from problem
    }

    @Test
    public void testFromProblem2() {
        simpleTest("4\n1 2 3 0", "false"); // from problem
    }

    @Test
    public void test1() {
        simpleTest("1\n0", "true"); // edge case: single element array
    }

    @Test
    public void test2() {
        simpleTest("5\n5 5 5 5 5", "true"); // edge case: array with identical elements
    }

    @Test
    public void test3() {
        simpleTest("6\n1 2 3 3 2 1", "false"); // edge case: descending order array
    }

    @Test
    public void test4() {
        simpleTest("3\n3 2 3", "false"); // edge case: partially sorted array
    }

    @Test
    public void test5() {
        simpleTest("3\n3 2 1", "false"); // edge case: completely reverse sorted array
    }

    @Test
    public void test6() {
        simpleTest("4\n4 4 4 5", "true"); // random test case: sorted array with repeating elements
    }

    @Test
    public void test7() {
        simpleTest("6\n2 4 1 5 3 6", "false"); // random test case: unsorted array
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