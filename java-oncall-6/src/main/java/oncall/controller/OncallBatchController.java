package oncall.controller;

import oncall.model.HolidayWorkers;
import oncall.model.OncallBatch;
import oncall.model.OncallMonth;
import oncall.model.WeekdayWorkers;

public class OncallBatchController extends BaseController {
    public void readWorkers(WeekdayWorkers weekdayWorkers, HolidayWorkers holidayWorkers) {
        System.out.println("readWorkers");
    }

    public void bathWeekWorkers(WeekdayWorkers weekdayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        System.out.println("bathWeekWorkers");
    }

    public void bathHolidayWorkers(HolidayWorkers holidayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        System.out.println("bathHolidayWorkers");
    }

    public void handleConsecutiveWorkers(OncallBatch oncallBatch, OncallMonth oncallMonth) {
        System.out.println("handleConsecutiveWorkers");
    }
}
