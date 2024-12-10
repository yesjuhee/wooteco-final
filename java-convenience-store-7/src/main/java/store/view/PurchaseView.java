package store.view;

import static store.common.enums.ErrorMessage.INVALID_PURCHASE_FORMAT;
import static store.common.enums.OutputMessage.INPUT_PURCHASE;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class PurchaseView {
    public static final String DELIMITER = ",";
    private static final String OPEN = "[";
    private static final String CLOSE = "]";
    private static final String MIDDLE = "-";
    private static final String POSITIVE_INTEGER_REGEX = "\\d+";


    public HashMap<String, Integer> readPurchaseInfo() {
        HashMap<String, Integer> parsedInput = new HashMap<>();
        System.out.printf(INPUT_PURCHASE.getFormatMessage());
        String input = Console.readLine();
        validationFormat(input, parsedInput);
        return parsedInput;
    }

    private void validationFormat(String input, HashMap<String, Integer> parsedInput) {
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PURCHASE_FORMAT.getFormatMessage());
        }
        for (String purchase : input.split(DELIMITER)) {
            validatePurchaseFormat(purchase.trim());
            parsePurchase(purchase.trim(), parsedInput);
        }
    }

    private void validatePurchaseFormat(String input) {
        if (!input.startsWith(OPEN) || !input.endsWith(CLOSE) || !input.contains(MIDDLE)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_FORMAT.getFormatMessage());
        }
        int middleIndex = input.indexOf(MIDDLE);
        if (input.indexOf(MIDDLE, middleIndex + 1) != -1) {
            throw new IllegalArgumentException(INVALID_PURCHASE_FORMAT.getFormatMessage());
        }
    }

    private void parsePurchase(String input, HashMap<String, Integer> parsedInput) {
        String productName = splitProductName(input);
        String quantity = splitQuantity(input);
        validatePositiveNumber(quantity);
        parsedInput.put(productName, Integer.parseInt(quantity));
    }

    private String splitProductName(String input) {
        return input.substring(input.indexOf(OPEN) + 1, input.indexOf(MIDDLE));
    }

    private String splitQuantity(String input) {
        return input.substring(input.indexOf(MIDDLE) + 1, input.indexOf(CLOSE));
    }

    private void validatePositiveNumber(final String countInput) {
        if (!countInput.matches(POSITIVE_INTEGER_REGEX) || countInput.equals("0")) {
            throw new IllegalArgumentException(INVALID_PURCHASE_FORMAT.getFormatMessage());
        }
    }
}
