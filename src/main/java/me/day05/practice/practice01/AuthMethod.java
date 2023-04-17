package me.day05.practice.practice01;

/**
 * 본인인증 방법 - 지문, 패턴, 핀, 얼굴인식
 *
 * @author YongHo Shin
 * @version 0.1
 * @since 2023-04-12
 */
public enum AuthMethod {
  FINGER_PRINT("지문인증"),
  PATTERN("패턴인증"),
  PIN("핀인증"),
  FACE("얼굴인증");
  
  private final String description;
  
  AuthMethod(String description) {
    this.description = description;
  }
  
  public String getDescription() {
    return description;
  }
}
