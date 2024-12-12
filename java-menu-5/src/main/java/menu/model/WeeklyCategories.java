package menu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import menu.common.enums.Menu;

public class WeeklyCategories {
    LinkedHashMap<String, Menu> weeklyCategories = new LinkedHashMap<>();

    public WeeklyCategories(List<Menu> weeklyCategories) {
        weeklyCategories.forEach(menu ->
                this.weeklyCategories.put(menu.getCategory(), menu));
    }

    public List<Menu> getCategoryList() {
        return new ArrayList<>(weeklyCategories.values());
    }

    public List<String> getCategoryNames() {
        return new ArrayList<>(weeklyCategories.keySet());
    }
}
