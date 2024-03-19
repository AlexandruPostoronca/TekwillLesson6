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
        simpleTest("config-path /something/there config-format json", "config-path=/something/there" + N + "config-format=json");
    }

    @Test
    public void test2() {
        simpleTest("mode-name single level 88", "mode-name=single" + N + "level=88");
    }

    @Test
    public void test3() {
        simpleTest("name John age 25 gender male city NewYork", "name=John" + N + "age=25" + N + "gender=male" + N + "city=NewYork");
    }

    @Test
    public void test4() {
        simpleTest("key1 value1 key2 value2 key3 value3", "key1=value1" + N + "key2=value2" + N + "key3=value3");
    }

    @Test
    public void test5() {
        simpleTest("num1 100 num2 200 num3 300 num4 400", "num1=100" + N + "num2=200" + N + "num3=300" + N + "num4=400");
    }

    @Test
    public void test6() {
        simpleTest("fruit apple color red", "fruit=apple" + N + "color=red");
    }

    @Test
    public void test7() {
        simpleTest("name Alice age 30 gender female city London", "name=Alice" + N + "age=30" + N + "gender=female" + N + "city=London");
    }

    private void simpleTest(String in, String expected) {
        //Set input stream
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(in.split("\\s+"));
        //Get the result
        String result = outputStreamCaptor.toString().trim().replaceAll("\\s(\\r\\n|\\r|\\n)", N);

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

}