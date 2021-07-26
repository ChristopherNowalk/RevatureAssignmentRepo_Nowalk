package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.Event;
import dev.nowalk.util.HibernateUtil;

public class EventRepoImpl implements EventRepo {

	@Override
	public void addEvent(Event ev) {	
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(ev);
			tx.commit();	
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
	}

	@Override
	public List<Event> getAllEvents() {
		Session sess = HibernateUtil.getSession();
		List<Event> events = null;
		try {
			events = sess.createQuery("FROM Event").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return events;
	}

	@Override
	public Event getEvent(int id) {
		Session sess = HibernateUtil.getSession();
		Event ev = null;
		try {
			ev = sess.get(Event.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return ev;
	}

	@Override
	public Event getEvent(String event_name) {
		Session sess = HibernateUtil.getSession();
		Event ev = null;
		
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Event> query = builder.createQuery(Event.class);
			Root<Event> root = query.from(Event.class);
			query.select(root).where(builder.equal(root.get("event_name"), event_name));
			
			ev = sess.createQuery(query).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return ev;
	}

	@Override
	public Event updateEvent(Event change) {
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
	public Event deleteEvent(Event ev) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.delete(ev);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return ev;
	}
	
}
