package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Bank_account;
public class BankDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void save(Bank_account bankAccount2) {
		
		entityTransaction.begin();
		entityManager.persist(bankAccount2);
		entityTransaction.commit();
}
	public List<Bank_account> fetchAll()
	{
	List<Bank_account> accountList=entityManager.createQuery("select x from Bank_account x").getResultList();
	return accountList;
	}
	public Bank_account fetch(long acno)
	{
		Bank_account bank_account=entityManager.find(Bank_account.class,acno);
		return bank_account;
	}
	public void update(Bank_account bankAccount) {
		entityTransaction.begin();
		entityManager.merge(bankAccount);
		entityTransaction.commit();
		
	}
	}