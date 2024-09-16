package jpaHibernate19StoredProcedure.dao;

import jpaHibernate19StoredProcedure.model.InsurancePolicy;

import java.util.List;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPoliciesByTenure(int start, int end);
	public String[] getPolicyById(int id);
}
