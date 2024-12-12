package menu.common.enums;

public enum OutputMessage {
    WELCOME("점심 메뉴 추천을 시작합니다.%n%n"),

    INPUT_COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)%n"),

    EXCLUDE_MENU("%n%s(이)가 못 먹는 메뉴를 입력해 주세요.%n"),

    RESULT_HEADER("%n메뉴 추천 결과입니다.%n"),
    DAY("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]%n"),
    CATEGORY_RESULT("[ 카테고리 | %s | %s | %s | %s | %s ]%n"),
    COACH_RESULT("[ %s | %s | %s | %s | %s | %s ]%n"),

    EXIT("%n추천을 완료했습니다.");

    private final String messageTemplate;

    OutputMessage(final String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getFormatMessage(Object... args) {
        return String.format(this.messageTemplate, args);
    }
}
