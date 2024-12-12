package oncall.controller;

import java.util.List;
import oncall.model.OncallBatch;
import oncall.model.OncallMonth;
import oncall.model.Workers;

public class OncallBatchController extends BaseController {
    public void readWorkers(Workers weekdayWorkers, Workers holidayWorkers) {
        List<List<String>> workers = retryUntilSuccess(oncallInputView::readWorkers);
        List<String> weekdayWorkerInput = workers.get(0);
        List<String> holidayWorkerInput = workers.get(1);
        weekdayWorkers.saveWorkers(weekdayWorkerInput);
        holidayWorkers.saveWorkers(holidayWorkerInput);
    }

    public void batchWeekWorkers(Workers weekdayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        oncallBatch.batchWeekdayWorker(weekdayWorkers, oncallMonth);
    }

    public void batchHolidayWorkers(Workers holidayWorkers, OncallMonth oncallMonth, OncallBatch oncallBatch) {
        System.out.println("batchHolidayWorkers");
    }

    public void handleConsecutiveWorkers(OncallBatch oncallBatch, OncallMonth oncallMonth) {
        System.out.println("handleConsecutiveWorkers");
    }
}
