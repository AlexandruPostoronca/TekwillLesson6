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
        simpleTest("3\n1 3 2\n2 3\n", "true");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("3\n1 2 1\n2 3\n", "false");

    }

    @Test
    public void test1() {
        simpleTest("2\n1 2\n1 2\n", "true");// Minimum input values
    }

    @Test
    public void test2() {
        simpleTest("5\n3 2 5 4 6\n3 2\n", "true");// n and m are at the beginning of the array
    }

    @Test
    public void test3() {
        simpleTest("5\n6 5 1 3 2\n2 6\n", "false");// n and m are at the end of the array
    }

    @Test
    public void test4() {
        simpleTest("4\n2 4 6 8\n1 3\n", "false");// n and m are not present in the array
    }

    @Test
    public void test5() {
        simpleTest("4\n2 4 3 8\n4 2\n", "true");// n and m are present in the array but not next to each other
    }

    @Test
    public void test6() {
        simpleTest("1\n5\n5 5\n", "false");// Only one element in the array
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