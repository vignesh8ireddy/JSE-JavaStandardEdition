package jpaHibernate13BulkOperation.main;

import jpaHibernate13BulkOperation.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class C04UpdateRecord {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		int count = 0;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Query query = session.createQuery("UPDATE jpaHibernate13BulkOperation.model.Employee SET esalary=esalary + :increment  WHERE eno <= :id");

			query.setParameter("increment", 50);
			query.setParameter("id", 18);

			count = query.executeUpdate();
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records updated is :: " + count);
			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
