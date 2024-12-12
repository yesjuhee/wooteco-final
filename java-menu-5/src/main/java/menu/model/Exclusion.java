package menu.model;

import static menu.common.enums.ErrorMessage.INVALID_MENU;

import java.util.List;
import menu.common.enums.Menu;

public class Exclusion {
    private final List<String> menu;

    public Exclusion(List<String> menu) {
        if (menu == null) {
            this.menu = null;
            return;
        }
        menu.forEach(this::validate);
        this.menu = menu;
    }

    private void validate(String menu) {
        if (Menu.notContains(menu)) {
            throw new IllegalArgumentException(INVALID_MENU.getFormatMessage(menu));
        }
    }
}
