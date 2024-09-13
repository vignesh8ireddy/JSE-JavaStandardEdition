package jpaHibernate02CRUD.main;

import jpaHibernate02CRUD.model.Employee;
import jpaHibernate02CRUD.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C07delete {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				int id = 1;
				Employee employee = session.get(Employee.class, id);
				if (employee != null) {
					session.delete(employee);
					flag = true;
				} else {
					System.out.println("Record not available for deletion :: " + id);
					return ;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object deleted succesfuly...");
			} else {
				transaction.rollback();
				System.out.println("Object failed to delete...");
			}

			HibernateUtil.closeSession(session);
		}

	}
}


/*

The above approach is load and then delete. This is good approach

deleting directly is also possible but not a good approach to practice

Employee employee = new Employee();
employee.setEmpId(1);
session.delete(employee);

 */