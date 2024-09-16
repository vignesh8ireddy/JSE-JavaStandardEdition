package jpaHibernate17CriterionAPI.main;

import java.util.List;

import jpaHibernate17CriterionAPI.model.Project;
import jpaHibernate17CriterionAPI.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.internal.build.AllowSysOut;


public class TestApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		 try {
			 Criteria criteria = session.createCriteria(Project.class);
			 List<Project> list = criteria.list();
			 list.forEach(System.out::println);

		 } catch (Exception e) {

		 } finally {
			 HibernateUtil.closeSession(session);
		 	 HibernateUtil.closeSessionFactory();
		 }


		 try {

			 Criteria criteria = session.createCriteria(Project.class);

			 //projections
			 PropertyProjection p1 = Projections.property("teamSize");
			 PropertyProjection p2 = Projections.property("location");
			 PropertyProjection p3 = Projections.property("projName");

			 ProjectionList plist = Projections.projectionList();
			 plist.add(p3);
			 plist.add(p2);
			 plist.add(p1);

			 criteria.setProjection(plist);

			 //where clause
			 Criterion cond1 = Restrictions.ge("teamSize", 10);
			 Criterion cond2 = Restrictions.le("teamSize", 20);

			 criteria.add(cond1);
			 criteria.add(cond2);

			 //orderby clause
			 Order order1 = Order.asc("location");
			 Order order2 = Order.desc("projName");
			 criteria.addOrder(order1); criteria.addOrder(order2);

			 List<Object[]> list = criteria.list();
			 System.out.println("ProjectName\tLocation\tTeamsize");
			 list.forEach(row->{
			 	for (Object obj : row) {
					 System.out.print(obj+ "\t");
				}
				System.out.println();
			 });

		 } catch (Exception e) {

		 } finally { HibernateUtil.closeSession(session);
		 HibernateUtil.closeSessionFactory(); }


		
		//pagination code
		try {
			Criteria criteria = session.createCriteria(Project.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			List<Project> list = criteria.list();
			list.forEach(System.out::println);

		} catch (Exception e) {

		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}

/*

Criterion Api
-------------

Single Row Operations => hibernate persistence methods
bulkoperations => we use HQL(query written using classname and properties) to
write queries.

=> In case of Criterion api, we can perform both singlerow and bulkoperations
without using any queries just like java statements.
=> Criterion api will generate SQL queries based on the given entity classnames and
properties name.
=> It doesnot support non-select operation,it supports only select operation.
=> Using Criteria object we can add 3 objects
	a. Criterion objects(for where clause condition)
	b. Projection objects(for scalar select operation)
	c. Order objects( for orderBy operations)

There are 2 modes of writing Criterion api
a. HB QBC(Query by Criteria)====> specific to hibernate only
b. JPA QBC ===> common to all ORM framework

 */