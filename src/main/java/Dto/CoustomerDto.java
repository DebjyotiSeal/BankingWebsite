package Dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class CoustomerDto {
	@Id

	@SequenceGenerator(initialValue = 112233445, allocationSize = 1, sequenceName = "cust_id", name = "cust_id")

	@GeneratedValue(generator = "cust_id")

	int cust_id;

	String name;

	String email;

	String password;

	String gender;

	String mobile;

	Date date;

	@OneToMany
	List<Bank_account> bankAccounts;
	public int getCust_id() {

		return cust_id;

	}

	public void setCust_id(int cust_id) {

		this.cust_id = cust_id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getGender() {

		return gender;

	}

	public void setGender(String gender) {

		this.gender = gender;

	}

	public String getMobile() {

		return mobile;

	}

	public void setMobile(String mobile) {

		this.mobile = mobile;

	}

	public Date getDate() {

		return date;

	}

	public void setDate(Date date) {

		this.date = date;

	}
	public List<Bank_account> getBankAccounts() {
		return  bankAccounts;
	}

	public void setBankAccounts(List<Bank_account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

}
