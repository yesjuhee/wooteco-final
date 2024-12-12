package menu;

import menu.controller.InputController;
import menu.controller.ResultController;
import menu.model.Coaches;
import menu.model.WeeklyCategories;

public class Application {
    InputController inputController = new InputController();
    ResultController resultController = new ResultController();

    public void run() {
        Coaches coaches = inputController.setCoachesName();
        inputController.updateExclusion(coaches);
        WeeklyCategories weeklyCategories = resultController.pickCategories();
        resultController.suggestMenu(coaches, weeklyCategories);
        resultController.displayResult(coaches, weeklyCategories);
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
