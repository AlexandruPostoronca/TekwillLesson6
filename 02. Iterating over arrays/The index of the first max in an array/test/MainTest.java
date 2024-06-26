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
        simpleTest("5\n2 5 3 4 5", "1");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("6\n1000 10 1000 10 10 1001", "5");
    }

    @Test
    public void testOneElementArray() {
        simpleTest("1\n5", "0");
    }

    @Test
    public void testArrayWithMultipleMaximums() {
        simpleTest("7\n1 3 2 3 4 3 5", "6");
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        simpleTest("5\n-1 -5 -3 -4 -2", "0");
    }

    @Test
    public void testArrayWithAllSameElements() {
        simpleTest("5\n3 3 3 3 3", "0");
    }

    @Test
    public void testArrayWithDescendingOrder() {
        simpleTest("5\n5 4 3 2 1", "0");
    }

    @Test
    public void testArrayWithAscendingOrder() {
        simpleTest("5\n1 2 3 4 5", "4");
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