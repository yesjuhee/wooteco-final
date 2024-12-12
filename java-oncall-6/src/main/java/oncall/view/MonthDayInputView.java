package oncall.view;

import static oncall.constant.Constants.DELIMITER;
import static oncall.enums.ErrorMessage.INVALID_MONTH;
import static oncall.enums.ErrorMessage.INVALID_MONTH_DAY;
import static oncall.enums.OutputMessage.INPUT_MONTH_DAY;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class MonthDayInputView {
    private static final String POSITIVE_INTEGER_REGEX = "\\d+";

    public List<String> readMonthDay() {
        System.out.printf(INPUT_MONTH_DAY.getMessage());
        String input = Console.readLine();
        List<String> inputList = Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
        validateSize(inputList);
        validateMonth(inputList.get(0));
//        validateDay(inputList.get(1));
        return inputList;
    }

    private void validateMonth(String inputMonth) {
        if (!inputMonth.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException(INVALID_MONTH.getMessage());
        }
        int month = Integer.parseInt(inputMonth);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(INVALID_MONTH.getMessage());
        }
    }

    private void validateSize(List<String> inputList) {
        if (inputList.size() != 2) {
            throw new IllegalArgumentException(INVALID_MONTH_DAY.getMessage());
        }
    }
}
