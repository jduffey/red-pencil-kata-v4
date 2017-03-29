import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromoTest {

    private RedPencilPromo testPromo;

    @Before
    public void setup(){
        testPromo = new RedPencilPromo();
    }

    @Test
    public void itemClassShouldExistAndTakeInputs(){
        Item testItem = new Item(100, 100, 60, 0, 100);
        assertEquals(true, testItem == testItem);
    }

    @Test
    public void redPencilPromoClassShouldExistAndReturnTrueWhenConditionsForPromoAreMet(){
        Item testItem = new Item(100, 75, 60, 0, 100);
        assertEquals(true, testPromo.isPromoActive(testItem));
    }

    @Test
    public void shouldReturnFalseIfThereHasBeenAPriceIncreaseWhetherPromoIsActiveOrNot(){
        Item testItem1 = new Item(100, 110, 60, 0, 100);
        Item testItem2 = new Item(75, 80, 15, 15, 100);
        assertEquals(false, testPromo.isPromoActive(testItem1));
        assertEquals(false, testPromo.isPromoActive(testItem2));
    }

    @Test
    public void shouldReturnFalseIfEverythingIsGoodButPriceDroppedLessThanRequiredMinimum(){
        Item testItem = new Item(100, 96, 60, 0, 100);
        assertEquals(false, testPromo.isPromoActive(testItem));
    }

    @Test
    public void shouldReturnFalseIfEverythingIsGoodButPriceDroppedMoreThanAllowedMaximum(){
        Item testItem = new Item(100, 69, 60, 0, 100);
        assertEquals(false, testPromo.isPromoActive(testItem));
    }

    @Test
    public void shouldReturnFalseIfPromoHasLastedMoreThanTheMaxAmountOfDays(){
        Item testItem = new Item(75, 75, 20, 31, 100);
        assertEquals(false, testPromo.isPromoActive(testItem));
    }
}
