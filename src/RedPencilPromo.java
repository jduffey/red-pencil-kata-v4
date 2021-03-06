/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {

    private final double MAXIMUM_PERCENTAGE_DROP = .30;
    private final double MINIMUM_PERCENTAGE_DROP = .05;
    private final int MAXIMUM_LENGTH_OF_PROMOTION = 30;
    private final int DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO = 30;

    public boolean isPromoActive(Item testItem) {

        return didThePriceNotIncrease(testItem)
                && checkIfThePriceChangedDidItFallInsideOfTheAcceptableRange(testItem)
                && hasThePromoNotGoneOverItsMaxAllowedDays(testItem)
                && checkIfWhenPromoNotActiveWasPriceNotChangedTooRecently(testItem);

    }

    private boolean checkIfWhenPromoNotActiveWasPriceNotChangedTooRecently(Item testItem) {
        return testItem.getDaysSincePromoBecameActive() == 0
                && testItem.getDaysSinceLastPriceChange() > DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO;
    }

    private boolean hasThePromoNotGoneOverItsMaxAllowedDays(Item testItem) {
        return testItem.getDaysSincePromoBecameActive() <= MAXIMUM_LENGTH_OF_PROMOTION;
    }

    private boolean checkIfThePriceChangedDidItFallInsideOfTheAcceptableRange(Item testItem) {
        double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice()) / testItem.getPriceAtTimeOfPromoActivation();
        return (testItem.getCurrentPrice() != testItem.getNewPrice())
                && percentagePriceDropFromPrePromoPrice < MAXIMUM_PERCENTAGE_DROP
                && percentagePriceDropFromPrePromoPrice > MINIMUM_PERCENTAGE_DROP;
    }

    private boolean didThePriceNotIncrease(Item testItem) {
        return testItem.getNewPrice() <= testItem.getCurrentPrice();
    }
}
