import java.util.concurrent.ConcurrentHashMap;

public class ItemInventory {
    private static ConcurrentHashMap<Sku,Integer> itemInventoryMap = new ConcurrentHashMap<>();

    static {
        itemInventoryMap.put(Sku.ipd, 1000);
        itemInventoryMap.put(Sku.mbp,1000);
        itemInventoryMap.put(Sku.atv,1000);
        itemInventoryMap.put(Sku.vga,1000);
    }

    public static boolean checkIfProductAvailable (Sku sku){
        return itemInventoryMap.getOrDefault(sku, 0) > 0;
    }
}
