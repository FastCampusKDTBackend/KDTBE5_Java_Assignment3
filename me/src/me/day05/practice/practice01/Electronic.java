package me.day05.practice.practice01;

import java.time.LocalDate;

public class Electronic {
	
	private static int serialNum = 0;
	int sequenceOfProduct;   
	
	private String productNo;   	 // 1. 제품일련번호
	private String modelName;   	 // 2. 제품명
	private Company companyName; // 3. 제조회사명
	private AuthMethod authMethod;   // 4. 본인인증방법
	private LocalDate dateOfMade;    // 5. 제품등록날짜
	
	public Electronic(String modelName, Company companyName, AuthMethod authMethod) {	
		this.dateOfMade = LocalDate.now();
		this.sequenceOfProduct = ++serialNum;
		this.productNo = dateOfMade.toString().split("-")[0] 
					   + dateOfMade.toString().split("-")[1] 
					   + dateOfMade.toString().split("-")[2]  + String.format("%04d", sequenceOfProduct).toString();
		
		this.modelName = modelName;
		this.companyName = companyName;
		this.authMethod = authMethod;
	}

	// 1. 제품일련번호
	public String getProductNo() {
		return productNo;
	}
	// 2. 제품명
	public String getModelName() {
		return modelName;
	}
	// 3. 제조회사명
	public Company getCompanyName() {
		return companyName;
	}
	 // 4. 본인인증방법
	public AuthMethod getAuthMethod() {
		return authMethod;
	}
	public void setAuthMethod(AuthMethod authMethod) {
		this.authMethod = authMethod;
	}
	// 5. 제품등록날짜
	public LocalDate getDateOfMade() {
		return dateOfMade;
	}
	
}