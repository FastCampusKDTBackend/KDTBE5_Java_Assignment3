package me.day05;

public enum AuthMethod {

    FINGERPRINT("지문인증", 1),
    PATTERN("패턴인증", 2),
    PIN("핀인증", 3),
    FACE("얼굴인증", 4);

    private final String viewName;
    private final int code;

    AuthMethod(String viewName, int code) {
        this.viewName = viewName;
        this.code = code;
    }

    public String getViewName() {
        return viewName;
    }

    public int getCode() {
        return code;
    }
}
