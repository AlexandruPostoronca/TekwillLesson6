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
        simpleTest("level beginner mode battle", "battle");
    }

    @Test
    public void testFromProblem2() {
        simpleTest("parameter1 mode parameter2 value2", "default");
    }

    @Test
    public void test1() {
        simpleTest("easy mode normal mode mode hard", "hard");
    }

    @Test
    public void test2() {
        simpleTest("mode easy", "easy");
    }

    @Test
    public void test3() {
        simpleTest("mode easy normal mode hard mode", "easy");
    }

    @Test
    public void test4() {
        simpleTest("param1 value1 param2 value2 param3 value3 mode hard param4 value4", "hard");
    }

    @Test
    public void test5() {
        simpleTest("", "default");
    }

    @Test
    public void test6() {
        simpleTest("level beginner", "default");
    }

    @Test
    public void test7() {
        simpleTest("mode mode", "mode");
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(in.split("\\s+"));
        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}