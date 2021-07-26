package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import dev.nowalk.models.Actor;
import dev.nowalk.util.HibernateUtil;

public class ActorRepoHBImpl implements ActorRepo {

	@Override
	public Actor addActor(Actor a) {
		
		//we create this session obj each time because we want the session to be short lived
		//once we add an actor the session should be over
		Session sess = HibernateUtil.getSession();
		try {
			
			sess.beginTransaction();
			//here we take the serializable the save(a), and we want to set that to the id of our actor
			//so we need to take that return and call toString then parse that string into an int so we can set id
			a.setId((int)sess.save(a));
			//now we are getting our transaction and committing it
			sess.getTransaction().commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			//if there is any problem with putting this into our DB, rollback the transaction
			sess.getTransaction().rollback();
			a = null;
		} finally {
			sess.close();
		}
		
		return a;
	}

	@Override
	public List<Actor> getAllActors() {
		
		Session sess = HibernateUtil.getSession();
		List<Actor> actors = null;
		
		try {
			//it is expecting a HQL statement
			//equivalent in SQL: SELECT * FROM actors
			//HQL - wants you to be able to just use your  Java Classes
			actors = sess.createQuery("FROM Actor").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return actors;
	}

	@Override
	public Actor getActor(int id) {
		
		Session sess = HibernateUtil.getSession();
		Actor a = null;
		
		try {
			a = sess.get(Actor.class, id);
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			//no matter what we want to close out of our session
			sess.close();
		}
		
		return a;
	}

	@Override
	public Actor getActor(String name) {
		
		Session sess = HibernateUtil.getSession();
		Actor a = null;
		
		try {
			//create a criteria object
			//this is the depracated approach
			Criteria crit = sess.createCriteria(Actor.class);
			crit.add(Restrictions.eq("name", name));
			
//			a = (Actor)crit.uniqueResult();
			//if there is more than one result for that criteria, we can use crit.list.get(0)
			a = (Actor)crit.list().get(0);
			
//			CriteriaQuery<Actor> crit = sess.getCriteriaBuilder().createQuery(Actor.class);
			
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return a;
	}

	@Override
	public Actor updateActor(Actor change) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
				
		try {
			
			tx = sess.beginTransaction();
			sess.update(change);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			change = null;
		} finally {
			sess.close();
		}
		
		return change;
	}

	@Override
	public Actor deleteActor(int id) {
		
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		Actor a = sess.get(Actor.class, id);
		try {
			tx = sess.beginTransaction();
			sess.delete(a);
			tx.commit();			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return null;
		} finally {
			sess.close();
		}
		
		return a;
	}

}
