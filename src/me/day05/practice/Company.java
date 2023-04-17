package me.day05.practice;

enum Company {
    LG("LG"),
    SAMSUNG("SAMSUNG"),
    APPLE("APPLE"),
    GOOGLE("GOOGLE");
    private final String companyName;
    Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    //useless in this time
    /*public static boolean isValidCompany(Company company){
        return Arrays.asList(Company.values()).stream()
                .anyMatch(companyName -> companyName == company);
    }*/
}
