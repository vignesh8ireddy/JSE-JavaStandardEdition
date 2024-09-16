package jpaHibernate15NamedHQLQuery.main;


import jpaHibernate15NamedHQLQuery.dao.InsurancePolicyDao;
import jpaHibernate15NamedHQLQuery.dao.InsurancePolicyDaoImpl;
import jpaHibernate15NamedHQLQuery.util.HibernateUtil;

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

NamedHQLQuery
-------------
> So far our HQL query is specific to one session object becoz query object is
  created having hard coded HQl query on session object.
> To make our HQL query accessible and executable through multiple session
  objects of Multiple DAO classes or client apps we need to go for "NamedHQL" query.
> We defined NamedHQLQuery in mapping file using <query> tag or in Entity class
  using "@NamedQuery" having logical name, we access and execute that HQL query in DAO class.
Code using Annotation
===================
@Entity
@NamedQuery(name = "HQL_INSERT_TRANSFER_POLICIES", query = "INSERT INTO
in.ineuron.model.PremiumInsurancePolicy(policyId,policyName,policyType,company,tenu
re)
SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure FROM
in.ineuron.model.InsurancePolicy as i WHERE i.tenure>=:tenure")

 */