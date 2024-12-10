package store.model;

import static store.common.constant.ProductFile.NAME;
import static store.common.constant.ProductFile.NULL;
import static store.common.constant.ProductFile.PRICE;
import static store.common.constant.ProductFile.PROMOTION;
import static store.common.constant.ProductFile.QUANTITY;
import static store.common.enums.ErrorMessage.PRODUCT_NOT_EXIST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {
    private final Map<String, Product> products = new HashMap<>();

    public Products(final List<List<String>> productsCSV, List<List<String>> promotionCSV) {
        Promotions promotions = new Promotions(promotionCSV);
        for (List<String> csvRow : productsCSV) {
            String name = csvRow.get(NAME);
            String price = csvRow.get(PRICE);
            String quantity = csvRow.get(QUANTITY);
            String promotion = csvRow.get(PROMOTION);
            Product product = products.getOrDefault(name, new Product(name, price));
            updateProduct(product, quantity, promotion, promotions);
            products.put(name, product);
        }
    }

    private void updateProduct(Product product, String quantity, String promotion, Promotions promotions) {
        if (promotion.equals(NULL)) {
            product.updateBaseQuantity(quantity);
            return;
        }
        product.updatePromotionInfo(promotion, quantity, promotions);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProduct(String productName) {
        validateProductName(productName);
        return products.get(productName);
    }

    public void validateProductName(String productName) {
        if (!products.containsKey(productName)) {
            throw new IllegalArgumentException(PRODUCT_NOT_EXIST.getFormatMessage());
        }
    }
}
