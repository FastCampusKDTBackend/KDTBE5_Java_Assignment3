package me.day05.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Electronic {
    private String productNo;
    private static int productId;
    private String modelName;
    private String companyName;
    private LocalDate dateOfMade;
    private List<AuthMethod> authMethod;

    Electronic(Builder builder){
        //System.out.println(builder.toString());
        modelName = builder.modelName;
        companyName = builder.companyName;
        dateOfMade = builder.dateOfMade;
        productNo = this.dateOfMade.format(DateTimeFormatter.ofPattern("yyMMdd"))+String.format("%04d",productId+1);
        authMethod = builder.authMethod;
        productId++;
    }

    /*
        assignment 1
        getter(), setter(), hashcode(), equals(), toString()
    */
    //add conditions in getter & setter if necessary

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public static int getProductId() {
        return productId;
    }

    public static void setProductId(int productId) {
        Electronic.productId = productId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getDateOfMade() {
        return dateOfMade;
    }

    public void setDateOfMade(LocalDate dateOfMade) {
        this.dateOfMade = dateOfMade;
    }

    public List<AuthMethod> getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(List<AuthMethod> authMethod) {
        this.authMethod = authMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic that)) return false;
        return productNo.equals(that.productNo) && modelName.equals(that.modelName) && companyName.equals(that.companyName) && dateOfMade.equals(that.dateOfMade) && authMethod.equals(that.authMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNo, modelName, companyName, dateOfMade, authMethod);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + authMethod +
                '}'+"\n";
    }

    public static class Builder{
        private String modelName;
        private String companyName;
        private LocalDate dateOfMade;
        private List<AuthMethod> authMethod;

        public Builder modelName (String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder companyName (String companyName){
            this.companyName = companyName;
            return this;
        }

        public Builder dateOfMade (LocalDate dateOfMade){
            this.dateOfMade = dateOfMade;
            return this;
        }

        public Builder authMethod (List<AuthMethod> authMethod){
            this.authMethod = authMethod;
            return this;
        }

        public Electronic build() {
            return new Electronic(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "modelName='" + modelName + '\'' +
                    ", companyName='" + companyName + '\'' +
                    ", dateOfMade=" + dateOfMade +
                    ", authMethod=" + authMethod +
                    '}';
        }
    }
}
