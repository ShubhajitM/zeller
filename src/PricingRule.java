import java.math.BigDecimal;

public interface PricingRule {
    BigDecimal apply (ShoppingCart shoppingCart);
}
