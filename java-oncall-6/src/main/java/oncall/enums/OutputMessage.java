package oncall.enums;

public enum OutputMessage {
    INPUT_MONTH_DAY("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WEEKDAY_WORKERS("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_HOLIDAY_WORKERS("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    SCHEDULE("%d월 %d일 %s %s"),
    SPECIAL_HOLIDAY_SCHEDULE("%d월 %d일 %s(휴일) %s");

    private final String messageTemplate;

    OutputMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getMessage(Object... args) {
        return String.format(this.messageTemplate, args);
    }
}
