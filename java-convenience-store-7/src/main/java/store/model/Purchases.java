package store.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Purchases {
    Map<Product, Integer> purchases = new HashMap<>();

    public Purchases(HashMap<String, Integer> input, Products products) {
        for (Entry<String, Integer> purchase : input.entrySet()) {
            String productName = purchase.getKey();
            Integer quantity = purchase.getValue();
            purchases.put(products.getProduct(productName), quantity);
        }
    }
}
