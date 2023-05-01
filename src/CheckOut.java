import java.math.BigDecimal;

public interface CheckOut {
    void scan (Item item);
    BigDecimal total();
}
