package oncall.enums;

import java.util.Arrays;
import java.util.List;

public enum Month {
    JEN(1, 31, List.of(1)),
    FEB(2, 28, List.of()),
    MAR(3, 31, List.of(1)),
    APR(4, 30, List.of()),
    MAY(5, 31, List.of(5)),
    JUN(6, 30, List.of(6)),
    JUL(7, 31, List.of()),
    AUG(8, 31, List.of(15)),
    SEP(9, 30, List.of()),
    OCT(10, 31, List.of(3, 9)),
    NOV(11, 30, List.of()),
    DEC(12, 31, List.of(25));

    private final int month;
    private final int lastDate;
    private final List<Integer> holiday;

    Month(int month, int lastDate, List<Integer> holiday) {
        this.month = month;
        this.lastDate = lastDate;
        this.holiday = holiday;
    }

    public static Month getMonthByNumber(Integer number) {
        return Arrays.stream(Month.values())
                .filter(m -> m.getMonth() == number)
                .findAny().get();
    }

    public int getMonth() {
        return month;
    }

    public int getLastDate() {
        return lastDate;
    }

    public List<Integer> getHoliday() {
        return holiday;
    }
}
