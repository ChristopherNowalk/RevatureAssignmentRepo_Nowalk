package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.EventType;
import dev.nowalk.util.HibernateUtil;

public class EventTypeRepoImpl implements EventTypeRepo {

	@Override
	public void addEventType(EventType et) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(et);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}

	}

	@Override
	public List<EventType> getAllEventTypes() {
		Session sess = HibernateUtil.getSession();
		List<EventType> eventTypes = null;
		
		try {
			eventTypes = sess.createQuery("FROM EventType").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return eventTypes;
	}

	@Override
	public EventType getEventType(int id) {
		Session sess = HibernateUtil.getSession();
		EventType et = null;
		
		try {
			et = sess.get(EventType.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return et;
	}

	@Override
	public EventType getEventType(String name) {
		
		Session sess = HibernateUtil.getSession();
		EventType et = null;
		
		
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<EventType> query = builder.createQuery(EventType.class);
			Root<EventType> root = query.from(EventType.class);
			query.select(root).where(builder.equal(root.get("event_type"), name));
			//now with the query created, we can set the employee == to it
			et = sess.createQuery(query).getSingleResult();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return et;
	}

	@Override
	public EventType updateEventType(EventType change) {
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
	public EventType deleteEventType(EventType et) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(et);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.clear();
		}
		return et;
	}

}
