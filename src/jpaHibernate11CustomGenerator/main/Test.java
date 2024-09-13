package jpaHibernate11CustomGenerator.main;

import jpaHibernate11CustomGenerator.model.Employee;
import jpaHibernate11CustomGenerator.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

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
				employee.setEmpName("Sachin");
				employee.setEmpSal(756787.56);
				session.save(employee);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag == true) {
				transaction.commit();
				System.out.println("Object inserted succesfuly...");
			} else {
				transaction.rollback();
				System.out.println("Object failed to insert...");
			}

			HibernateUtil.closeSession(session);
		}

	}

}


/*

Customgenerator
===============

> Hibernate and JPA have supplied predefined generators to create primary key value
for almost all databases.
	eg: identity,increment,auto,sequence,.....
> If we want a primary key value to be generated for our columns as per our
application needs then we need to go custom generators.
> To create our own generator we need to implement an interface called "IdentifierGenerator"
> It is a functional interface which contains only one method
	public Serializable generate(SharedSessionContractImplementor session,Object object) throws HibernateException

	<id name="empId" type="java.lang.Integer" column="eid" >
		<generator class="jpaHibernate11CustomGenerator.generator.RandomGenerator"/>
	</id>
 */