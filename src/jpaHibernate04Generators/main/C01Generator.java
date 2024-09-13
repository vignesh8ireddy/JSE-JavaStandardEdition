package jpaHibernate04Generators.main;

import jpaHibernate04Generators.model.Employee;
import jpaHibernate04Generators.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C01Generator {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Employee employee = new Employee();
				employee.setEmpName("gambir");
				employee.setEmpSal(6645.6);

				Integer id = (Integer) session.save(employee);
				System.out.println("The id of the student is :: " + id);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag == true)
				transaction.commit();
			else
				transaction.rollback();

			HibernateUtil.closeSession(session);
		}

	}

}
