package assignment3;

import java.util.Arrays;
import java.util.Objects;

public class ElectronicEx01 {
	
	String productNo;
	String modelname;
	public enum companyName{
		SAMSUNG,LG,APPLE
	}
	String dateOfMade;
	String[] methodArr;
	public enum authMethod{
		HANDPRINT,PATTERN,PIN,FACE
	}
	
	UserEx01 elect = new UserEx01();
	
	
	
	
	@Override
	public String toString() {
		return "ElectronicEx01 [productNo=" + productNo + ", modelname=" + modelname + ", dateOfMade=" + dateOfMade
				+ ", methodArr=" + Arrays.toString(methodArr) + ", elect=" + elect + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(methodArr);
		result = prime * result + Objects.hash(dateOfMade, elect, modelname, productNo);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectronicEx01 other = (ElectronicEx01) obj;
		return Objects.equals(dateOfMade, other.dateOfMade) && Objects.equals(elect, other.elect)
				&& Arrays.equals(methodArr, other.methodArr) && Objects.equals(modelname, other.modelname)
				&& Objects.equals(productNo, other.productNo);
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public String getDateOfMade() {
		return dateOfMade;
	}
	public void setDateOfMade(String dateOfMade) {
		this.dateOfMade = dateOfMade;
	}
	public String[] getMethodArr() {
		return methodArr;
	}
	public void setMethodArr(String[] methodArr) {
		this.methodArr = methodArr;
	}
	public UserEx01 getElect() {
		return elect;
	}
	public void setElect(UserEx01 elect) {
		this.elect = elect;
	}
	
	
}
