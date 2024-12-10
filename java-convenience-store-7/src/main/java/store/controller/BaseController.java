package store.controller;

import java.util.function.Supplier;
import store.view.ErrorView;
import store.view.PurchaseView;
import store.view.StockInfoView;

public class BaseController {
    protected final ErrorView errorView = new ErrorView();
    protected final StockInfoView stockInfoView = new StockInfoView();
    protected final PurchaseView purchaseView = new PurchaseView();


    protected <T> T retryUntilSuccess(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                errorView.displayError(exception.getMessage());
            }
        }
    }
}
