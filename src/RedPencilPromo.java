/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {
    public boolean isPromoActive(Item testItem) {

        if (didThePriceIncrease(testItem)) return false;

        if (didThePriceNotDropEnough(testItem)) return false;

        return true;

    }

    private boolean didThePriceNotDropEnough(Item testItem) {
        if (testItem.getCurrentPrice() != testItem.getNewPrice()){
        double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice())/testItem.getPriceAtTimeOfPromoActivation();
        return percentagePriceDropFromPrePromoPrice < .05;}
        return false;
    }

    private boolean didThePriceIncrease(Item testItem) {
        return testItem.getNewPrice() > testItem.getCurrentPrice();
    }
}
