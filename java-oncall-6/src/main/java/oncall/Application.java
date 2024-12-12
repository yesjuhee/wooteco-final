package oncall;

import oncall.controller.MonthDayController;
import oncall.controller.OncallBatchController;
import oncall.controller.OutputController;
import oncall.model.HolidayWorkers;
import oncall.model.OncallBatch;
import oncall.model.OncallMonth;
import oncall.model.WeekdayWorkers;

public class Application {
    MonthDayController monthDayController = new MonthDayController();
    OncallBatchController oncallBatchController = new OncallBatchController();
    OutputController outputController = new OutputController();
    WeekdayWorkers weekdayWorkers;
    HolidayWorkers holidayWorkers;
    OncallBatch oncallBatch;

    public void run() {
        OncallMonth oncallMonth = monthDayController.readMonthDay();
        oncallBatchController.readWorkers(weekdayWorkers, holidayWorkers);
        oncallBatchController.batchWeekWorkers(weekdayWorkers, oncallMonth, oncallBatch);
        oncallBatchController.batchHolidayWorkers(holidayWorkers, oncallMonth, oncallBatch);
        oncallBatchController.handleConsecutiveWorkers(oncallBatch, oncallMonth);
        outputController.displayResult(oncallBatch, oncallMonth);
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
