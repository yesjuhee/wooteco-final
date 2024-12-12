package oncall.model;

import java.util.LinkedHashMap;
import java.util.List;
import oncall.enums.Day;
import oncall.enums.Month;

public class OncallMonth {
    private final Month month;
    private final Day startDay;
    private final LinkedHashMap<Integer, Day> dates = new LinkedHashMap<>();

    public OncallMonth(List<String> monthDayInput) {
        String month = monthDayInput.get(0);
        String startDay = monthDayInput.get(1);
        this.month = Month.getMonthByNumber(Integer.parseInt(month));
        this.startDay = Day.getDayByName(startDay);
        setDayInfo();
    }

    private void setDayInfo() {
        int lastDate = month.getLastDate();
        Day day = this.startDay;
        for (int date = 1; date <= lastDate; date++) {
            this.dates.put(date, day);
            day = day.getNextDay();
        }
    }

    public LinkedHashMap<Integer, Day> getDates() {
        return dates;
    }

    public boolean isHoliday(Integer date) {
        Day day = dates.get(date);
        if (day.isHoliday() || month.isSpecialHoliday(date)) {
            return true;
        }
        return false;
    }

    public int getLastDate() {
        return month.getLastDate();
    }
}
