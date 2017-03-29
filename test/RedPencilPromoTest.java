import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromoTest {

    @Test
    public void itemClassShouldExistAndTakeInputs(){
        Item testObject = new Item(100, 100, 60, 0, 100);
    }

    @Test
    public void redPencilPromoClassShouldExistAndReturnFalseWhenConditionsForPromoAreNotMet(){
        Item testObject = new Item(100, 100, 60, 0, 100);
        RedPencilPromo testPromo = new RedPencilPromo();
        assertEquals(false, testPromo.isPromoActive(testObject));
    }
}
