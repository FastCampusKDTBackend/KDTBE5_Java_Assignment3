package me.day05.practice;

public enum Company {
    SAMSUNG("삼성",0),
    LG("엘지",1),
    APPLE("애플",2);

    private final String label;
    private final int code;

    Company(String label, int code) {
        this.label = label;
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public int getCode() {
        return code;
    }
}
