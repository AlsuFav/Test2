package test2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckEvenTest {

    @Test
    public void testCheckEven() {
        assertEquals(0, checkEven(new byte[0]));
        assertEquals(1, checkEven(new byte[]{1, 2, 3, 4}));
        assertEquals(1, checkEven(new byte[]{1, 2, 3, 4, 5, 6}));
    }
