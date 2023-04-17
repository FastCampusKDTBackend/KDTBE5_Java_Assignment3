package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
    private String productNo;   //��ǰ �Ϸù�ȣ
    private static int serialNum = 0;   //��ǰ �Ϸù�ȣ�� ��� ����
    private String modelName;  //���ڱ�� �𵨸�
    private Company companyName;  //���� ȸ���
    private String dateOfMade;  //��������
    private AuthMethod[] authMethod;    //�������� ���

    //������
    public Electronic(){
        serialNum++;
        productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d",serialNum);
    }

    public Electronic(String modelName, Company companyName, String dateOfMade, AuthMethod[] authMethod) {
        serialNum++;
        this.productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d", serialNum);
        this.modelName = modelName;
        this.companyName = companyName;
        this.dateOfMade = dateOfMade;
        this.authMethod = authMethod;

    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, dateOfMade, companyName, authMethod);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Electronic)) return false;

        Electronic electronic = (Electronic) obj;
        return (this.productNo == electronic.productNo) || (this.modelName == electronic.modelName)
                || (this.dateOfMade == electronic.dateOfMade) || (this.companyName == electronic.companyName)
                || (this.authMethod.equals(electronic.authMethod));
    }

    @Override
    public String toString() {
        return "electronic{productNo:" + productNo +
                ", modelName:" + modelName +
                ", companyName:" + companyName +
                ", dateOfMade:" + dateOfMade +
                ", authMethod:" + Arrays.toString(authMethod) + "}";
    }

    //setter&getter
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

    public String getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(String dateOfMade) {
        this.dateOfMade = dateOfMade;
    }
    public void setCompanyName(Company companyName){
        this.companyName = companyName;
    }
    public Company getCompanyName(){
        return companyName;
    }

    public AuthMethod[] getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(AuthMethod[] authMethod) {
        this.authMethod = authMethod;
    }
}
