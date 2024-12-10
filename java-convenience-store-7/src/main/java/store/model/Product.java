package store.model;

import static store.common.enums.ErrorMessage.OUT_OF_STOCK;

public class Product {
    private final String name;
    private final int price;
    private int baseQuantity;
    private Promotion promotion;
    private int promotionQuantity;

    public Product(String name, String price) {
        this.name = name;
        this.price = Integer.parseInt(price);
    }

    public void updateBaseQuantity(String baseQuantity) {
        this.baseQuantity = Integer.parseInt(baseQuantity);
    }

    public void updatePromotionInfo(String promotionName, String promotionQuantity, Promotions promotions) {
        this.promotion = promotions.findPromotionByName(promotionName);
        this.promotionQuantity = Integer.parseInt(promotionQuantity);
    }

    public void validatePurchaseQuantity(Integer quantity) {
        if (quantity > baseQuantity + promotionQuantity) {
            throw new IllegalArgumentException(OUT_OF_STOCK.getFormatMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBaseQuantity() {
        return baseQuantity;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public int getPromotionQuantity() {
        return promotionQuantity;
    }

    public String getPromotionName() {
        if (promotion != null) {
            return promotion.getName();
        }
        return null;
    }
}
