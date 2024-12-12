package oncall.view;

import static oncall.constant.Constants.DELIMITER;
import static oncall.enums.OutputMessage.INPUT_HOLIDAY_WORKERS;
import static oncall.enums.OutputMessage.INPUT_WEEKDAY_WORKERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class OncallInputView {
    public List<String> readWeekdayWorkers() {
        System.out.printf(INPUT_WEEKDAY_WORKERS.getMessage());
        String input = Console.readLine();
        List<String> workerNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        return workerNames;
    }

    public List<String> readHolidayWorkers() {
        System.out.printf(INPUT_HOLIDAY_WORKERS.getMessage());
        String input = Console.readLine();
        List<String> workerNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        return workerNames;
    }
}
