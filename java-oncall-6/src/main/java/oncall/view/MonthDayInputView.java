package oncall.view;

import static oncall.constant.Constants.DELIMITER;
import static oncall.enums.OutputMessage.INPUT_MONTH_DAY;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class MonthDayInputView {
    public List<String> readMonthDay() {
        System.out.printf(INPUT_MONTH_DAY.getMessage());
        String input = Console.readLine();
        return Arrays.stream(input.split(DELIMITER)).map(String::trim).toList();
    }
}
