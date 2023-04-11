package assignment3;
import java.util.Arrays;

	public class Electrionics{
		private static Electrionics instance;
		private static Electrionics[] proList;
		private static Electrionics[] newList;
		
		private Electrionics() {}
		//getInstance
		public static Electrionics getInstance() {
			if(instance == null) {
				instance = new Electrionics();
			}
			return instance;
		}


		//findByProductNo
		public Electrionics findByProductNo(String productNo) {
			for(Electrionics user : proList) {
				if(Electrionics.getProductList().equals(productNo)) {
					return user;
				}
			}
			return null;
		}

		//Electronic[] groupByCompanyName(Company company)
		Electrionics[] groupByCompanyName(Company company) {
			for(Electrionics user : proList) {				
				if(Electrionics.getProductList().equals(company)) {
					setNewList(proList);
				}
				return newList;
			}
			return null;
		}
		
		//Electronic[] groupByAuthMethod(Company company)
		Electrionics[] groupByCompanyName(AuthMethod authMethod) {
			for(Electrionics user : proList) {				
				if(Electrionics.getProductList().equals(authMethod)) {
					setNewList(proList);
				}
				return newList;
			}
			return null;
		}
		
		// get set 메소드
		public static Electrionics[] getProductList() {
			return proList;
		}
		public static void setUserList(Electrionics[] proList) {
			Electrionics.proList = proList;
		}
		public static Electrionics[] getNewList() {
			return newList;
		}
		public static void setNewList(Electrionics[] newList) {
			Electrionics.newList = newList;
		}
	}
