package menu.view;

import static menu.common.constants.MenuConstant.FRI;
import static menu.common.constants.MenuConstant.MON;
import static menu.common.constants.MenuConstant.THUR;
import static menu.common.constants.MenuConstant.TUES;
import static menu.common.constants.MenuConstant.WED;
import static menu.common.enums.OutputMessage.CATEGORY_RESULT;
import static menu.common.enums.OutputMessage.COACH_RESULT;
import static menu.common.enums.OutputMessage.DAY;
import static menu.common.enums.OutputMessage.EXIT;
import static menu.common.enums.OutputMessage.RESULT_HEADER;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.model.WeeklyCategories;

public class ResultView {
    public void displayCategories(WeeklyCategories weeklyCategories) {
        System.out.printf(RESULT_HEADER.getFormatMessage());
        System.out.printf(DAY.getFormatMessage());
        List<String> weeklyCategoryNames = weeklyCategories.getCategoryNames();
        System.out.printf(
                CATEGORY_RESULT.getFormatMessage(weeklyCategoryNames.get(MON), weeklyCategoryNames.get(TUES),
                        weeklyCategoryNames.get(WED),
                        weeklyCategoryNames.get(THUR), weeklyCategoryNames.get(FRI)));
    }

    public void displayCoaches(Coaches coaches) {
        coaches.getCoaches().forEach(this::displayCoach);
        System.out.printf(EXIT.getFormatMessage());
    }

    private void displayCoach(Coach coach) {
        String name = coach.getName();
        List<String> suggestion = coach.getSuggestionMenuNames();
        System.out.printf(
                COACH_RESULT.getFormatMessage(name, suggestion.get(MON), suggestion.get(TUES), suggestion.get(WED),
                        suggestion.get(THUR), suggestion.get(FRI)));
    }
}
