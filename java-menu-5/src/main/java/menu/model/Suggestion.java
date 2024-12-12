package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Suggestion {
    private final List<String> suggestedMenus = new ArrayList<>();

    public Suggestion() { // 기본 생성자 사용
    }

    public boolean contain(String selectedMenuName) {
        return suggestedMenus.contains(selectedMenuName);
    }

    public void putMenuName(String selectedMenuName) {
        suggestedMenus.add(selectedMenuName);
    }

    public List<String> getSuggestedMenus() {
        return suggestedMenus;
    }
}
