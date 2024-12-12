package oncall.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import oncall.enums.Day;

public class OncallBatch {
    private HashMap<Integer, String> batch = new LinkedHashMap<>(); // 날짜, 이름

    public OncallBatch() {
    }

    public void batchWeekdayWorker(Workers weekdayWorkers, OncallMonth oncallMonth) {
        LinkedHashMap<Integer, Day> dates = oncallMonth.getDates();
        for (Integer date : dates.keySet()) {
            if (!oncallMonth.isHoliday(date)) {
                batch.put(date, weekdayWorkers.getNext());
            }
        }
    }
}
