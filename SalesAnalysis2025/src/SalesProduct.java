public class SalesProduct implements Product {

    @Override
    public int TotalOfSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int total = 0;
        int count = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
                count++;
            }
        }
        return (double) total / count;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}
