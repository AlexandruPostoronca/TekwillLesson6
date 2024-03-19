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
    public void test1() {
        simpleTest("arg1 arg2 test", "2");
    }

    @Test
    public void test2() {
        simpleTest("arg1 arg2 arg3    ", "-1");
    }

    @Test
    public void test3() {
        simpleTest("arg1 arg2 arg3 arg4 arg5 test", "5");
    }

    @Test
    public void test4() {
        simpleTest("test", "0");
    }

    @Test
    public void test5() {
        simpleTest("arg1 arg2 arg3 test", "3");
    }

    @Test
    public void test6() {
        simpleTest("arg1 arg2 arg3 arg4 arg5 arg6 arg7 test", "7");
    }

    @Test
    public void test7() {
        simpleTest("arg1 arg2 arg3 arg4 test", "4");
    }

    @Test
    public void test8() {
        simpleTest("arg1 arg2 arg3 arg4 arg5 arg6 arg7 arg8 arg9 arg10 test", "10");
    }

    @Test
    public void test9() {
        simpleTest("arg1 arg2 arg3 arg4 arg5", "-1");
    }

    @Test
    public void test10() {
        simpleTest("arg1 arg2 arg3 arg4 arg5 test", "5");
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(in.split("\\s+"));
        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result + "\r\n";
        assertEquals(message, expected, result);
    }

}