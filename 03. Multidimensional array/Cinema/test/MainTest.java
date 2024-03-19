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
        // The first row with 2 consecutive available seats is the third row
        simpleTest("3 4\n0 1 0 1\n1 1 0 1\n1 0 0 1\n2\n", "3");
    }

    @Test
    public void testFromProblem2() {
        // There are no 3 consecutive available seats in any row
        simpleTest("3 3\n0 1 0\n1 0 0\n1 1 1\n3\n", "0");
    }

    @Test
    public void testSingleRowWithNoConsecutiveSeats() {
        simpleTest("1 5\n1 1 1 1 1\n1\n", "0"); // There are no consecutive available seats in the only row
    }

    @Test
    public void testSingleRowWithConsecutiveSeats() {
        simpleTest("1 5\n0 0 0 1 1\n2\n", "1"); // The first row has 2 consecutive available seats
    }

    @Test
    public void testMultipleRowsWithConsecutiveSeats() {
        // The third row has 3 consecutive available seats
        simpleTest("5 5\n1 1 0 0 1\n0 0 0 0 0\n1 1 1 0 0\n0 0 0 0 0\n0 0 1 1 1\n3\n", "2");
    }

    @Test
    public void testNoConsecutiveSeats() {
        simpleTest("4 4\n1 1 1 1\n1 1 1 1\n1 1 1 1\n1 1 1 1\n3\n", "0"); // There are no consecutive available seats in any row
    }

    @Test
    public void testAllRowsWithConsecutiveSeats() {
        simpleTest("3 3\n0 0 0\n0 0 0\n0 0 0\n3\n", "1"); // All rows have 3 consecutive available seats, so the first row is returned
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