package me.day05.practice;

public enum Company {
    SAMSUNG("삼성"),
    LG("엘지"),
    APPLE("애플");

    private final String title;

    Company(String title) {
        this.title = title;
    }

    public String getTitle() { return this.title; }

}
