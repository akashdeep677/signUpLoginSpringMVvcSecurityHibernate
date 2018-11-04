package com.luv2code.springdemo.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Authorities;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.Root;
import com.luv2code.springdemo.entity.Subroot;
import com.luv2code.springdemo.entity.Users;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	List<Subroot> subrootnull;
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public boolean saveCustomer(Customer theCustomer) {
		

		Boolean b = exist(theCustomer);
		// get current hibernate session
		if(b==false) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer in database
		String str = (String) currentSession.save(theCustomer);
		System.out.println(str);
		return true;
		}
		else {
			System.out.println("user exist already");
			return false;
		}
	}
	public Boolean exist (Customer theCustomer ) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query q = currentSession.             
	    createQuery("select 3 from Customer theCustomer where theCustomer.email= :abc ");
	        q.setParameter("abc", theCustomer.getEmail());
	    return (q.uniqueResult() != null);

	}
	@Override
	public void saveUserAuth(Users users) {
		Session currentSession = sessionFactory.getCurrentSession();
		String str = (String) currentSession.save(users);
		System.out.println("store in users "+str);
		
	}
	@Override
	public void saveAuthorities(Authorities authorities) {
		Session currentSession = sessionFactory.getCurrentSession();
		String str = (String) currentSession.save(authorities);
		System.out.println("store in authorities "+str);
		
	}
	@Override
	public boolean saveRoot(Root theRoot) {
		
		Boolean b = exist1(theRoot);
		// get current hibernate session
		if(b==false) {
		Session currentSession = sessionFactory.getCurrentSession();

		getSubrootid(theRoot.getId());
		currentSession.saveOrUpdate(theRoot);
		
		//System.out.println(str);
		return true;
		}
		else {
			System.out.println("user exist already");
			return false;
		}
	}
	
	

	public Boolean exist1 (Root theRoot ) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query q = currentSession.             
	    createQuery("select 2,3 from Root theRoot where (theRoot.userName= :abc AND theRoot.rootName= :xyz)");
        q.setParameter("abc", theRoot.getUserName());
        q.setParameter("xyz", theRoot.getRootName());
	    return (q.uniqueResult() != null);

	}
	@Override
	public List<Root> getRoots(String uname) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<Root> theQuery = 
						currentSession.createQuery("from Root where userName= :abc order by rootName",
													Root.class);
		        theQuery.setParameter("abc", uname);

				// execute query and get result list
				List<Root> roots = theQuery.getResultList();
						
				// return the results		
				return roots;
	}
	@Override
	public boolean saveSubroot(Subroot theSubroot) {
		Boolean b = exist2(theSubroot);
		// get current hibernate session
		if(b==false) {
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer in database
		currentSession.saveOrUpdate(theSubroot);
		//System.out.println(str);
		return true;
		}
		else {
			System.out.println("user exist already");
			return false;
		}
	}
	public Boolean exist2 (Subroot theSubroot ) {
		Session currentSession = sessionFactory.getCurrentSession();
	    Query q = currentSession.             
	    createQuery("select 2,3 from Subroot theSubroot where (theSubroot.subrootName= :mn AND theSubroot.rootid= :xyz)");
        q.setParameter("mn", theSubroot.getSubrootName());
        q.setParameter("xyz", theSubroot.getRootid() );
	    return (q.uniqueResult() != null);

	}
	@Override
	public List<Subroot> getSubRoots(int rootid) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Subroot> theQuery = 
				currentSession.createQuery("from Subroot where rootid= :abc order by subrootName",
						Subroot.class);
        theQuery.setParameter("abc", rootid);

		// execute query and get result list
		List<Subroot> subroots = theQuery.getResultList();
				
		// return the results		
		return subroots;
	}
	@Override
	public void deleteRoot(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
			System.out.println("delete dao");
			
			Root ins = currentSession.get(Root.class, theId);
			//delete course
			currentSession.delete(ins);
			
		   
			System.out.println("Done! ");
		//Query q = currentSession.createQuery("delete from Root where id= :x");
		//q.setParameter("x", theId);
		System.out.println("delete dao");

	}
	@Override
	public void deleteSubroot(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("delete  sub root dao");
		
		Subroot ins = currentSession.get(Subroot.class, theId);
		//delete course
		currentSession.delete(ins);
		
	   
		
	}
	
	@Override
	public void updateSubrootNull() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
		System.out.println("enter removeNullinSubroot");
		
		for (Subroot subroot : subrootnull) {
			System.out.println("enter inside for");
			System.out.println(subroot.getRootid());
			currentSession.saveOrUpdate(subroot);
		}
		System.out.println("outside removeNullinSubroot");
		
		subrootnull.clear();
		
	}
	//avoid null in subroot root_id upon updating root
	private void getSubrootid(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query  ... sort by last name
				Query<Subroot> theQuery = 
						currentSession.createQuery("from Subroot where rootid= :abc ",
								Subroot.class);
		        theQuery.setParameter("abc", id);

				// execute query and get result list
				subrootnull = theQuery.getResultList();
		System.out.println(subrootnull);
	}
	
	
}
