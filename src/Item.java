/**
 * Created by jedduffey on 3/29/17.
 */
public class Item {

    private double currentPrice;
    private double newPrice;
    private int daysSinceLastPriceChange;
    private int daysSincePromoBecameActive;
    private double priceAtTimeOfPromoActivation;

    public Item(int currentPrice, int newPrice, int daysSinceLastPriceChange, int daysSincePromoBecameActive, int priceAtTimeOfPromotActivation) {
        this.currentPrice = currentPrice;
        this.newPrice = newPrice;
        this.daysSinceLastPriceChange = daysSinceLastPriceChange;
        this.daysSincePromoBecameActive = daysSincePromoBecameActive;
        this.priceAtTimeOfPromoActivation = priceAtTimeOfPromotActivation;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public int getDaysSinceLastPriceChange() {
        return daysSinceLastPriceChange;
    }

    public int getDaysSincePromoBecameActive() {
        return daysSincePromoBecameActive;
    }

    public double getPriceAtTimeOfPromoActivation() {
        return priceAtTimeOfPromoActivation;
    }
}
