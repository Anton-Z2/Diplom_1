package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    public static final String BUN_NAME = "red bun";
    public static final float BUN_PRICE = 300.0f;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameTest() {
        assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(BUN_PRICE, bun.getPrice(), 0.0f);
    }
}
