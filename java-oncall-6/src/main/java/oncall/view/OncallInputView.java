package oncall.view;

import static oncall.constant.Constants.DELIMITER;
import static oncall.constant.Constants.MAX_WORKER_COUNT;
import static oncall.constant.Constants.MAX_WORKER_NAME_LENGTH;
import static oncall.constant.Constants.MIN_WORKER_COUNT;
import static oncall.enums.ErrorMessage.INVALID_WORKER_BATCH;
import static oncall.enums.ErrorMessage.INVALID_WORKER_NAME_EMPTY;
import static oncall.enums.ErrorMessage.INVALID_WORKER_NAME_LENGTH;
import static oncall.enums.OutputMessage.INPUT_HOLIDAY_WORKERS;
import static oncall.enums.OutputMessage.INPUT_WEEKDAY_WORKERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
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
        validate(workerNames);
        return workerNames;
    }

    private List<String> readHolidayWorkers() {
        System.out.printf(INPUT_HOLIDAY_WORKERS.getMessage());
        String input = Console.readLine();
        List<String> workerNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        validate(workerNames);
        return workerNames;
    }

    private void validate(List<String> workerNames) {
        validateWorkerNameCount(workerNames);
        workerNames.forEach(this::validateWorkerNameLength);
        workerNames.forEach(this::validateWorkerNameExist);
        validateDuplicateName(workerNames);
    }

    private void validateDuplicateName(List<String> workerNames) {
        if (workerNames.size() != new HashSet<>(workerNames).size()) {
            throw new IllegalArgumentException(INVALID_WORKER_BATCH.getMessage());
        }
    }


    private void validateWorkerNameCount(List<String> workerNames) {
        if (workerNames.size() < MIN_WORKER_COUNT || workerNames.size() > MAX_WORKER_COUNT) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_WORKER_COUNT.getMessage(MIN_WORKER_COUNT, MAX_WORKER_COUNT));
        }
    }

    private void validateWorkerNameLength(String workerName) {
        if (workerName.length() > MAX_WORKER_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_WORKER_NAME_LENGTH.getMessage(MAX_WORKER_NAME_LENGTH));
        }
    }

    private void validateWorkerNameExist(String workerName) {
        if (workerName.isBlank() || workerName.isEmpty()) {
            throw new IllegalArgumentException(INVALID_WORKER_NAME_EMPTY.getMessage());
        }
    }
}
