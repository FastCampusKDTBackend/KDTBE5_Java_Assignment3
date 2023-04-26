package me.day05.practice.practice03;

import me.day05.practice.practice01.AuthMethod;
import me.day05.practice.practice01.Company;
import me.day05.practice.practice01.Electronic;

public class Electronics {
	
	private Electronic[] electronicList;

	// 실습 3-1. Electronics 클래스의 객체를 싱글톤으로 생성하는 함수를 작성하시오.
	private static Electronics electronics;
	
	private Electronics() {
		electronicList = new Electronic[10];
	}
	
	public static Electronics gerInstance() {
		if(electronics == null) {
			electronics = new Electronics();
		}
		return electronics;
	}
	
	public Electronic[] getElectronicList() {
		return electronicList;
	}

	public void setElectronicList(Electronic[] electronicList) {
		this.electronicList = electronicList;
	}
	
	// 실습 3-2. 전자제품 일련번호 productNo를 통해 인자로 주어진 일련번호에 해당하는 전자제품을 반환하는 함수를 작성하시오.
	public Electronic findByProductNo(String productNo) {
		for(int i = 0; i < electronicList.length; i++) {
			if(electronicList[i].getProductNo() == productNo) {
				return electronicList[i]; 
			}
		}
		System.out.println("찾는 productNo 가 없습니다.");
		return null;
	}
	
	// 실습 3-3. 전자제품들 중 인자로 주어진 제조 회사를 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
	public Electronic[] groupByCompanyName(Company company) {
		Electronic[] productOfGroupBycompany = new Electronic[10];
		int count = 0;
		for(int i = 0; i < electronicList.length; i++) {
			if(electronicList[i].getCompanyName() == company) {
				productOfGroupBycompany[count] = electronicList[i];
				++count;
			}
		}
		return productOfGroupBycompany;
	}
	
	// 실습 3-4. 전자제품들 중 인자로 주어진 인증 방법을 찾아서 하나의 배열에 반환하는 함수를 작성하시오.
	public Electronic[] groupByAuthMethod(AuthMethod authMethod) {
		Electronic[] productOfGroupByauthMethod = new Electronic[10];
		int count = 0;
		for(int i = 0; i < electronicList.length; i++) {
			if(electronicList[i].getAuthMethod() == authMethod) {
				productOfGroupByauthMethod[count] = electronicList[i];
				++count;
			}
		}
		return productOfGroupByauthMethod;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Electronics) {
			if(((Electronics) obj).getElectronicList().length == electronicList.length) {
				for(int i = 0; i < electronicList.length; i++) {
					if(electronicList[i].getProductNo() != ((Electronics)obj).getElectronicList()[i].getProductNo()) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return electronicList.hashCode();
	}


	@Override
	public String toString() {
		return "총 전차제품 수: " + electronicList.length;
	}
	
}
