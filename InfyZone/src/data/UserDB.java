package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.DemoUser;

public class UserDB {
	protected static  List<DemoUser> ValidateExistingUser(String oldUserName, String oldUserPassword)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		String qString = "Select u from DemoUser u where u.userName = :oldUserName and u.password = :oldUserPassword";
		TypedQuery<DemoUser> q = em.createQuery(qString, DemoUser.class);
		q.setParameter("oldUserName", oldUserName);
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
	
	
	protected static void AddUser(String newUserName, String newCustomerEmailid, String newCustomerPassword)
	{
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try
		{
			model.DemoUser user= new model.DemoUser();
			
			user.setUserName(newUserName);
		//	user.setUserEmail(newUserEmailid);
			user.setPassword(newCustomerPassword);
			
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
}
