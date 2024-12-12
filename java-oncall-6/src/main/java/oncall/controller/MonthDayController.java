package oncall.controller;

import java.util.List;
import oncall.model.OncallMonth;

public class MonthDayController extends BaseController {
    public OncallMonth readMonthDay() {
        List<String> monthDayInput = monthDayInputView.readMonthDay();
        return new OncallMonth(monthDayInput);
    }

    public void saveOncallMonthInfo(OncallMonth oncallMonth) {
        System.out.println("saveOncallMonthInfo");
    }
}
