public class Main {
    public static void main(String[] args) {


        int[][] salesData = {
                {300, 150, 700},
                {250, 200, 600}
        };


        SalesProduct salesReport = new SalesProduct();


        int total = salesReport.TotalOfSales(salesData);
        double average = salesReport.AverageSales(salesData);
        int max = salesReport.MaxSale(salesData);
        int min = salesReport.MinSale(salesData);


        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + (int) average);
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);
    }
}
