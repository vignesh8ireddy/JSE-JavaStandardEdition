package jpaHibernate03Synchronization.main;

import jpaHibernate03Synchronization.model.Employee;
import jpaHibernate03Synchronization.util.HibernateUtil;
import org.hibernate.Session;

public class C02DbRowToEntity {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Employee employee = null;

		try {
			
			employee = session.get(Employee.class, 19);
			if (employee != null) {
				System.out.println("Before any modification :: " + employee);

				System.in.read();//pause the execution(mean while make some change by going to databasee)
				
				session.refresh(employee);
				System.out.println("After modification in the dbTable :: " + employee);

			} else {
				System.out.println("Record not avaialble...");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
