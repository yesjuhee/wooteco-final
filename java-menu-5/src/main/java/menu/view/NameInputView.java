package menu.view;

import static menu.common.constants.MenuConstant.DELIMITER;
import static menu.common.constants.MenuConstant.MAX_COACH_COUNT;
import static menu.common.constants.MenuConstant.MAX_NAME_LENGTH;
import static menu.common.constants.MenuConstant.MIN_COACH_COUNT;
import static menu.common.constants.MenuConstant.MIN_NAME_LENGTH;
import static menu.common.enums.ErrorMessage.DUPLICATE_COACH_NAME;
import static menu.common.enums.ErrorMessage.INVALID_COACH_COUNT;
import static menu.common.enums.ErrorMessage.INVALID_NAME_LENGTH;
import static menu.common.enums.OutputMessage.INPUT_COACH_NAME;
import static menu.common.enums.OutputMessage.WELCOME;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NameInputView {
    public void displayWelcome() {
        System.out.printf(WELCOME.getFormatMessage());
    }

    public List<String> readCoachNames() {
        System.out.printf(INPUT_COACH_NAME.getFormatMessage());
        String input = Console.readLine();
        validate(input);
        return Arrays.stream(input.split(DELIMITER)).
                map(String::trim)
                .collect(Collectors.toList());
    }

    private void validate(String input) {
        List<String> coachNames = Arrays.stream(input.split(DELIMITER)).map(String::trim).collect(Collectors.toList());
        validateCoachCount(coachNames);
        validateDuplicates(coachNames);
        coachNames.forEach(this::validateCoachNameLength);
    }

    private void validateDuplicates(List<String> coachNames) {
        if (coachNames.size() != new HashSet<>(coachNames).size()) {
            throw new IllegalArgumentException(DUPLICATE_COACH_NAME.getFormatMessage());
        }
    }

    private void validateCoachCount(List<String> coachCount) {
        if (coachCount.size() < MIN_COACH_COUNT || coachCount.size() > MAX_COACH_COUNT) {
            throw new IllegalArgumentException(INVALID_COACH_COUNT.getFormatMessage(MIN_COACH_COUNT, MAX_COACH_COUNT));
        }
    }

    private void validateCoachNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH.getFormatMessage(MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }
}
