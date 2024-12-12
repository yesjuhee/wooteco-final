package menu.view;

import static menu.common.constants.MenuConstant.DELIMITER;
import static menu.common.constants.MenuConstant.MAX_EXCLUSION_COUNT;
import static menu.common.enums.ErrorMessage.INVALID_EXCLUSION_COUNT;
import static menu.common.enums.OutputMessage.EXCLUDE_MENU;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExclusionInputView {
    public List<String> readExclusion(String coachName) {
        String menuNameInput = readMenuName(coachName);
        if (menuNameInput.isEmpty() || menuNameInput.isBlank()) {
            return null;
        }
        validateCount(menuNameInput);
        return Arrays.stream(menuNameInput.split(DELIMITER)).map(String::trim).collect(Collectors.toList());
    }

    private String readMenuName(String coachName) {
        System.out.printf(EXCLUDE_MENU.getFormatMessage(coachName));
        return Console.readLine();
    }

    private void validateCount(String input) {
        if (input.split(DELIMITER).length > MAX_EXCLUSION_COUNT) {
            throw new IllegalArgumentException(INVALID_EXCLUSION_COUNT.getFormatMessage(MAX_EXCLUSION_COUNT));
        }
    }
}
