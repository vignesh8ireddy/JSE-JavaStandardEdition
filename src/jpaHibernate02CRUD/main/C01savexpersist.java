package jpaHibernate02CRUD.main;

import jpaHibernate02CRUD.model.Employee;
import jpaHibernate02CRUD.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C01savexpersist	 {

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
				employee.setEmpId(19);
				employee.setEmpName("Dravid");
				employee.setEmpSal(5566.7);

				session.persist(employee); //inserts into L1 cache
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag == true)
				transaction.commit();// now inserts into database table
			else
				transaction.rollback();

			HibernateUtil.closeSession(session);
		}

	}
}


/*

save()
> Serializable.save(Object obj)
> This method gives instructions to save object and also return the assigned or
generated identity value back to the application as the return value.
> This method is own method of hibernate(not as per specification of JPA).

note: if generators are not configured, then value assigned to id property will be
returned as identity value.

Employee.java
============
@Id
@Column(name = "eid")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer empId;
As noticed above we have told hibernated to generate the value of empId, so
the generated value is "AutoIncrement" for MySQLDB


persist()

> void persist(Object object)
> return type is void, cannot return the identity value.
> This method is given by JPA specification and it is implemented by Hibernate.
	so this method can be used by any framework that implements jpa specification
> Gives instruction to hibernate to perform save operation on the object.
> persist() does not allows to work with generators.



Go for save() if using hibernate always
 */