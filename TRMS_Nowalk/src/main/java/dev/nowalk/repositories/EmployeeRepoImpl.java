package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.Employee;
import dev.nowalk.util.HibernateUtil;

public class EmployeeRepoImpl implements EmployeeRepo {

	public void addEmployee(Employee e) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			
			sess.save(e);
			tx.commit();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
	}

	public List<Employee> getAllEmployees() {
		
		Session sess = HibernateUtil.getSession();
		List<Employee> employees = null;
		
		try {
			employees = sess.createQuery("FROM Employee").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return employees;
	}

	@Override
	public Employee getEmployee(int id) {
		
		Session sess = HibernateUtil.getSession();
		Employee em = null;

		try {
			em = sess.get(Employee.class, id);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return em;
	}

	public Employee getEmployee(String name) {
		
		Session sess = HibernateUtil.getSession();
		Employee em = null;
		
		
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = query.from(Employee.class);
			query.select(root).where(builder.equal(root.get("name"), name));
			//now with the query created, we can set the employee == to it
			em = sess.createQuery(query).getSingleResult();

		} catch (NoResultException e) {
			e.printStackTrace();
			em = null;
		} finally {
			sess.close();
		}
		return em;
	}
	
	@Override
	public Employee updateEmployee(Employee change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(change);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return change;
	}

	@Override
	public Employee deleteEmployee(Employee em) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(em);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return em;
	}

}
