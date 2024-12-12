package oncall.model;

import java.util.HashMap;
import java.util.List;
import oncall.enums.Day;
import oncall.enums.Month;

public class OncallMonth {
    Month month;
    Day startDay;
    HashMap<Integer, Day> day;

    public OncallMonth(List<String> monthDayInput) {
        String month = monthDayInput.get(0);
        String day = monthDayInput.get(1);
        this.month = Month.getMonthByNumber(Integer.parseInt(month));
        this.startDay = Day.getDayByOrder(day);
    }
}
