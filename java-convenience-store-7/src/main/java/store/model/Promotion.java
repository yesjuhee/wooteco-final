package store.model;

import java.time.LocalDate;

public class Promotion {
    private final String name;
    private final int buy;
    private final int get;
    private final LocalDate start;
    private final LocalDate end;

    public Promotion(String name, String buy, String get, String start, String end) {
        this.name = name;
        this.buy = Integer.parseInt(buy);
        this.get = Integer.parseInt(get);
        this.start = LocalDate.parse(start);
        this.end = LocalDate.parse(end);
    }

    public String getName() {
        return name;
    }
}
