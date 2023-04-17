package me.day05.practice.practice01;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.time.LocalDate;
public enum AuthMethod {
    FINGERPRINT, PATTERN, PIN, FACE
}

public enum Company {
    SAMSUNG, LG, APPLE
}
public class Electronic {
    private static int productNum  = 0; //등록된 제품 순서
    private String productNo; //제품일련번호
    private String modelName;
    private Company companyName;
    private String dateOfMade;
    private AuthMethod[] authMethod;  //본인 인증 방법

    public Electronic( String modelName, Company companyName, String dateOfMade, AuthMethod[] authMethod) {
        this.productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d", productNum++) ;
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;
    }
    public static int getproductNum() {
        return productNum;
    }

    public static void setproductNum(int productNum) {
        Electronic.productNum = productNum;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Company companyName) {
        this.companyName = companyName;
    }

    public String getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(String dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(productNo, that.productNo) && Objects.equals(modelName, that.modelName) && companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade) && Arrays.equals(authMethod, that.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, companyName, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + companyName +
                ", dateOfMade='" + dateOfMade + '\'' +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}
public class User {
    private String userId;
    private String userPassword;
    private String userPhoneNumber;
    private String userEmail;
    private String userBirthDate;
    private Electronic[] electronicDevices;
    private LocalDate registerTime;

    public User(String userId, String userPassword, String userPhoneNumber, String userEmail, String userBirthDate, Electronic[] electronicDevices) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.electronicDevices = electronicDevices;
        this.registerTime = LocalDate.now();

    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public Electronic[] getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(Electronic[] electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public LocalDate getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDate registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userPhoneNumber, user.userPhoneNumber) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userBirthDate, user.userBirthDate) && Arrays.equals(electronicDevices, user.electronicDevices) && Objects.equals(registerTime, user.registerTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(userId, userPassword, userPhoneNumber, userEmail, userBirthDate, registerTime);
        result = 31 * result + Arrays.hashCode(electronicDevices);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", electronicDevices=" + Arrays.toString(electronicDevices) +
                ", registerTime=" + registerTime +
                '}';
    }
}