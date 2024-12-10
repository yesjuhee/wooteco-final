package store.controller;

import java.util.HashMap;
import store.model.Products;
import store.model.Purchases;

public class PurchaseController extends BaseController {
    public Purchases purchase(Products products) {
        return retryUntilSuccess(() -> {
            HashMap<String, Integer> input = purchaseView.readPurchaseInfo();
            return new Purchases(input, products);
        });

    }
}
