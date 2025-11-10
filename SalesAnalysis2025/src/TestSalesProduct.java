import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSalesProduct {

    int[][] data = {
            {300, 150, 700},
            {250, 200, 600}
    };

    SalesProduct sales = new SalesProduct();

    @Test
    public void CalculateTotalOfSales_ReturnsTotalOfSales() {
        int total = sales.TotalOfSales(data);
        assertEquals(2200, total);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        double average = sales.AverageSales(data);
        assertEquals(366.6, average, 0.1);
    }

    @Test
    public void MaxSale_ReturnsMaxSale() {
        int max = sales.MaxSale(data);
        assertEquals(700, max);
    }

    @Test
    public void MinSale_ReturnsMinSale() {
        int min = sales.MinSale(data);
        assertEquals(150, min);
    }
}
