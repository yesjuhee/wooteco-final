package menu.controller;

import java.util.function.Supplier;
import menu.view.ErrorView;
import menu.view.ExclusionInputView;
import menu.view.NameInputView;
import menu.view.ResultView;

public class BaseController {
    protected final ErrorView errorView = new ErrorView();
    protected final NameInputView nameInputView = new NameInputView();
    protected final ExclusionInputView exclusionInputView = new ExclusionInputView();
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
