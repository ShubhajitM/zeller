import java.math.BigDecimal;

public class AppleTvPricingRule implements PricingRule{

    @Override
    public BigDecimal apply(ShoppingCart shoppingCart) {
        int count = shoppingCart.getItemCountInCart(Sku.atv);
        int freeItems = count /3;
        return ItemPricingMap.getPriceOfItem(Sku.atv).multiply(BigDecimal.valueOf(freeItems));
    }
}
