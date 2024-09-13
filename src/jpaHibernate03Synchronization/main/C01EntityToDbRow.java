package jpaHibernate03Synchronization.main;

import jpaHibernate03Synchronization.model.Employee;
import jpaHibernate03Synchronization.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C01EntityToDbRow {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		Boolean flag = false;
		Employee employee = null;

		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class, 19);
			if (employee != null) {
				System.out.println(employee);
				employee.setEmpSal(54555.5);
				flag = true;
			}else {
				System.out.println("Record not avaialble...");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();//update operation is performed
				System.out.println("object upated...");
			} else {
				transaction.rollback();
				System.out.println("object failed to update...");
			}
		}
	}

}
