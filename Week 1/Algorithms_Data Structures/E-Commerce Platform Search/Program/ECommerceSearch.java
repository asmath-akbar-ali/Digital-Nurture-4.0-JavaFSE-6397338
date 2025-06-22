import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class ECommerceSearch {

    public static void main(String[] args) {
        Product[] products = {
            new Product(201, "Television", "Electronics"),
            new Product(202, "Fruits", "Grocery"),
            new Product(203, "Watch", "Accessories"),
            new Product(204, "Water", "Beverages"),
            new Product(205, "Shoes", "Footwear")
        };

        String searchTerm = "Watch";

		long start=System.nanoTime();
        Product result1 = linearSearch(products, searchTerm);
        if (result1 != null)
            System.out.println("Linear Search: Found " + result1.productName + " in " + result1.category);
        else
            System.out.println("Linear Search: Product not found");
		long end=System.nanoTime();
		System.out.println("Time take by Linear Search: "+(end-start)+" nano-seconds");
		System.out.println();


		start=System.nanoTime();
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
        Product result2 = binarySearch(products, searchTerm);
        if (result2 != null)
            System.out.println("Binary Search: Found " + result2.productName + " in " + result2.category);
        else
            System.out.println("Binary Search: Product not found");
		end=System.nanoTime();
		System.out.println("Time take by Binary Search: "+(end-start)+" nano-seconds");
		System.out.println();
    }

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }
}
