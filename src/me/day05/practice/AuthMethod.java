package me.day05.practice;

enum AuthMethod {
    FINGER_PRINT("Finger Print"),
    PATTERN("Pattern"),
    PIN("PIN"),
    FACE("Face"),
    FOOT("Foot");

    private final String authType;

    AuthMethod(String authType) {
        this.authType = authType;
    }

    public String getAuthType() {
        return authType;
    }

    //useless in this time
    /*public static boolean isValidAuthType(List<AuthMethod> authMethod){
        return Arrays.stream(AuthMethod.values())
                .anyMatch(authType -> authMethod.contains(authType));
    }*/
}
