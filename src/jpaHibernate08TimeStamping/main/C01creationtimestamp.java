package jpaHibernate08TimeStamping.main;

import jpaHibernate08TimeStamping.model.BankAccount;
import jpaHibernate08TimeStamping.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C01creationtimestamp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Long idValue = null;
		boolean flag = false;

		session = HibernateUtil.getSession();
		BankAccount account = new BankAccount();
		account.setHolderName("sachin");
		account.setBalance(5555.5);
		account.setType("savings");
		try {
			transaction = session.beginTransaction();
			idValue = (Long) session.save(account);
			flag = true;
			System.out.println("Account no generated is :: " + idValue);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object is saved...");
				System.out.println("Account is opened at :: " + account.getOpeningDate());
				System.out.println("Account is lastly modified at :: " + account.getLastUpdated());
				System.out.println("Account version is:: " + account.getVersion());
			} else {
				transaction.rollback();
				System.out.println("Object is not saved...");
			}
			HibernateUtil.closeSession(session);
		}
	}

}


/*

TimeStamping
=============

> It allows us to keep track of Object is saved(record inserted) and object is lastly updated.
	eg: keeping track of when the bank account opened and lastly modified
> To do this we use annotations @CreationTimeStamp and @UpdateTimeStamp

 */