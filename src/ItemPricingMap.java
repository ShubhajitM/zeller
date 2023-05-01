import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

public class ItemPricingMap {
    private static ConcurrentHashMap<Sku, BigDecimal> map = new ConcurrentHashMap<>();

    static {
        map.put(Sku.ipd, new BigDecimal("549.99"));
        map.put(Sku.mbp,new BigDecimal("1399.99"));
        map.put(Sku.atv,new BigDecimal("109.50"));
        map.put(Sku.vga,new BigDecimal("30.00"));
    }

    public static BigDecimal getPriceOfItem (Sku sku) {
        return map.getOrDefault(sku, BigDecimal.ZERO);
    }
}
