package jac.finalproject.model;

import java.io.*;


public class SocialSECBean implements Serializable {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String SSN, fName, mi, lName, birthDate, street, phone, zipcode, depId ;

/**
 * @param sSN
 * @param fName
 * @param mi
 * @param lName
 * @param birthDate
 * @param street
 * @param phone
 * @param zipcode
 * @param depId
 */
public SocialSECBean() {
	this.SSN = "";
	this.fName = "";
	this.mi = "";
	this.lName = "";
	this.birthDate = "";
	this.street = "";
	this.phone = "";
	this.zipcode = "";
	this.depId = "";
}

public String getSSN() {
	return SSN;
}

public void setSSN(String sSN) {
	SSN = sSN;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getMi() {
	return mi;
}

public void setMi(String mi) {
	this.mi = mi;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getBirthDate() {
	return birthDate;
}

public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getZipcode() {
	return zipcode;
}

public void setZipcode(String zipcode) {
	this.zipcode = zipcode;
}

public String getDepId() {
	return depId;
}

public void setDepId(String depId) {
	this.depId = depId;
}


  
  
  

}
