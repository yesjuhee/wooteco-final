package menu.model;

import static menu.common.enums.ErrorMessage.INVALID_MENU;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.common.enums.Menu;

public class Coach {
    private final String name;
    private Exclusion exclusion;
    private Suggestion suggestion;

    public Coach(String name) {
        this.name = name;
        this.suggestion = new Suggestion();
    }

    public String getName() {
        return name;
    }

    public void updateExclusion(List<String> menu) {
        if (menu == null) {
            this.exclusion = new Exclusion(null); // TODO 여기 이러면 안되는데..! 임시방편
            return;
        }
        menu.forEach(this::validateMenuExist);
        this.exclusion = new Exclusion(menu);
    }

    private void validateMenuExist(String menuName) {
        if (Menu.notContains(menuName)) {
            throw new IllegalArgumentException(INVALID_MENU.getFormatMessage(menuName));
        }
    }

    public void suggestMenu(Menu categoryOfDay) {
        String selectedMenuName;
        do {
            selectedMenuName = Randoms.shuffle(categoryOfDay.getMenu()).get(0);
        }
        while (suggestion.contain(selectedMenuName));
        suggestion.putMenuName(selectedMenuName);
    }

    public List<String> getSuggestionMenuNames() {
        return suggestion.getSuggestedMenus();
    }

}
