package test2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckEvenTest {

    @Test
    public void testCheckEven() {
        // Тест на пустой массив
        assertEquals(0, checkEven(new byte[0]));

        // Тест на массив с нечетным количеством четных байтов
        assertEquals(1, checkEven(new byte[]{1, 2, 3, 4}));

        // Тест на массив с смешанным количеством четных и нечетных байтов
        assertEquals(1, checkEven(new byte[]{1, 2, 3, 4, 5, 6}));
    }

    private int checkEven(byte[] data) {
        int even = 0;
        for (byte b : data) {
            int count = 0;
            for (int i = 0; i < 8; i++) {
                count += (b >> i & 1);
            }

            if (count % 2 == 0) {
                even += 0;
            } else {
                even += 1;
            }
        }
        return even % 2;
    }
}