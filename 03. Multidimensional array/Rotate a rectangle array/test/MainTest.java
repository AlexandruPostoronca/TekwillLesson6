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
    public void test1() {
        simpleTest("3 4\n11 12 13 14\n21 22 23 24\n31 32 33 34",
                "31 21 11" + N + "32 22 12" + N + "33 23 13" + N + "34 24 14"); // given test case
    }

    @Test
    public void test2() {
        simpleTest("1 1\n100", "100"); // minimum input size
    }

    @Test
    public void test3() {
        simpleTest("2 2\n1 2\n3 4", "3 1" + N + "4 2"); // square input
    }

    @Test
    public void test4() {
        simpleTest("4 3\n10 20 30\n40 50 60\n70 80 90\n100 110 120",
                "100 70 40 10" + N + "110 80 50 20" + N + "120 90 60 30"); // rectangular input
    }

    @Test
    public void test5() {
        simpleTest("3 1\n1\n2\n3", "3 2 1"); // minimum rectangular input size
    }

    @Test
    public void test6() {
        simpleTest("2 2\n1 2\n3 4", "3 1" + N + "4 2"); // square input with odd size.
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