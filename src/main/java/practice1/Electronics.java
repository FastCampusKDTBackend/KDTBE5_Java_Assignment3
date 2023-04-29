package practice1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Electronics {
    private static final int DEFAULT_CAPACITY = 50;
    private static Electronics electronics;

    private Electronic[] electronicList;


    private Electronics() {
        electronicList = new Electronic[DEFAULT_CAPACITY];
    }

    public static Electronics getInstance() {
        if (electronics == null) {
            electronics = new Electronics();
        }
        return electronics;
    }

    public Electronic findByProductNo(Long productNo) {
        Stream<Electronic> productStream = Arrays.stream(electronicList);
        Optional<Electronic> filtered = productStream
                .filter(product -> product.getProductNo().equals(productNo))
                .findFirst();
        if (filtered.isPresent()) {
            return filtered.get();
        }
        throw new IllegalArgumentException("상품번호 " + productNo + "에 해당하는 전자제품을 찾을 수 없습니다.");
    }

    public Electronic[] groupByCompanyName(Company company) {
        Electronic[] companyProducts = new Electronic[DEFAULT_CAPACITY];
        int idx = 0;
        for (Electronic electronic : electronicList) {
            if (electronic.getCompanyName().equals(company)) {
                companyProducts[idx++] = electronic;
            }
        }
        if (idx == 0) {
            throw new IllegalArgumentException("제조사 " + company + "의 전자제품을 찾을 수 없습니다.");
        }
        removeEmptyElements(companyProducts);
        return companyProducts;
    }

    public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
        Electronic[] authMethodProducts = new Electronic[DEFAULT_CAPACITY];
        int idx = 0;
        for (Electronic electronic : electronicList) {
            for (AuthMethod method : electronic.getAuthMethod()) {
                if (method.equals(authMethod)) {
                    authMethodProducts[idx] = electronic;
                    idx++;
                    break;
                }
            }
        }
        if (idx == 0) {
            throw new IllegalArgumentException(authMethod + " 인증방법을 탑재한 전자제품을 찾을 수 없습니다.");
        }
        removeEmptyElements(authMethodProducts);
        return authMethodProducts;
    }

    private void removeEmptyElements(Electronic[] newElectronicList) {

        int idx = 0;
        for (Electronic e : newElectronicList) {
            if (e == null) {
                break;
            }
            idx++;
        }
        newElectronicList = Arrays.copyOf(newElectronicList, idx);
    }


    public Electronic[] getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(Electronic[] electronicList) {
        this.electronicList = electronicList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Electronics that = (Electronics) o;
        return Arrays.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(electronicList);
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "electronicList=" + Arrays.toString(electronicList) +
                '}';
    }
}
