package me.day05.practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class Electronic {
	private static Long registerNo;
	private String productNo;
	private String modelName;
	private Company companyName;
	private LocalDate dateOfMade;
	private AuthMethod[] authMethods;

	public Electronic() {
		if (registerNo == null) {
			registerNo = 0L;
		}
		this.productNo = LocalDate.now().format(DateTimeFormatter.ofPattern("YYMMdd"))
				+ (String.format("%04d", ++registerNo));
	}

	public static Long getRegisterNo() {
		return registerNo;
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

	public LocalDate getDateOfMade() {
		return dateOfMade;
	}

	public void setDateOfMade(LocalDate dateOfMade) {
		this.dateOfMade = dateOfMade;
	}

	public AuthMethod[] getAuthMethods() {
		return authMethods;
	}

	public void setAuthMethods(AuthMethod[] authMethods) {
		this.authMethods = authMethods;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Electronic that = (Electronic)o;
		return productNo.equals(that.productNo) && Objects.equals(modelName, that.modelName)
				&& companyName == that.companyName && Objects.equals(dateOfMade, that.dateOfMade)
				&& Arrays.equals(authMethods, that.authMethods);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productNo);
	}

	@Override
	public String toString() {
		return "Electronic{" +
				"productNo='" + productNo + '\'' +
				", modelName='" + modelName + '\'' +
				", companyName=" + companyName +
				", dateOfMade=" + dateOfMade +
				", authMethods=" + Arrays.toString(authMethods) +
				'}';
	}
}
