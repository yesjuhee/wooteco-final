package oncall.view;

import static oncall.enums.OutputMessage.SCHEDULE;
import static oncall.enums.OutputMessage.SPECIAL_HOLIDAY_SCHEDULE;

import java.util.Map.Entry;
import oncall.model.OncallBatch;
import oncall.model.OncallMonth;

public class ResultView {
    public void displayResult(OncallBatch oncallBatch, OncallMonth oncallMonth) {
        for (Entry<Integer, String> batch : oncallBatch.getBatch()) {
            if (oncallMonth.isSpecialHoliday(batch.getKey())) {
                System.out.printf(SPECIAL_HOLIDAY_SCHEDULE.getMessage(oncallMonth.getMonthNumber(), batch.getKey(),
                        oncallMonth.getDayString(batch.getKey()), batch.getValue()));
                continue;
            }
            System.out.printf(
                    SCHEDULE.getMessage(oncallMonth.getMonthNumber(), batch.getKey(), oncallMonth.getDayString(
                            batch.getKey()), batch.getValue()));
        }
    }
}
