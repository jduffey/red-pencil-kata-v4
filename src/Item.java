/**
 * Created by jedduffey on 3/29/17.
 */
public class Item {

    private int currentPrice;
    private int newPrice;
    private int daysSinceLastPriceChange;
    private int daysSincePromoBecameActive;
    private int priceAtTimeOfPromoActivation;

    public Item(int currentPrice, int newPrice, int daysSinceLastPriceChange, int daysSincePromoBecameActive, int priceAtTimeOfPromotActivation) {
        this.currentPrice = currentPrice;
        this.newPrice = newPrice;
        this.daysSinceLastPriceChange = daysSinceLastPriceChange;
        this.daysSincePromoBecameActive = daysSincePromoBecameActive;
        this.priceAtTimeOfPromoActivation = priceAtTimeOfPromotActivation;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public int getDaysSinceLastPriceChange() {
        return daysSinceLastPriceChange;
    }

    public int getDaysSincePromoBecameActive() {
        return daysSincePromoBecameActive;
    }

    public int getPriceAtTimeOfPromoActivation() {
        return priceAtTimeOfPromoActivation;
    }
}
