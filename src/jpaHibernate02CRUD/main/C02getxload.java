package jpaHibernate02CRUD.main;

import jpaHibernate02CRUD.model.Employee;
import jpaHibernate02CRUD.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class C02getxload {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		Employee employee = null;
		int id = 10;

		/*
		try {
			if (session != null)
				employee = session.get(Employee.class, id);
			if(employee!=null)
				System.out.println(employee);
			else
				System.out.println("Employee record not available for the given id :: "+id);
		} catch (HibernateException e) {
			System.out.println(employee);
			System.out.println("Employee record not found for the given id :: " + id);
		}
		*/

		try {
			if (session != null)
				employee = session.load(Employee.class, id);
			if (employee != null) {
				System.out.println("EID    is :: " + employee.getEmpId());
				System.in.read();
				System.out.println("Name   is :: " + employee.getEmpName());
				System.out.println("Salary is :: " + employee.getEmpSal());
			} else
				System.out.println("Employee record not available for the given id :: " + id);
		} catch (HibernateException e) {
			System.out.println(employee);
			System.out.println("Employee record not found for the given id :: " + id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}


	}
}

/*

get()

> best suited in standalone application
> It performs eager loading.
		(hits the database and gets the record from dbtable and stores in Entity class object
		irrespective of whether we use that Object/not)
> if we call get(), automatically the hibernate will generate the sqlquery and
  hits the database even if the record is not available still hits the database,
  as a result of which we say get() is costly in realtime applications

load()
> best suited in webapplications
> It perform lazy loading
		(hits the database only when we use the object data other than primary key value)
> Upon lazy loading,first hibernate creates the proxy object and sets only pk value to it.
> when we use getter methods on other value then hibernate will hits the database by executing selectquery.
> if the record found then it will create a new object and injects the value to
  that object,otherwise it would result in "ObjectNotFoundException".

*/
