package menu.common.enums;

public enum ErrorMessage {
    INVALID_NAME_LENGTH("코치 이름은 최소 %d글자, 최대 %d글자 입니다."),
    INVALID_COACH_COUNT("코치는 최소 %d명, 최대 %d명 까지 입력할 수 있습니다."),
    DUPLICATE_COACH_NAME("코치 이름은 중복 입력할 수 없습니다."),
    INVALID_EXCLUSION_COUNT("못 먹는 메뉴는 최대 %d개 까지 입력할 수 있습니다."),
    INVALID_MENU("%s는 존재하지 않는 메뉴 이름입니다.");

    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String RE_ENTER = " 다시 입력해 주세요.%n";
    private final String messageTemplate;

    ErrorMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getFormatMessage(Object... args) {
        String textBody = String.format(this.messageTemplate, args);
        return ERROR_HEADER + textBody + RE_ENTER;
    }
}
