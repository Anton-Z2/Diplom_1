package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] ingredients() {
        return new Object[][]{
                {IngredientType.FILLING, "cutlet", 100.0f},
                {IngredientType.SAUCE, "sour cream", 200.0f}
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }


    @Test
    public void getTypeTest() {
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void getNameTest() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, ingredient.getPrice(), 0.0f);
    }
}
