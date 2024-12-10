package store.common.enums;

public enum ErrorMessage {
    INVALID_PURCHASE_FORMAT("%n%s 올바르지 않은 형식으로 입력했습니다. %s%n"),
    PRODUCT_NOT_EXIST("%n%s 존재하지 않는 상품입니다. %s%n"),
    OUT_OF_STOCK("%n%s 재고 수량을 초과하여 구매할 수 없습니다. %s%n"),
    INVALID_INPUT("%n%s 잘못된 입력입니다. %s%n");

    private static final String ERROR_HEADER = "[ERROR]";
    private static final String RE_ENTER = "다시 입력해 주세요.";
    private final String messageTemplate;

    ErrorMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getFormatMessage() {
        return String.format(this.messageTemplate, ERROR_HEADER, RE_ENTER);
    }
}
