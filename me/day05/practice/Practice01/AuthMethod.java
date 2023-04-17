package me.day05.practice.Practice01;

public enum AuthMethod {
    FINGERPRINT("지문 인증"), PATTERN("패턴 인증"), PIN("핀 인증"), FACE("얼굴 인증"),;

    private String authMethod = null;

    AuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }
}
