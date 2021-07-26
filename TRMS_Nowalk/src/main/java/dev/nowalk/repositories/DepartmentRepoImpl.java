package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.Department;
import dev.nowalk.models.Employee;
import dev.nowalk.util.HibernateUtil;

public class DepartmentRepoImpl implements DepartmentRepo {

	public void addDepartment(Department d) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(d);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
	}

	@Override
	public List<Department> getAllDepartments() {
		Session sess = HibernateUtil.getSession();
		List<Department> departments = null;
		
		try {
			departments = sess.createQuery("FROM Department").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return departments;
	}

	@Override
	public Department getDepartment(int id) {
		Session sess = HibernateUtil.getSession();
		Department d = null;
		
		try {
			d = sess.get(Department.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return d;
	}

	@Override
	public Department updateDepartment(Department change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(change);;
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
	public Department deleteDepartment(Department d) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(d);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return d;
	}

	@Override
	public Department getDepartmentByName(String name) {
		Session sess = HibernateUtil.getSession();
		Department d = null;
		
		
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Department> query = builder.createQuery(Department.class);
			Root<Department> root = query.from(Department.class);
			query.select(root).where(builder.equal(root.get("name"), name));
			//now with the query created, we can set the employee == to it
			d = sess.createQuery(query).getSingleResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return d;
	}

}
