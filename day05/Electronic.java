package me.day05;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {

    private String productNo;
    private  String modelName;
    private Company company;
    private LocalDateTime dateOfMade;
    AuthMethod[] authMethod;

    private static int AUTO_GEN = 0;

    Electronic() {
        AUTO_GEN++;
        dateOfMade = LocalDateTime.now(ZoneId.systemDefault());
        productNo = String.format("%02d", this.dateOfMade.getYear()) +
                String.format("%02d", this.dateOfMade.getMonthValue()) +
                String.format("%02d", this.dateOfMade.getDayOfMonth()) +
                String.format("%04d", AUTO_GEN);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Electronic electronic = (Electronic) obj;
        return Objects.equals(productNo, electronic.productNo)
                && Objects.equals(modelName, electronic.modelName)
                && company == electronic.company
                && Objects.equals(dateOfMade, electronic.dateOfMade)
                && Arrays.equals(authMethod, electronic.authMethod);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(productNo, modelName, company, dateOfMade);
        result = 31 * result + Arrays.hashCode(authMethod);
        return result;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "productNo='" + productNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", companyName=" + company +
                ", dateOfMade=" + dateOfMade +
                ", authMethod=" + Arrays.toString(authMethod) +
                '}';
    }
}

