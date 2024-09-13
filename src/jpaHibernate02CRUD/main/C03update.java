package jpaHibernate02CRUD.main;

import jpaHibernate02CRUD.model.Employee;
import jpaHibernate02CRUD.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C03update {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Boolean flag = false;
		Transaction transaction = null;

		// updating the total object based on id
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("jadeja");
		employee.setEmpSal(2445.7);

		try {
			transaction = session.beginTransaction();
			session.update(employee);
			flag = true;

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
				HibernateUtil.closeSession(session);
			}
		}
	}
}

/*

1. update()

i) void update(Object object)

> This method is used to modify the record of the DBTable.
> Set the primary key value and change the other non-primary data for updation.
> To use update(), we should remember whether record exists or not for the give primary key value.
otherwise it would result in "HibernateException".
> It would directly generate "update query" without "select query".

ii)Load the object from database and then modify

> Here we won't get Exception as the object is available we do modify the Object.

2.saveOrUpdate()

If the object/record is already available only then it will update the record otherwise
it will insert/create a new record

3. merge()

On the loaded object, if we want to update the data then we need to go for merge()

4. refresh()

> used to for the synchronisation of dbrecord to java object.

*/
