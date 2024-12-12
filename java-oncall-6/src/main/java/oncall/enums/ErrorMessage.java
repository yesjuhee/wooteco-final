package oncall.enums;


public enum ErrorMessage {
    INVALID_MONTH("입력 월이 올바르지 않습니다."),
    INVALID_DAY("“입력 요일이 올바르지 않습니다."),
    INVALID_MONTH_DAY("입력 월과 요일을 쉼표로 구분해서 입력해야합니다."),
    INVALID_WORKER_COUNT("근무자 수는 최소 %d명, 최대 %d명입니다."),
    INVALID_WORKER_NAME_LENGTH("근무자 닉네임은 최대 %d자입니다."),
    INVALID_WORKER_BATCH("비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다.");

    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String RE_ENTER = " 다시 입력해 주세요.%n";
    private final String messageTemplate;

    ErrorMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getMessage(Object... args) {
        String textBody = String.format(this.messageTemplate, args);
        return ERROR_HEADER + textBody + RE_ENTER;
    }
}
