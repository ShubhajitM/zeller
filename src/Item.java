public class Item {
    private double price;
    private Sku sku;

    public Item ( Sku sku){
        this.sku = sku;
    }
    public Item(double price, Sku sku) {
        this.price = price;
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public Sku getSku() {
        return sku;
    }
}
