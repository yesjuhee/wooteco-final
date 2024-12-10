package store.controller;

import java.util.List;
import store.common.constant.ProductFile;
import store.common.constant.PromotionFile;
import store.common.utils.FileUtils;
import store.model.Products;
import store.model.Purchases;
import store.view.StockInfoView;

public class StockInfoController {
    private final StockInfoView stockInfoView = new StockInfoView();

    public Products loadProductFile() {
        List<List<String>> productData = FileUtils.readCSV(ProductFile.PATH);
        List<List<String>> promotionData = FileUtils.readCSV(PromotionFile.PATH);
        return new Products(productData, promotionData);
    }

    public void displayStockInfo(final Products products) {
        stockInfoView.displayStockInfo(products);
    }

    public void storeProductFile(final Products products, final Purchases purchases) {
        System.out.println("storeProductFile");
    }
}
