package store.common.enums;

public enum OutputMessage {
    WELCOME("%n안녕하세요. W편의점입니다.%n현재 보유하고 있는 상품입니다.%n%n"),

    PRODUCT("- %s %,d원 %,d개%n"),
    PRODUCT_OUT_OF_STOCK("- %s %,d원 재고 없음%n"),
    PROMOTION_PRODUCT("- %s %,d원 %d개 %s%n"),
    PROMOTION_PRODUCT_OUT_OF_STOCK("- %s %,d원 재고 없음 %s%n");

//    INPUT_PURCHASE("%n구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])%n"),
//
//    ADD_PROMOTION_PRODUCT_CONFIRM("%n현재 %s은(는) 1개를 무료로 더 받을 수 있습니다. 추가하시겠습니까? (Y/N)%n"),
//    PURCHASE_ALL_CONFIRM("%n현재 %s %d개는 프로모션 할인이 적용되지 않습니다. 그래도 구매하시겠습니까? (Y/N)%n"),
//    APPLY_MEMBERSHIP_CONFIRM("%n멤버십 할인을 받으시겠습니까? (Y/N)%n"),
//    PURCHASE_CONTINUE_CONFIRM("%n감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)%n"),
//
//    RECEIPT_HEADER("%n================W 편의점================%n"),
//    RECEIPT_PURCHASE_HEADER(String.format("%-18s%-8s%8s%n", "상품명", "수량", "금액")),
//    RECEIPT_PURCHASE_BODY("%-18s%,-8d%,8d%n"),
//    RECEIPT_PRESENT_HEADER("================증   정================%n"),
//    RECEIPT_PRESENT_BODY("%-18s %,-18d%n"),
//    RECEIPT_LINE("=====================================%n"),
//    RECEIPT_TOTAL_PRICE("총구매액" + " ".repeat(14) + "%,-8d %,8d%n"),
//    RECEIPT_PROMOTION_DISCOUNT("행사할인" + " ".repeat(30) + "-%,d%n"),
//    RECEIPT_MEMBERSHIP_DISCOUNT("멤버십할인" + " ".repeat(29) + "-%,d%n"),
//    RECEIPT_FINAL_PRICE("내실돈               %,18d%n");

    private final String messageTemplate;

    OutputMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getFormatMessage(Object... args) {
        return String.format(this.messageTemplate, args);
    }
}
