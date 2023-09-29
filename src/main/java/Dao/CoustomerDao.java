package Dao;

import java.util.List;

import javax.persistence.*;

import Dto.CoustomerDto;

public class CoustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");

	EntityManager entityManager = entityManagerFactory.createEntityManager();

	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void save(CoustomerDto coustomer)// here coustomer value is stored inside the reference and doing the db
									// execution

	{

		entityTransaction.begin();

		entityManager.persist(coustomer);

		entityTransaction.commit();

	}

	public List<CoustomerDto> check1(String email)

	{

		List<CoustomerDto> li = entityManager.createQuery("select y from CoustomerDto y where email=?1")
				.setParameter(1, email).getResultList();

		return li;

	}

	public List<CoustomerDto> check2(String mobile)

	{

		List<CoustomerDto> li = entityManager.createQuery("select y from CoustomerDto y where mobile=?1")
				.setParameter(1, mobile).getResultList();

		return li;

	}
	public CoustomerDto login(int custid)
	{
		CoustomerDto	customer=entityManager.find(CoustomerDto.class,custid);
		return customer;
	}
	public void update(CoustomerDto cutomer) {
		entityTransaction.begin();
		entityManager.merge(cutomer);
		entityTransaction.commit();
	}
}
         