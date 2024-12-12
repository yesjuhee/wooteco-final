package oncall.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import oncall.enums.Day;

public class OncallBatch {
    private HashMap<Integer, String> batch = new HashMap<>(); // 날짜, 이름

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

    public void batchHolidayWorker(Workers holidayWorkers, OncallMonth oncallMonth) {
        LinkedHashMap<Integer, Day> dates = oncallMonth.getDates();
        for (Integer date : dates.keySet()) {
            if (oncallMonth.isHoliday(date)) {
                batch.put(date, holidayWorkers.getNext());
            }
        }
    }

    public void handleConsecutiveWorkers(OncallMonth oncallMonth) {
        int lastDate = oncallMonth.getLastDate();
        for (int date = 1; date < lastDate; date++) {
            String cur = batch.get(date);
            String next = batch.getOrDefault(date + 1, "");
            if (cur.equals(next)) {
                switchWorker(date + 1, oncallMonth);
            }
        }
    }

    // 맨 뒤의 순서였을 경우 예외 처리
    private void switchWorker(int date, OncallMonth oncallMonth) {
        int nextDate = findNextDate(date, oncallMonth);
        String prevWorker = batch.get(date);
        String nextWorker = batch.get(nextDate);
        batch.put(date, nextWorker);
        batch.put(nextDate, prevWorker);
    }

    private int findNextDate(int date, OncallMonth oncallMonth) {
        if (oncallMonth.isHoliday(date)) {
            return nextHoliday(date, oncallMonth);
        }
        return nextWeekday(date, oncallMonth);
    }

    private int nextHoliday(int date, OncallMonth oncallMonth) {
        int cur = date + 1;
        while (!oncallMonth.isHoliday(cur)) {
            cur++;
        }
        return cur;
    }

    private int nextWeekday(int date, OncallMonth oncallMonth) {
        int cur = date + 1;
        while (oncallMonth.isHoliday(cur)) {
            cur++;
        }
        return cur;
    }
}
