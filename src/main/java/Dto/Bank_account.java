package Dto;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Bank_account {
@Id
@SequenceGenerator(initialValue = 445321686,allocationSize = 1,sequenceName = "accNo",name = "accNo")
@GeneratedValue(generator = "accNo")
long acc_no;
double balance;
boolean status;
double acc_limit;
String accountType;  // we can have saving and current type of accounts for a single user in any bank

@ManyToOne
CoustomerDto customer;
@OneToMany(cascade = CascadeType.ALL)// by diong this i can skip the et.begin(),em.persist(),et.commit()
List<Banktransaction>banktransations;
public long getAcc_no() {
	return acc_no;
}
public void setAcc_no(long acc_no) {
	this.acc_no = acc_no;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public double getAcc_limit() {
	return acc_limit;
}
public void setAcc_limit(double acc_limit) {
	this.acc_limit = acc_limit;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public CoustomerDto getCustomer() {
	return customer;
}
public void setCustomer(CoustomerDto customer) {
	this.customer = customer;
}
public List<Banktransaction> getBanktransations() {
	return banktransations;
}
public void setBanktransations(List<Banktransaction> banktransations) {
	this.banktransations = banktransations;
}








}



