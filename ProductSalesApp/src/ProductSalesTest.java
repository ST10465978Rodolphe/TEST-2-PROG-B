import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    ProductSales sales = new ProductSales();

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        int over = sales.GetSalesOverLimit();
        assertEquals(2, over);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        int under = sales.GetSalesUnderLimit();
        assertEquals(4, under);
    }
}
