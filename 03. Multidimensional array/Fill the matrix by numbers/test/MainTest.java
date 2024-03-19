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
        simpleTest("5", "0 1 2 3 4" + N + "1 0 1 2 3" + N + "2 1 0 1 2" + N + "3 2 1 0 1" + N + "4 3 2 1 0");
        // basic test case from the problem
    }

    @Test
    public void test1() {
        simpleTest("1", "0"); // edge case with the smallest input
    }

    @Test
    public void test2() {
        simpleTest("3", "0 1 2" + N + "1 0 1" + N + "2 1 0"); // edge case with odd n
    }

    @Test
    public void test3() {
        simpleTest("2", "0 1" + N + "1 0"); // edge case with even n
    }

    @Test
    public void test4() {
        simpleTest("4", "0 1 2 3" + N + "1 0 1 2" + N + "2 1 0 1" + N + "3 2 1 0"); // edge case with even n
    }

    @Test
    public void test5() {
        simpleTest("6", "0 1 2 3 4 5" + N + "1 0 1 2 3 4" + N + "2 1 0 1 2 3" + N + "3 2 1 0 1 2" +
                        N + "4 3 2 1 0 1" + N + "5 4 3 2 1 0"); // larger odd n
    }

    @Test
    public void test6() {
        // larger odd n
        simpleTest("7", "0 1 2 3 4 5 6" + N + "1 0 1 2 3 4 5" + N + "2 1 0 1 2 3 4" + N + "3 2 1 0 1 2 3" +
                        N + "4 3 2 1 0 1 2" + N + "5 4 3 2 1 0 1" + N + "6 5 4 3 2 1 0");
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