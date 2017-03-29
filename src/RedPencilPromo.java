/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {
    public boolean isPromoActive(Item testObject) {
        if (didThePriceIncrease(testObject)) return false;
        return false;
    }

    private boolean didThePriceIncrease(Item testItem) {
        return testItem.getNewPrice() > testItem.getCurrentPrice();
    }
}
