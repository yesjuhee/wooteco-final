package oncall.controller;

import java.util.function.Supplier;
import oncall.view.ErrorView;
import oncall.view.MonthDayInputView;
import oncall.view.OncallInputView;
import oncall.view.ResultView;

public class BaseController {
    protected final ErrorView errorView = new ErrorView();
    protected final MonthDayInputView monthDayInputView = new MonthDayInputView();
    protected final OncallInputView oncallInputView = new OncallInputView();
    protected final ResultView resultView = new ResultView();

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
