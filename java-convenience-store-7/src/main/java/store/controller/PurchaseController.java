package store.controller;

import java.util.HashMap;
import store.model.Products;
import store.model.Purchases;
import store.view.PurchaseView;

public class PurchaseController {

    private final PurchaseView purchaseView = new PurchaseView();

    public Purchases purchase(Products products) {
        HashMap<String, Integer> input = purchaseView.readPurchaseInfo();
        return new Purchases(input, products);
    }
}
