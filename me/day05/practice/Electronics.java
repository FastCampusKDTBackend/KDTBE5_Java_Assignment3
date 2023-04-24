package me.day05.practice;

import java.util.Arrays;

public class Electronics {
	private static Electronics electronics;
	private Electronic[] electronicList;

	private Electronics() {

	}

	public static Electronics getInstance() {
		if (electronics == null) {
			electronics = new Electronics();
		}
		return Electronics.electronics;
	}

	public Electronic findByProductNo(String productNo) {
		return Arrays.stream(this.electronicList)
				.filter(electronic -> electronic.getProductNo().equals(productNo))
				.findFirst()
				.orElse(null);
	}

	Electronic[] groupByCompany(Company company) {
		return Arrays.stream(this.electronicList)
				.filter(electronic -> electronic.getCompanyName().equals(company))
				.toArray(Electronic[]::new);
	}

	Electronic[] groupByAuthMethod(AuthMethod authMethod) {
		return Arrays.stream(this.electronicList)
				.filter(
						electronic -> Arrays.stream(electronic.getAuthMethods())
								.anyMatch(authMethods -> authMethods.equals(authMethod))
				).toArray(Electronic[]::new);
	}

	public Electronic[] getElectronicList() {
		return electronicList;
	}

	public void setElectronicList(Electronic[] electronicList) {
		this.electronicList = electronicList;
	}
}
