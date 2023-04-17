package me.day05.practice.practice01;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Electronic {

    private StringBuffer productNo;
    private static int productionCount=1;

    private LocalDateTime dateOfMade;
    private String modelName;
    private enum companyName{
        SAMSUNG("삼성"),
        LG("엘지"),
        APPLE("애플");

        private String company=null;
        companyName(String company) {
            this.company=company;
        }

    }

    private enum authMethod{
        FINGERPRINT("지문인증"),
        PATTERN("패턴인증"),
        PIN("핀인증"),
        FACE("얼굴인증");

        private String authMethodName = null;
        authMethod(String authMethodName) {
            this.authMethodName=authMethodName;
        }
    }

    private authMethod[] authMethods;


    public Electronic(companyName companyName, authMethod []authMehods){
        productNo = new StringBuffer(LocalDate.now().getYear()%100);
        productNo.append(String.format("%02",LocalDate.now().getDayOfMonth()));
        productNo.append(String.format("%02",LocalDate.now().getDayOfMonth()));
        productNo.append(String.format("%04",productionCount++ ));
        this.authMethods=authMehods;

    }

    public authMethod[] getAuthMethods() {
        return authMethods;
    }

    public void setAuthMethods(authMethod[] authMethods) {
        this.authMethods = authMethods;
    }

    public StringBuffer getProductNo() {
        return productNo;
    }

    public void setProductNo(StringBuffer productNo) {
        this.productNo = productNo;
    }

    public static int getProductionCount() {
        return productionCount;
    }

    public static void setProductionCount(int productionCount) {
        Electronic.productionCount = productionCount;
    }

    public LocalDateTime getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDateTime dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
