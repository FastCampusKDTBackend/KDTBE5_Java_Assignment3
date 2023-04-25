package me.day05.practice.NonArrayList;

public enum AuthMethod {
    FINGERPRINT("지문인식"), PATTERN("패턴인식"), PIN("핀 번호"), FACE("얼굴인식");

    String authMethod = null;

    AuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    public String getAuthMethod() {
        return authMethod;
    }

}