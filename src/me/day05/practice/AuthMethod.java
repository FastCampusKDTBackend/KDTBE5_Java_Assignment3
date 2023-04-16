package me.day05.practice;

public enum AuthMethod {
    FINGERPRINT("지문"), PATTERN("패턴"), PIN("핀"), FACE("얼굴");

    private final String title;

    AuthMethod(String title) {
        this.title = title;
    }

    public String getTitle() { return this.title; }

}
