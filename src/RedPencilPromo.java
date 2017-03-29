/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {

    private final double MAXIMUM_PERCENTAGE_DROP = .30;
    private final double MINIMUM_PERCENTAGE_DROP = .05;

    public boolean isPromoActive(Item testItem) {

        if (didThePriceIncrease(testItem)) return false;

        if (didThePriceNotDropEnough(testItem)) return false;

        if (didThePriceDropTooMuch(testItem)) return false;

        return true;

    }

    private boolean didThePriceDropTooMuch(Item testItem) {
        if (testItem.getCurrentPrice() != testItem.getNewPrice()) {
            double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice()) / testItem.getPriceAtTimeOfPromoActivation();
            return percentagePriceDropFromPrePromoPrice > MAXIMUM_PERCENTAGE_DROP;
        }
        return false;
    }

    private boolean didThePriceNotDropEnough(Item testItem) {
        if (testItem.getCurrentPrice() != testItem.getNewPrice()) {
            double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice()) / testItem.getPriceAtTimeOfPromoActivation();
            return percentagePriceDropFromPrePromoPrice < MINIMUM_PERCENTAGE_DROP;
        }
        return false;
    }

    private boolean didThePriceIncrease(Item testItem) {
        return testItem.getNewPrice() > testItem.getCurrentPrice();
    }
}
