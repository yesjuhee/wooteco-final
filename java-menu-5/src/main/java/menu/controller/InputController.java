package menu.controller;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;

public class InputController extends BaseController {
    public Coaches setCoachesName() {
        nameInputView.displayWelcome();
        List<String> names = retryUntilSuccess(nameInputView::readCoachNames);
        return new Coaches(names);
    }

    public void updateExclusion(Coaches coaches) {
        List<Coach> coachList = coaches.getCoaches();
        for (Coach coach : coachList) {
            List<String> menu = retryUntilSuccess(() -> exclusionInputView.readExclusion(coach.getName()));
            coach.updateExclusion(menu);
        }
    }
}
