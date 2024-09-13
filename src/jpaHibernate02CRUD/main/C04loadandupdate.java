package jpaHibernate02CRUD.main;

import jpaHibernate02CRUD.model.Employee;
import jpaHibernate02CRUD.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C04loadandupdate {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Boolean flag = false;
		Transaction transaction = null;
		Employee employee = null;

		try {
			int id = 19;
			employee = session.get(Employee.class, id);
			if (employee != null) {
				transaction = session.beginTransaction();
				employee.setEmpName("dravid");
				employee.setEmpSal(5567.5);
				session.update(employee);
				flag = true;
			} else {
				System.out.println("Record not found for the id :: " + id);
				System.exit(0);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
			} else {
				transaction.rollback();
				System.out.println("object failed to update...");
			}
		}
	}
}
