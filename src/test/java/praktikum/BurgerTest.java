package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    public static final String MOCK_BUN_NAME = "black bun";
    public static final float MOCK_BUN_PRICE = 100.0f;
    public static final String MOCK_INGREDIENT1_NAME = "hot sauce";
    public static final float MOCK_INGREDIENT1_PRICE = 100.0f;
    public static final String MOCK_INGREDIENT2_NAME = "sausage";
    public static final float MOCK_INGREDIENT2_PRICE = 300.0f;

    private Burger burger;
    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        when(mockBun.getName()).thenReturn(MOCK_BUN_NAME);
        when(mockBun.getPrice()).thenReturn(MOCK_BUN_PRICE);

        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getName()).thenReturn(MOCK_INGREDIENT1_NAME);
        when(mockIngredient1.getPrice()).thenReturn(MOCK_INGREDIENT1_PRICE);

        when(mockIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient2.getName()).thenReturn(MOCK_INGREDIENT2_NAME);
        when(mockIngredient2.getPrice()).thenReturn(MOCK_INGREDIENT2_PRICE);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        float expectedPrice = MOCK_BUN_PRICE * 2 + MOCK_INGREDIENT1_PRICE + MOCK_INGREDIENT2_PRICE;
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals("(==== " + MOCK_BUN_NAME + " ====)\r\n" +
                "= sauce " + MOCK_INGREDIENT1_NAME + " =\r\n" +
                "= filling " + MOCK_INGREDIENT2_NAME + " =\r\n" +
                "(==== " + MOCK_BUN_NAME + " ====)\r\n" +
                "\r\nPrice: 600,000000\r\n", burger.getReceipt());
    }
}
