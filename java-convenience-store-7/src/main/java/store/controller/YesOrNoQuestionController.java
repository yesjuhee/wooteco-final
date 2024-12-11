package store.controller;

import store.model.FreeProducts;
import store.model.Membership;
import store.model.Products;
import store.model.Purchases;

public class YesOrNoQuestionController {
    public FreeProducts addPromotionProduct(final Purchases purchases) {
        System.out.println("addPromotionProduct");
        return null;
    }

    public void promotionOutOfStock(final Products products, final Purchases purchases) {
        System.out.println("promotionOutOfStock");
    }

    public Membership membership(final Purchases purchases, final FreeProducts freeProducts) {
        System.out.println("membership");
        return null;
    }

    public boolean continuePurchase() {
        return false;
    }
}
