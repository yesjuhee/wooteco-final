package oncall.enums;

import java.util.Arrays;

public enum Day {
    MON("월", 1, false),
    TUE("화", 2, false),
    WED("수", 3, false),
    THU("목", 4, false),
    FRI("금", 5, false),
    SAT("토", 6, false),
    SUN("일", 7, false);

    private final String name;
    private final int order;
    private final boolean isHoliday;

    Day(String name, int order, boolean isHoliday) {
        this.name = name;
        this.order = order;
        this.isHoliday = isHoliday;
    }

    public static Day getDayByOrder(String day) {
        return Arrays.stream(Day.values())
                .filter(d -> d.getName().equals(day))
                .findAny().get();
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public boolean isHoliday() {
        return isHoliday;
    }
}
