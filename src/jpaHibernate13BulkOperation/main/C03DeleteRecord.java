package jpaHibernate13BulkOperation.main;

import jpaHibernate13BulkOperation.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class C03DeleteRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery("DELETE FROM jpaHibernate13BulkOperation.model.Employee WHERE eno=:id");

			query.setParameter("id",6);

			count = query.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted is :: " + count);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
