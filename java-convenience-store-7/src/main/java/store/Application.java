package store;

import store.controller.PurchaseController;
import store.controller.ReceiptController;
import store.controller.StockInfoController;
import store.controller.YesOrNoQuestionController;
import store.model.FreeProducts;
import store.model.Membership;
import store.model.Products;
import store.model.Purchases;

public class Application {
    private final StockInfoController stockInfoController = new StockInfoController();
    private final PurchaseController purchaseController = new PurchaseController();
    private final ReceiptController receiptController = new ReceiptController();
    private final YesOrNoQuestionController yesOrNoQuestionController = new YesOrNoQuestionController();

    public void run() {
        do {
            Products products = stockInfoController.loadProductFile();
            stockInfoController.displayStockInfo(products);
            Purchases purchases = purchaseController.purchase(products);
            FreeProducts freeProducts = yesOrNoQuestionController.addPromotionProduct(purchases);
            yesOrNoQuestionController.promotionOutOfStock(products, purchases);
            Membership membership = yesOrNoQuestionController.membership(purchases, freeProducts);
            receiptController.displayReceipt(purchases, freeProducts, membership);
            stockInfoController.storeProductFile(products, purchases);
        } while (yesOrNoQuestionController.continuePurchase());
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
