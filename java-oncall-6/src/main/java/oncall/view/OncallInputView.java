package oncall.view;

import static oncall.constant.Constants.DELIMITER;
import static oncall.constant.Constants.MAX_WORKER_COUNT;
import static oncall.constant.Constants.MIN_WORKER_COUNT;
import static oncall.enums.OutputMessage.INPUT_HOLIDAY_WORKERS;
import static oncall.enums.OutputMessage.INPUT_WEEKDAY_WORKERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import oncall.enums.ErrorMessage;

public class OncallInputView {
    public List<List<String>> readWorkers() {
        List<String> weekdayWorkers = readWeekdayWorkers();
        List<String> readHolidayWorkers = readHolidayWorkers();
        return List.of(weekdayWorkers, readHolidayWorkers);
    }

    private List<String> readWeekdayWorkers() {
        System.out.printf(INPUT_WEEKDAY_WORKERS.getMessage());
        String input = Console.readLine();
        List<String> workerNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        validateWorkerNameCount(workerNames);
        return workerNames;
    }

    private List<String> readHolidayWorkers() {
        System.out.printf(INPUT_HOLIDAY_WORKERS.getMessage());
        String input = Console.readLine();
        List<String> workerNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        validateWorkerNameCount(workerNames);
        return workerNames;
    }

    private void validateWorkerNameCount(List<String> workerNames) {
        if (workerNames.size() < MIN_WORKER_COUNT || workerNames.size() > MAX_WORKER_COUNT) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WORKER_COUNT.getMessage(MIN_WORKER_COUNT, MAX_WORKER_COUNT));
        }
    }

}
