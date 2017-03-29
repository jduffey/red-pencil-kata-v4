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
    public void shouldReturnFalseIfThereHasBeenAPriceIncreaseWhenPromoNotActive(){
        Item testItem = new Item(100, 110, 60, 0, 100);
        assertEquals(false, testPromo.isPromoActive(testItem));
    }

    @Test
    public void shouldReturnFalseIfEverythingIsGoodButPriceDroppedLessThanRequiredMinimum(){
        Item testItem = new Item(100, 99, 60, 0, 100);
        assertEquals(false, testPromo.isPromoActive(testItem));
    }
}
