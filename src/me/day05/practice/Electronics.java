package me.day05.practice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Electronics {
    private List<Electronic> electronicList;
    private Electronic[] electronicArray;

    private int electronicArraySize;

    static Electronics instance;
    //set constructor as private for SingleTon
    private Electronics(){
        this.electronicArray = new Electronic[Define.DEFAULT_CAPACITY];
        electronicList = new ArrayList<>();
        electronicArraySize = 0;
    }

    //TODO: add validation check of modelName, dateOfMade
    public boolean addElectronic(String modelName, Company company, LocalDate dateOfMade, List<AuthMethod> authMethod){
        //Use List
        //duplication check
        Optional<Electronic> electronicOpt = electronicList
                .stream().filter(electronic -> modelName.equals(electronic.getModelName()))
                .findFirst();

        if (electronicOpt.isPresent()) {
            System.out.printf("%s Already Exists\n",modelName);
            return false;
        }

        electronicList.add(new Electronic.Builder()
                .modelName(modelName)
                .companyName(company.getCompanyName())
                .dateOfMade(dateOfMade)
                .authMethod(authMethod)
                .build());

        return true;
    }
    public boolean addElectronicToArray(String modelName, Company company, LocalDate dateOfMade, List<AuthMethod> authMethod){
        //use Array
        //duplication check
        for(Electronic electronic: electronicArray){
            if(electronic != null && electronic.getModelName().equals(modelName)){
                System.out.printf("%s Already Exists\n",modelName);
                return false;
            }
        }


        if(electronicArraySize == electronicArray.length){
            resize(electronicArraySize + 10);
        }

        electronicArray[electronicArraySize] = (new Electronic.Builder()
                .modelName(modelName)
                .companyName(company.getCompanyName())
                .dateOfMade(dateOfMade)
                .authMethod(authMethod)
                .build());
        electronicArraySize++;
        return true;
    }

    private void resize(int newLength){
        electronicArray = Arrays.copyOf(this.electronicArray, newLength);
    }
    public void initElectronics(){
        String[] modelNames = {"Ipad pro 11","Galaxy Tab S8+","V50s","Ipad pro 11","Galaxy S23"};
        Company[] companies = {Company.APPLE, Company.SAMSUNG, Company.LG, Company.APPLE, Company.SAMSUNG};
        LocalDate[] dateOfMade = {LocalDate.parse("2021-04-21"),LocalDate.parse("2022-02-10"), LocalDate.parse("2019-10-10"), LocalDate.parse("2021-04-21"), LocalDate.parse("2023-02-02")};
        List <AuthMethod>[] authMethods = new List[]{Arrays.asList(AuthMethod.FACE, AuthMethod.PIN,AuthMethod.FINGER_PRINT),Arrays.asList(AuthMethod.FINGER_PRINT,AuthMethod.PIN,AuthMethod.PATTERN),Arrays.asList(AuthMethod.PATTERN,AuthMethod.FINGER_PRINT,AuthMethod.PIN), Arrays.asList(AuthMethod.FACE, AuthMethod.PIN,AuthMethod.FINGER_PRINT),Arrays.asList(AuthMethod.FACE, AuthMethod.PIN,AuthMethod.FINGER_PRINT, AuthMethod.PATTERN)};
        //use List
        System.out.println("Use List");
        for(int i = 0 ; i < modelNames.length ; i++){
            addElectronic(modelNames[i], companies[i], dateOfMade[i], authMethods[i]);
        }
        System.out.println("Use Array");
        //use Array
        for(int i = 0 ; i < modelNames.length ; i++){
            addElectronicToArray(modelNames[i], companies[i], dateOfMade[i], authMethods[i]);
        }
    }

    public static Electronics getInstance(){
        if(instance == null){
            instance = new Electronics();
        }
        return instance;
    }

    /*
        assignment 3-2
        find product by product Number
    */
    public Electronic findByProductNo(String productNo){
        Optional<Electronic> electronicOpt = electronicList
                .stream().filter(user -> productNo.equals(user.getProductNo()))
                .findFirst();
        if (electronicOpt.isPresent()) {
            return electronicOpt.get();
        }
        System.out.printf("Product 'productNo : %s' Not Found\n",productNo);
        return null;
    }

    public Electronic findByProductNoFromArray(String productNo){
        for(Electronic electronic : electronicArray){
            if(electronic != null && electronic.getProductNo().equals(productNo)) {
                return electronic;
            }
        }
        System.out.printf("Product 'productNo : %s' Not Found\n",productNo);
        return null;
    }

    /*
        assignment 3-3
        find product list by company name
    */
    public List<Electronic> groupByCompanyName(Company company) {
        List<Electronic> electronics = electronicList
                .stream().filter(electronic -> electronic.getCompanyName().equals(company.name()))
                .collect(Collectors.toList());

        if (electronics.isEmpty()) {
            System.out.printf("Product Made by '%s' Not Found\n",company.name());
            return null;
        }
       return electronics;
    }

    public Electronic[] groupByCompanyNameFromArray(Company company) {
        Electronic[] matchedElectronics = new Electronic[electronicArraySize];
        int count=0;
        for(Electronic electronic : electronicArray){
            if(electronic != null && electronic.getCompanyName().equals(company.name())){
                matchedElectronics[count] = electronic;
                count++;
            }
        }
        if(matchedElectronics.length==0){
            System.out.printf("Product Made by '%s' Not Found\n",company.name());
            return null;
        }

        //resize matchedElectronics to delete null
        return Arrays.copyOf(matchedElectronics,count);
    }

    /*
        assignment 3-4
        find product list by authentication method
    */
    public List<Electronic> groupByAuthMethod(AuthMethod authMethod) {
        List<Electronic> electronics = electronicList
                .stream().filter(electronic -> electronic.getAuthMethod().contains(authMethod))
                .collect(Collectors.toList());

        if (electronics.isEmpty()) {
            System.out.printf("Product Provide %s Authentication Not Found\n",authMethod);
            return null;
        }
        return electronics;
    }

    public Electronic[] groupByAuthMethodFromArray(AuthMethod authMethod) {
        Electronic[] matchedElectronics = new Electronic[electronicArraySize];
        int count=0;
        for(Electronic electronic : electronicArray){
            if(electronic != null && electronic.getAuthMethod().contains(authMethod)){
                matchedElectronics[count] = electronic;
                count++;
            }
        }
        if(matchedElectronics.length==0){
            System.out.printf("Product Provide %s Authentication Not Found\n",authMethod);
            return null;
        }
        //resize matchedElectronics to delete null
        return Arrays.copyOf(matchedElectronics,count);
    }
    /*
        assignment 3
        getter(), setter(), hashcode(), equals(), toString()
    */

    public List<Electronic> getElectronicList() {
        return electronicList;
    }

    public void setElectronicList(List<Electronic> electronicList) {
        this.electronicList = electronicList;
    }

    public Electronic[] getElectronicArray() {
        return electronicArray;
    }

    public void setElectronicArray(Electronic[] electronicArray) {
        this.electronicArray = electronicArray;
    }

    @Override
    public String toString() {
        return electronicList.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronics that)) return false;
        return Objects.equals(electronicList, that.electronicList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(electronicList);
    }
}
