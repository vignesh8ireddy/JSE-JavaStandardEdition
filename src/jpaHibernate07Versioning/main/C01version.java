package jpaHibernate07Versioning.main;

import jpaHibernate07Versioning.model.MobileCustomer;
import jpaHibernate07Versioning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class C01version {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		MobileCustomer customer = null;
		Integer idValue = null;
		boolean flag = false;

		session = HibernateUtil.getSession();

		/*
		customer = new MobileCustomer();
		customer.setCname("sachin");
		customer.setMobileNo(999888776);
		customer.setCallerTune("KGF-2");

		try {
			transaction = session.beginTransaction();
			idValue = (Integer) session.save(customer);
			System.out.println("Generated id value is :: " + idValue);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object is saved...");
			} else {
				transaction.rollback();
				System.out.println("Object is not saved...");
			}
			HibernateUtil.closeSession(session);
		}
*/


		try {
			transaction = session.beginTransaction();
			customer = session.get(MobileCustomer.class, 1);

			if (customer != null) {
				System.out.println(customer);
				customer.setCallerTune("Kantara");
				customer.setCname("tendulkar");
				flag = true;

			} else {
				System.out.println("Record not available...");
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object is modified....");
				System.out.println("Object is modified for :: " + customer.getVersionCount() + " times");

			} else {
				transaction.rollback();
				System.out.println("object is not modified...");
			}
			HibernateUtil.closeSession(session);
		}


	}
}


/*

Versioning or ObjectVersioning
==============================
> It keeps track of how many times object/record is loaded and modified using hibernate.
> It generates a special column of type numeric to keep track of the modifications on Entity class.
> This special property/col initial value is 0 and it is incremented by 1 for every modification.

 */