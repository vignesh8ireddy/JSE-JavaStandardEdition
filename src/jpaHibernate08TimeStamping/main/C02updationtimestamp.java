package jpaHibernate08TimeStamping.main;

import jpaHibernate08TimeStamping.model.BankAccount;
import jpaHibernate08TimeStamping.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C02updationtimestamp {

	public static void main(String[] args) {

		Session session = null;
		BankAccount account = null;
		Transaction transaction = null;
		boolean flag = false;

		session = HibernateUtil.getSession();

		try {
			transaction = session.beginTransaction();

			long id = 1L;
			account = session.get(BankAccount.class, id);
			if (account != null) {
				account.setBalance(account.getBalance() + 10000);
				flag = true;
			} else {
				System.out.println("Record not available for modification...");
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;

		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
				System.out.println("Account opened   on   :: " + account.getOpeningDate());
				System.out.println("Account modified on   :: " + account.getLastUpdated());
				System.out.println("No of modification is :: " + account.getVersion());

			} else {
				transaction.rollback();
			}
			HibernateUtil.closeSession(session);
		}

	}

}
