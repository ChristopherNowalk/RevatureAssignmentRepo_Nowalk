package dev.nowalk.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.Event;
import dev.nowalk.models.Request;
import dev.nowalk.util.HibernateUtil;

public class RequestRepoImpl implements RequestRepo {

	@Override
	public void addRequest(Request r) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
	}

	@Override
	public List<Request> getAllRequests() {

		Session sess = HibernateUtil.getSession();
		List<Request> requests = null;
		try {
			requests = sess.createQuery("FROM Request").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}		
		
		return requests;
	}

	@Override
	public Request getRequest(int id) {
		
		Session sess = HibernateUtil.getSession();
		Request r = null;
		
		try {
			r = sess.get(Request.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return r;
	}

	@Override
	public Request updateRequest(Request r) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.saveOrUpdate(r);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
		return r;
	}

	@Override
	public Request deleteRequest(Request r) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(r);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
		return r;
	}

}
