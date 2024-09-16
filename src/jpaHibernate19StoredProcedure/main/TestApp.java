package jpaHibernate19StoredProcedure.main;

import jpaHibernate19StoredProcedure.dao.InsurancePolicyDao;
import jpaHibernate19StoredProcedure.dao.InsurancePolicyDaoImpl;
import jpaHibernate19StoredProcedure.model.InsurancePolicy;
import jpaHibernate19StoredProcedure.util.HibernateUtil;

import java.util.List;

public class TestApp {

	public static void main(String[] args) {

		InsurancePolicyDao dao = null;
		dao = new InsurancePolicyDaoImpl();
		
		List<InsurancePolicy> list = dao.getPoliciesByTenure(25, 30);
		System.out.println(list.size());
		list.forEach(System.out::println);
		
		System.out.println();
		
		int id = 100;
		String[] result = dao.getPolicyById(id);
		if(result[0]!=null)
			System.out.println(result[0]+"-----"+result[1]+"---"+result[2]);
		else
			System.out.println("Record not found for the id :: "+id);
		HibernateUtil.closeSessionFactory();
	}
}
