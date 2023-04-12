package ForSubmission.me.day05.practice.Practice03;

public enum AuthMethod {
    FINGERPRINT("FINGERPRINT RECOGNITION"), FACE("FACE RECOGNITION"), PATTERN("PATTERN RECOGNITION"), PIN("PING RECOGNITION");

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
