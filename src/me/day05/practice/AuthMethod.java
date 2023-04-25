package me.day05.practice;

public enum AuthMethod {
    FingerPrint("지문인증",0),
    Pattern("패턴인증",1),
    Pin("핀인증",2),
    Face("얼굴인증",3);

    private final String label;
    private final int code;

    AuthMethod(String label, int code) {
        this.label = label;
        this.code = code;
    }

    public String getLabel() {
        return label;
    }
}
