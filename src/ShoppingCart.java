import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Sku, Integer> checkOutList;
    private BigDecimal totalPrice;
    private BigDecimal totalDiscount;

    public ShoppingCart (){
        checkOutList = new HashMap<>();
        totalPrice = BigDecimal.ZERO;
        totalDiscount = BigDecimal.ZERO;
    }

    public int getItemCountInCart(Sku sku) {
        return checkOutList.getOrDefault(sku, 0);
    }

    public void addItemInCart(Item item) {
        checkOutList.put(item.getSku(), checkOutList.getOrDefault(item.getSku(), 0) + 1);
    }

    public BigDecimal getTotalPrice() {
        totalPrice = BigDecimal.ZERO;
        checkOutList.forEach((sku, quantity) -> totalPrice = totalPrice.add(
                BigDecimal.valueOf(quantity).multiply(ItemPricingMap.getPriceOfItem(sku))));
        return totalPrice;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void addDiscount(BigDecimal discount) {
        totalDiscount = totalDiscount.add(discount);
    }
}
