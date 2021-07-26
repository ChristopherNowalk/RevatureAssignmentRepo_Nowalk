package dev.nowalk.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dev.nowalk.models.GradingFormat;
import dev.nowalk.util.HibernateUtil;

public class GradingFormatRepoImpl implements GradingFormatRepo {

	@Override
	public void addGradingFormat(GradingFormat gf) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.save(gf);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
	}

	@Override
	public List<GradingFormat> getAllGradingFormats() {
		Session sess = HibernateUtil.getSession();
		List<GradingFormat> gradingFormats = null;
		
		try {
			gradingFormats = sess.createQuery("FROM GradingFormat").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		
		return gradingFormats;
	}

	@Override
	public GradingFormat getGradingFormat(int id) {
		Session sess = HibernateUtil.getSession();
		GradingFormat gf = null;
		
		try {
			gf = sess.get(GradingFormat.class, id);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return gf;
	}

	@Override
	public GradingFormat getGradingFormat(String type) {
		Session sess = HibernateUtil.getSession();
		GradingFormat gf = null;
		
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<GradingFormat> query = builder.createQuery(GradingFormat.class);
			Root<GradingFormat> root = query.from(GradingFormat.class);
			query.select(root).where(builder.equal(root.get("grading_type"), type));
			
			gf = sess.createQuery(query).getSingleResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sess.close();
		}
		return gf;
	}

	@Override
	public GradingFormat updateGradingFormat(GradingFormat change) {
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
	public GradingFormat deletGradingFormat(GradingFormat gf) {
		Session sess = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = sess.beginTransaction();
			sess.delete(gf);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sess.close();
		}
		return gf;
	}

}
