package store.model;

import static store.common.constant.PromotionFile.BUY;
import static store.common.constant.PromotionFile.END;
import static store.common.constant.PromotionFile.GET;
import static store.common.constant.PromotionFile.NAME;
import static store.common.constant.PromotionFile.START;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Promotions {
    private final Map<String, Promotion> promotions = new HashMap<>();

    public Promotions(List<List<String>> promotionsCSV) {
        for (List<String> csvRow : promotionsCSV) {
            String name = csvRow.get(NAME);
            promotions.put(name,
                    new Promotion(name, csvRow.get(BUY), csvRow.get(GET), csvRow.get(START), csvRow.get(END)));
        }
    }

    public Promotion findPromotionByName(String promotionName) {
        return promotions.get(promotionName);
    }
}
