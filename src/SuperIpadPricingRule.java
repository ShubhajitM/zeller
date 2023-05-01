import java.math.BigDecimal;

public class SuperIpadPricingRule implements PricingRule{
    @Override
    public BigDecimal apply(ShoppingCart shoppingCart) {
        int count = shoppingCart.getItemCountInCart(Sku.ipd);
        if (count > 4) {
            return (ItemPricingMap.getPriceOfItem(Sku.ipd).subtract(BigDecimal.valueOf(499.99))).multiply(BigDecimal.valueOf(count));
        }
        return BigDecimal.ZERO;
    }
}
