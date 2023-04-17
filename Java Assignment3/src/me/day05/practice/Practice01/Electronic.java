package me.day05.practice.Practice01;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
	// 제조 회사명 enum
	public enum Company {
		SAMSUNG, LG, APPLE
	}
	
	// 본인 인증 방법 enum
	public enum AuthMethod {
		FINGERPRINT, PATTERN, PIN, FACE
	}
	
	private final String productNo; // 제품 일련번호. 클래스 객체 생성시 자동 생성
	private String modelName;  // 전자기기 모델명
	private Company companyName;  // 제조 회사명 enum정의
	private LocalDate dateOfMade;  // 생산일자
	private AuthMethod[] authMethod;  // 본인인증 방법(다수 있을 수도. 배열로)
	private static int serialNum = 0; // 제품 일련번호에 쓰일 시리얼 번호
	
	// 생성자. Electronic 클래스 객체 생성시 자동 생성
    public Electronic(String modelName, Company companyName, LocalDate dateOfMade, AuthMethod[] authMethods) {
        this.productNo = setProductNo();
    	this.modelName = modelName;
        this.dateOfMade = dateOfMade;
        this.companyName = companyName;
        this.authMethod = authMethods;
    }
    
    
    // getter&setter
	// 제품 일련번호 get
	public String getProductNo() {
		return this.productNo;
	}
	
	// 제품 일련번호 set 
	// productNo규칙 - 등록날짜(연도2+월2+일)+등록제품순서4자리 
	// ex)230330+0001 => 2303300001
    private String setProductNo() {
    	serialNum++;
        return LocalDate.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyMMdd")) + String.format("%04d", serialNum);
    }

	// 전자기기 모델명 get
	public String getModelName() {
		return this.modelName;
	}

	// 전자기기 모델명 set
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	// 제조 회사명 get
	public Company getCompanyName() {
		return this.companyName;
	}

	// 제조 회사명 set
	public void setCompanyName(Company companyName) {
		this.companyName = companyName;
	}

	// 생산일자 get
	public LocalDate getDateOfMade() {
		return this.dateOfMade;
	}
		
	// 생산일자 set
	public void setDateOfMade(LocalDate dateOfMade) {
		this.dateOfMade = dateOfMade;
	}
		
	// 본인인증방법 get
	public AuthMethod[] getAuthMethod() {
		return this.authMethod;
	}

	// 본인인증방법 set
	public void setAuthMethod(AuthMethod[] authMethod) {
		this.authMethod = authMethod;
	}
	
	
	// hashcode 재정의
	@Override
	public int hashCode() {
		var prime = 31;
		var result = 1;
		result = prime * result + Objects.hash(authMethod, companyName, dateOfMade, modelName);
		return result;
	}

	// equals 재정의
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Electronic that = (Electronic) o;
		return Objects.equals(modelName, that.modelName) 
				&& companyName == that.companyName 
				&& Objects.equals(dateOfMade, that.dateOfMade) 
				&& Arrays.equals(authMethod, that.authMethod);
	}
	
	// toString 재정의
    @Override
    public String toString() {
    	String authMethodStr = (authMethod != null) ? Arrays.toString(authMethod) : "None";  // 본인 인증 방법이 없는 경우
    	return "Electronic{" +
    			"productNo='" + productNo + '\'' +
    			", modelName='" + modelName + '\'' +
    			", companyName=" + companyName +
    			", dateOfMade=" + dateOfMade +
    			", authMethod=" + authMethodStr +
    			'}';
    }
	
}
