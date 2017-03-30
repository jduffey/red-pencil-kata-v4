/**
 * Created by jedduffey on 3/29/17.
 */
public class RedPencilPromo {

    private final double MAXIMUM_PERCENTAGE_DROP = .30;
    private final double MINIMUM_PERCENTAGE_DROP = .05;
    private final int MAXIMUM_LENGTH_OF_PROMOTION = 30;
    private final int DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO = 30;

    public boolean isPromoActive(Item testItem) {

        if (!didThePriceNotIncrease(testItem)) return false;

        if (!didThePriceChangeAndFallInsideOfTheAcceptableRange(testItem)) return false;

        if (!hasThePromoNotGoneOverItsMaxAllowedDays(testItem)) return false;

        if (!checkIfWhenPromoNotActiveWasPriceNotChangedTooRecently(testItem)) return false;

        return true;

    }

    private boolean checkIfWhenPromoNotActiveWasPriceNotChangedTooRecently(Item testItem) {
        if (testItem.getDaysSincePromoBecameActive() == 0 && testItem.getDaysSinceLastPriceChange() > DAYS_PRICE_MUST_REMAIN_STABLE_TO_ACTIVATE_PROMO) return true;
        return false;
    }

    private boolean hasThePromoNotGoneOverItsMaxAllowedDays(Item testItem) {
        if (testItem.getDaysSincePromoBecameActive() <= MAXIMUM_LENGTH_OF_PROMOTION) return true;
        return false;
    }

    private boolean didThePriceChangeAndFallInsideOfTheAcceptableRange(Item testItem) {
        if (testItem.getCurrentPrice() != testItem.getNewPrice()) {
            double percentagePriceDropFromPrePromoPrice = (testItem.getPriceAtTimeOfPromoActivation() - testItem.getNewPrice()) / testItem.getPriceAtTimeOfPromoActivation();
            return percentagePriceDropFromPrePromoPrice < MAXIMUM_PERCENTAGE_DROP && percentagePriceDropFromPrePromoPrice > MINIMUM_PERCENTAGE_DROP;
        }
        return false;
    }

    private boolean didThePriceNotIncrease(Item testItem) {
        return testItem.getNewPrice() <= testItem.getCurrentPrice();
    }
}
