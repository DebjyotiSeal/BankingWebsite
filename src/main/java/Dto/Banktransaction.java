package Dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Banktransaction {
	@GeneratedValue(strategy = GenerationType.AUTO)//by using this we can generate t_id automatically
	@Id
int t_id;
double deposit;
double withdraw;
double balance;
LocalDateTime datetime;
public int getT_id() {
	return t_id;
}
public void setT_id(int t_id) {
	this.t_id = t_id;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit1(double deposit) {
	this.deposit = deposit;
}
public double getWithdraw() {
	return withdraw;
}
public void setWithdraw(double withdraw) {
	this.withdraw = withdraw;
}
public double getBalance() {
	return balance;
}
public void setBalance1(double balance) {
	this.balance = balance;
}
public LocalDateTime getDatetime() {
	return datetime;
}
public void setDatetime(LocalDateTime datetime) {
	this.datetime = datetime;
}
public void setDeposit(double amount) {
	// TODO Auto-generated method stub
	
}
public void setBalance(double balance2) {
	// TODO Auto-generated method stub
	
}

}
