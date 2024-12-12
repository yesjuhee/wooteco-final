package oncall.controller;

import java.util.List;
import oncall.model.OncallMonth;

public class MonthDayController extends BaseController {
    public OncallMonth readMonthDay() {
        List<String> monthDayInput = retryUntilSuccess(monthDayInputView::readMonthDay);
        return new OncallMonth(monthDayInput);
    }
}
