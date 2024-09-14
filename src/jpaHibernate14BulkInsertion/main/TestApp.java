package jpaHibernate14BulkInsertion.main;


import jpaHibernate14BulkInsertion.dao.InsurancePolicyDao;
import jpaHibernate14BulkInsertion.dao.InsurancePolicyDaoImpl;
import jpaHibernate14BulkInsertion.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {

		InsurancePolicyDao dao = null;
		dao = new InsurancePolicyDaoImpl();
		String result = dao.transferPremiumPolicies(25);
		System.out.println(result);
		HibernateUtil.closeSessionFactory();
	}

}


/*

It is not possible to insert only one record to the database directly using insert query,
because linking generators with HQL insert query is not possible.
So, we have session.save() method to insert a record.

We can use HQL insert query to insert bulk records into one dbtable by selecting them
from another dbtable
 */