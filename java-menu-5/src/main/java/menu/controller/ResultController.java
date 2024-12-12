package menu.controller;

import java.util.List;
import menu.common.enums.Menu;
import menu.model.Coaches;
import menu.model.WeeklyCategories;

public class ResultController extends BaseController {
    public WeeklyCategories pickCategories() {
        List<Menu> weeklyCategories = Menu.getWeeklyCategories();
        return new WeeklyCategories(weeklyCategories);
    }

    public void suggestMenu(Coaches coaches, WeeklyCategories weeklyCategories) {
        coaches.suggestMenu(weeklyCategories);
    }

    public void displayResult(Coaches coaches, WeeklyCategories weeklyCategories) {
        resultView.displayCategories(weeklyCategories);
        resultView.displayCoaches(coaches);
    }
}
