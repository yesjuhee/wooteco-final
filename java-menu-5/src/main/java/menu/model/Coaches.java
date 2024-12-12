package menu.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import menu.common.enums.Menu;

public class Coaches {
    private final LinkedHashMap<String, Coach> coaches = new LinkedHashMap<>();

    public Coaches(List<String> names) {
        names.forEach(name ->
                coaches.put(name, new Coach(name)));
    }

    public void suggestMenu(WeeklyCategories weeklyCategories) {
        for (Menu categoryOfDay : weeklyCategories.getCategoryList()) {
            for (Coach coach : coaches.values()) {
                coach.suggestMenu(categoryOfDay);
            }
        }
    }

    public List<Coach> getCoaches() {
        return new ArrayList<>(coaches.values());
    }
}
