import java.math.BigDecimal;
import java.util.List;

public class CheckOutImpl implements CheckOut{

    private List<PricingRule> pricingRuleList;

    CheckOutImpl(List<PricingRule> pricingRuleList){
        this.pricingRuleList = pricingRuleList;
    }

    private ShoppingCart shoppingCart = new ShoppingCart();

    @Override
    public void scan(Item item) {
        //check if product available
        if (ItemInventory.checkIfProductAvailable(item.getSku())){
            shoppingCart.addItemInCart(item);
        }else {
            throw new RuntimeException("Order can't be fulfilled for this item: " + item.getSku());
        }
    }

    @Override
    public BigDecimal total() {
        for (PricingRule rule: pricingRuleList) {
            shoppingCart.addDiscount(rule.apply(shoppingCart));
        }
        var netTotal =  shoppingCart.getTotalPrice().subtract(shoppingCart.getTotalDiscount());
        cleanUpAction();
        return netTotal;
    }


    private void cleanUpAction () {
        //TODO - remove from ItemInventory
        shoppingCart = new ShoppingCart();
    }
}
