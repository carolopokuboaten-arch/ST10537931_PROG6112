**
 *
 * @author Carol
 */
public class PrintProduct {
     // Two‑dimensional array storing sales data 
        int[][] productSales = {
                {25, 15,18 },   // Number of sales for month 1
                {18 , 10 ,15},   // Number of sales for month 2 
                {20 , 12, 20}    // number of sales for month 3
                    
        };
  
String[] productnames = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress" , "Sealy Phuket mattress"};

       ProductNames productnamesCalculator = new ProductNames();

        // Calculate total sales for each product
        double[] totalSales = new double[2];
        double[] avaragenumber = new double[2];

    private static class ProductNames {

        public ProductNames() {
        }

        private int mostpopularproduct(double[] totalSales) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

       
        

        // Print product  SALES REPORT
    int averageSales = (int) Math.round((double) totalSales / salesCount);
        System.out.println("Enter number of sales for month 1");
    System.out.println("Enter number of sales for month 2");
    System.out.println("Enter number of sales for month 3");
    
       
        System.out.println("      PRODUCT SALES REPORT");
         System.out.println("********************************");
        System.out.println("PRODUCT\t\tMONTH 1\t\MONTH 2\t\t MONTH 3");
        for (int i = 0; i < 2; i++) {
            System.out.print(mattress[i] + "\t");
            System.out.print("" + productdata[i][0] + "\t");
            System.out.print("" + productdata[i][1] + "\t");
            System.out.println("" + productdata[i][2]);
        }
        System.out.println("\n");

        // Print total monthly sales for each MONTH
        System.out.println("TOTAL PRODUCT SALES  = "+ totalSales[0]);
        System.out.println("Average product sales = " + totalSales[1]);
        System.out.println("\n");

        
        // Find and print most popular product
        int mostpopularproductIndex = productnamesCalculator.mostpopularproduct(totalSales);
        System.out.println("MOST POPULAR PRODUCT: " + ProductName[popularproductIndex]);
    }
}
    
        
