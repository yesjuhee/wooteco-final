package store.view;

import static store.common.enums.OutputMessage.PRODUCT;
import static store.common.enums.OutputMessage.PRODUCT_OUT_OF_STOCK;
import static store.common.enums.OutputMessage.PROMOTION_PRODUCT;
import static store.common.enums.OutputMessage.PROMOTION_PRODUCT_OUT_OF_STOCK;
import static store.common.enums.OutputMessage.WELCOME;

import store.model.Product;
import store.model.Products;

public class StockInfoView {
    public void displayStockInfo(final Products products) {
        System.out.printf(WELCOME.getFormatMessage());
        products.getProducts().forEach(this::displayProductInfo);
    }

    public void displayProductInfo(final Product product) {
        String name = product.getName();
        int price = product.getPrice();
        displayBaseProductInfo(name, price, product.getBaseQuantity());
        if (product.getPromotion() != null) {
            displayPromotionProductInfo(name, price, product.getPromotionQuantity(), product.getPromotionName());
        }
    }

    private void displayPromotionProductInfo(String name, int price, int quantity, String promotionName) {
        if (quantity == 0) {
            System.out.printf(PROMOTION_PRODUCT_OUT_OF_STOCK.getFormatMessage(name, price, promotionName));
            return;
        }
        System.out.printf(PROMOTION_PRODUCT.getFormatMessage(name, price, quantity, promotionName));
    }

    private void displayBaseProductInfo(String name, int price, int quantity) {
        if (quantity == 0) {
            System.out.printf(PRODUCT_OUT_OF_STOCK.getFormatMessage(name, price));
            return;
        }
        System.out.printf(PRODUCT.getFormatMessage(name, price, quantity));
    }
}
