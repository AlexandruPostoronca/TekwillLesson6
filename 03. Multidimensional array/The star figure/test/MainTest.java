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
        simpleTest("9", "* . . . * . . . *" + N + ". * . . * . . * ." + N + ". . * . * . * . ." + N + ". . . * * * . . ." + N +
                        "* * * * * * * * *" + N + ". . . * * * . . ." + N + ". . * . * . * . ." + N + ". * . . * . . * ." + N + "* . . . * . . . *");
    }

    @Test
    public void test1() {
        simpleTest("3", "* * *" + N + "* * *" + N + "* * *"); // n=3, smallest odd n
    }

    @Test
    public void test2() {
        simpleTest("5", "* . * . *" + N + ". * * * ." + N + "* * * * *" + N + ". * * * ." + N + "* . * . *"); // n=5, odd n
    }

    @Test
    public void test3() {
        simpleTest("15", "* . . . . . . * . . . . . . *" + N + ". * . . . . . * . . . . . * ." + N +
                         ". . * . . . . * . . . . * . ." + N + ". . . * . . . * . . . * . . ." + N + ". . . . * . . * . . * . . . ." + N +
                         ". . . . . * . * . * . . . . ." + N + ". . . . . . * * * . . . . . ." + N + "* * * * * * * * * * * * * * *" + N +
                         ". . . . . . * * * . . . . . ." + N + ". . . . . * . * . * . . . . ." + N + ". . . . * . . * . . * . . . ." + N +
                         ". . . * . . . * . . . * . . ." + N + ". . * . . . . * . . . . * . ." + N + ". * . . . . . * . . . . . * ." + N +
                         "* . . . . . . * . . . . . . *");// largest
    }


    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});
        //Get the result
        String result = outputStreamCaptor.toString().trim().replaceAll("\\s(\\r\\n|\\r|\\n)", N);

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" +
                         expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}