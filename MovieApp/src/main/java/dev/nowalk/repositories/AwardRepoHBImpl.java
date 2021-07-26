package dev.nowalk.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.Actor;
import dev.nowalk.models.Award;
import dev.nowalk.models.Movie;
import dev.nowalk.util.HibernateUtil;

public class AwardRepoHBImpl implements AwardRepo {

	@Override
	public void addAward(Award a) {

		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			/*
			 * Save vs Persist
			 * 
			 * Save will save to the database and returns a serializable ID.
			 * 
			 * Persist will save to the database and has a void return.
			 * 
			 * (using them is basically identical, persist will be useful for very niche cases which you can look up on the interwebs)
			 */
			sess.persist(a);
			tx.commit();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		
	}

	@Override
	public List<Award> getAllAwards() {
		
		Session sess = HibernateUtil.getSession();
		List<Award> awards = null;
		
		try {
			//it is expecting a HQL statement
			//equivalent in SQL: SELECT * FROM actors
			//HQL - wants you to be able to just use your  Java Classes
			awards = sess.createQuery("FROM Award").list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return awards;
	}

	@Override
	public Award getAward(int id) {

		Session sess = HibernateUtil.getSession();
		Award a = null;
		
		try {
			/*
			 * Get vs Load
			 * 
			 * get() - Eager loading - immediately goes to the database and gets all the 
			 * information associated with the object
			 * 
			 * load() - lazy loading - will return a proxy. That object will have many fields that
			 * don't have a value. Thise values are only loaded when they are specifically requested
			 * for later in the code.
			 */
			//a = sess.load(Award.class, id);
			a = sess.get(Award.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return a;
	}

	@Override
	public Award updateAward(Award change) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			/*
			 * Update vs Merge
			 * 
			 * Hibernate does not allow two Objects with the same ID in the same session.
			 * 
			 * update() on an Object in the session with an object already present with the 
			 * same id, this will throw an Exception. because it doesn't know which Object should
			 * actually be changed
			 * 
			 *  -NonUniqueObjectException
			 *  
			 *  merge() will replace the Object with the new Object in the session.
			 *  
			 *  -------------------
			 *  
			 *  saveOrUpdate() - Saves if not in database, or Updates otherwise.
			 */
			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return null;
	}

	@Override
	public Award deleteAward(Award a) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
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
