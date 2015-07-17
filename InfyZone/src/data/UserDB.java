package data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.DemoCustomer;
import model.DemoUser;

public class UserDB {
	public static  List<DemoUser> ValidateExistingUser(String oldUserEmail, String oldUserPassword)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from DemoUser u where u.userEmail = :oldUserEmail and u.password = :oldUserPassword";
		TypedQuery<DemoUser> q = em.createQuery(qString, DemoUser.class);
		q.setParameter("oldUserEmail", oldUserEmail);
		q.setParameter("oldUserPassword", oldUserPassword);
		List<DemoUser> i = null;
		
		try
		{
			i = q.getResultList();
			if(i == null || i.isEmpty())
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally
		{
			em.close();
		}
		return i;
	
	}
	
	
	public static void AddUser(String newUserName, String newUserEmailid, String newUserPassword)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try
		{
			model.DemoUser user= new model.DemoUser();
			
			user.setUserName(newUserName);
		    user.setUserEmail(newUserEmailid);
			user.setPassword(newUserPassword);
			user.setCreatedOn(new Date());
			user.setAdminUser("N");
			user.setQuota(new BigDecimal(20000));
			user.setProducts("Y");
			em.persist(user);
			em.flush();
			trans.commit();
			System.out.println("New user is created!");
		}
		catch(NoResultException e)
		{
			System.out.println(e);
			trans.rollback();
		}
		
		finally
		{
			em.close();
		}
	
	}
	
	public static void AddCustomer(DemoCustomer cust)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try
		{
			em.persist(cust);
			em.flush();
			trans.commit();
			
		}
		catch(NoResultException e)
		{
			System.out.println(e);
			trans.rollback();
		}
		
		finally
		{
			em.close();
		}
	
	}
	
	
	public static  DemoCustomer GetCustomerByUserID(long userId) {
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select c from DemoCustomer c where c.demoUser.userId = :userId";
		TypedQuery<DemoCustomer> q = em.createQuery(qString, DemoCustomer.class);
		q.setParameter("userId", userId).setMaxResults(1);
		
		DemoCustomer i = null;
		
		try
		{
			i = q.getSingleResult();
			if(i == null)
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally
		{
			em.close();
		}
		return i;
		
	}
	
	public static  DemoUser GetUserByEmailAndPassword(String oldUserEmail, String oldUserPassword)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from DemoUser u where u.userEmail = :oldUserEmail and u.password = :oldUserPassword";
		TypedQuery<DemoUser> q = em.createQuery(qString, DemoUser.class);
		q.setParameter("oldUserEmail", oldUserEmail);
		q.setParameter("oldUserPassword", oldUserPassword);
		DemoUser i = null;
		
		try
		{
			i = q.getSingleResult();
			if(i == null)
			{
				i = null;
			}
		}
		catch(NoResultException e)
		{
			System.out.println(e);
		}
		
		finally
		{
			em.close();
		}
		return i;
	
	}
	
}
