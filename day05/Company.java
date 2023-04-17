package me.day05;

public enum Company {

    SAMSUNG("삼성",1),
    LG("엘지",2),
    APPLE("애플",3);

    private final String viewName;
    private final int code;

    Company(String viewName, int code) {
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
