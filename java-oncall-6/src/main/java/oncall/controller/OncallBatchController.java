package oncall.controller;

import oncall.model.HolidayWorkers;
import oncall.model.OncallBatch;
import oncall.model.OncallMonth;
import oncall.model.WeekdayWorkers;

public class OncallBatchController extends BaseController {
    public void readWorkers(WeekdayWorkers weekdayWorkers, HolidayWorkers holidayWorkers) {
        System.out.println("readWorkers");
    }

    public void batchWeekWorkers(WeekdayWorkers weekdayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        System.out.println("batchWeekWorkers");
    }

    public void batchHolidayWorkers(HolidayWorkers holidayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        System.out.println("batchHolidayWorkers");
    }

    public void handleConsecutiveWorkers(OncallBatch oncallBatch, OncallMonth oncallMonth) {
        System.out.println("handleConsecutiveWorkers");
    }
}
