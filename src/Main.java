import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PricingRule> pricingRuleList = new ArrayList<>();
        loadPricingRules(pricingRuleList);

        var ck = new CheckOutImpl(pricingRuleList);

        ck.scan(new Item(Sku.atv));
        ck.scan(new Item(Sku.ipd));
        ck.scan(new Item(Sku.ipd));
        ck.scan(new Item(Sku.atv));
        ck.scan(new Item(Sku.ipd));
        ck.scan(new Item(Sku.ipd));
        ck.scan(new Item(Sku.ipd));
        System.out.println(ck.total());
    }

    static void loadPricingRules (List<PricingRule> ruleList) {
        ruleList.add(new AppleTvPricingRule());
        ruleList.add(new SuperIpadPricingRule());
    }
}