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
    private final String N = System.lineSeparator();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testFromProblem() {
        simpleTest("3 4\n11 12 13 14\n21 22 23 24\n31 32 33 34\n0 1",
                "12 11 13 14" + N + "22 21 23 24" + N + "32 31 33 34"); // Swap first column with second column
    }

    @Test
    public void test1() {
        simpleTest("3 3\n1 2 3\n4 5 6\n7 8 9\n1 2","1 3 2" + N + "4 6 5" + N + "7 9 8"); // Swap second column with third column
    }

    @Test
    public void test2() {
        simpleTest("3 3\n1 2 3\n4 5 6\n7 8 9\n1 1","1 2 3" + N + "4 5 6" + N + "7 8 9"); // Swap a column with itself
    }

    @Test
    public void test3() {
        simpleTest("1 1\n1\n0 0", "1"); // Swap column of a single-element matrix with itself
    }

    @Test
    public void test4() {
        simpleTest("2 2\n1 2\n3 4\n0 1", "2 1" + N + "4 3"); // Swap first column with second column for a small matrix
    }

    @Test
    public void test5() {
        simpleTest("2 2\n1 2\n3 4\n1 0", "2 1" + N + "4 3"); // Swap first column with itself
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});
        //Get the result
        String result = outputStreamCaptor.toString().trim().replaceAll("\\s(\\r\\n|\\r|\\n)", N);

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}