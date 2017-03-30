/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {

    private final double MAXIMUM_PERCENTAGE_DROP = .30;
    private final double MINIMUM_PERCENTAGE_DROP = .05;
    private final int MAXIMUM_LENGTH_OF_PROMOTION = 30;
    private final int DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO = 30;

    public boolean isPromoActive(Item testItem) {

        if (didThePriceIncrease(testItem)) return false;

        if (didThePriceChangeButFallOutsideOfTheAcceptableRange(testItem)) return false;

        if (hasThePromoGoneOverItsMaxAllowedDays(testItem)) return false;

        if (isPromoNotActiveButPriceWasChangedTooRecently(testItem)) return false;

        return true;

    }

    private boolean isPromoNotActiveButPriceWasChangedTooRecently(Item testItem) {
        if (testItem.getDaysSincePromoBecameActive() == 0 && testItem.getDaysSinceLastPriceChange() <= DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO) return true;
        return false;
    }

    private boolean hasThePromoGoneOverItsMaxAllowedDays(Item testItem) {
        if (testItem.getDaysSincePromoBecameActive() > MAXIMUM_LENGTH_OF_PROMOTION) return true;
        return false;
    }

    private boolean didThePriceChangeButFallOutsideOfTheAcceptableRange(Item testItem) {
        if (testItem.getCurrentPrice() != testItem.getNewPrice()) {
            double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice()) / testItem.getPriceAtTimeOfPromoActivation();
            return percentagePriceDropFromPrePromoPrice > MAXIMUM_PERCENTAGE_DROP || percentagePriceDropFromPrePromoPrice < MINIMUM_PERCENTAGE_DROP;
        }
        return false;
    }

    private boolean didThePriceIncrease(Item testItem) {
        return testItem.getNewPrice() > testItem.getCurrentPrice();
    }
}
