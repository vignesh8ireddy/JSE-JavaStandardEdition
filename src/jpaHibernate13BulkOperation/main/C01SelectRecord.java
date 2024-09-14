package jpaHibernate13BulkOperation.main;

import java.util.List;

import jpaHibernate13BulkOperation.model.Employee;
import jpaHibernate13BulkOperation.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class C01SelectRecord {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		//using getResultList() to retrive the records
		try {
			Query<Employee> query = session.createQuery("FROM jpaHibernate13BulkOperation.model.Employee WHERE eno>=:id1 AND eno<=:id2");
			query.setParameter("id1", 1);
			query.setParameter("id2", 10);
			List<Employee> empRecords = query.getResultList();
			empRecords.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory();
		}

		//using list() to retrive the records
		/*try {
			Query<Employee> query = session.createQuery("FROM jpaHibernate13BulkOperation.model.Employee");
			List<Employee> employees = query.list();
			employees.forEach(employee -> System.out.println(employee));
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory();
		}*/
		
		/* using iterate() to retrive the records */
		/*try {
			Query query = session.createQuery("FROM jpaHibernate13BulkOperation.model.Employee");
			Iterator<Employee> itr = query.iterate();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}*/
	}

}


/*

BulkOperation
=============

> To select or manipulate one or more record/object having our choice criterial value we
need to go for "Bulk operation".

a. HQL.
b. Native SQL.
c. Criterian API.

HQL
====
1. HQL stands for Hibernate Query Language.
2. It uses Objects based Query Language(these queries will be written based on the
	entity class names and properties name)
3. Hibernate dialect internally converts HQL queries to DB specific SQL Queries.
4. HQL queries are DBIndependent and they supports portability.
5. HQL supports both select and non-select operation
6. HQL can also be used to perform SingleRowOperation(SRO) and also for bulk operation
	having our choice conditions criteria.
7. HQL supports positional params(?)(supported only in older versions) and also it
	supports named params(=:name)
8. HQL keywords are not case sensitive, but entity class names and properties names
	are case sensitive.
9. HQL supports relational operators, conditional statements, joins,aggregate functions, projections,....

eg:
SQL> SELECT * FROM EMP WHERE EMPNO>=? AND EMPNO<=?
HQL> FROM in.ineuron.entity.Employee WHERE eno>=? AND eno<=?(positional param)
HQL> FROM in.ineuron.entity.Employee WHERE eno=:firstNum AND eno=:secondNum(named param)

SQL> DELETE FROM EMP WHERE JOB=?
HQL> DELETE FROM in.ineuron.entity.Employee WHERE job=?
HQL> DELETE FROM in.ineuron.entity.Employee WHERE job=:desg

Note: if we are selecting all columns/properties in the HQL Select query then
placing select keyword is optional.

HQL select Queries
a. Entity Queries(Getting all properties values of the record)
	eg: FROM in.ineuron.entity.Employee(with or without condition)
b. Scalar Queries(Getting specific column or specific multiple column values)
	eg: SELECT eno,ename,eaddr FROM in.ineuron.entity.Employee (with or without condition)
		SELECT eno From in.ineuron.entity.Employee(with or without condition)
		SELECT count(*) From in.ineuron.entity.Employee

Example to get All the records from the DBTable using hibernate
===============================================================

Query<Employee> query = session.createQuery("FROM in.ineuron.Model.Employee");
List<Employee> employees = query.list();
employees.forEach(employee -> System.out.println(employee));

Note:
If we use xml approach setter and getter methods are mandatory,
but if we use Annotations for mapping setter and getter methods are not required,
hibernate internally uses reflection api and it binds the value from ResultSet
to private properties of the Model.

Note:
In plain jdbc converting ResultSet object to DTO object is a manual process, where
as in orm framework like hibernate, spring jdbc, spring orm and spring datajpa same
happens internally using "rowmapper"concept.

list() or getResultList()
========================
1. It internally uses eager loading for bulk operations.
2. It returns the collection directly.
3. Generates only one query to get all the records.
4. suitable for good performance.
5. It won't generate proxy object.
6. It is not deprecated and it is the industry standard approach.

iterate()
========
1. It internally uses lazy loading for bulk operation
2. It returns the iterator pointing to collection object.
3. Generates n+1 query to get all the records.
4. Not suitable, it degrades the performance.
5. It generates Proxy object.
6. It is deprecated becoz of performance issue.

Bulk operation for retrieving the record
----------------------------------------
a. All columns ========> List<EntityType>
b. multiple columns ====> List<Object[]>
c. only one column ====> List<datatype of property>

Note: To avoid null checking in our application, we can use JDK8 supplied api called "Optional".

Employee employee = query.uniqueResult();
if (employee != null)
System.out.println(employee);
else
System.out.println("Record not found for the given id ::"+id);
Optional<Employee> optional = query.uniqueResultOptional();
if (optional.isPresent()) {
	Employee employee = optional.get();
	System.out.println(employee);
}
else{
	System.out.println("Record not found for the given id :: " + id);
}

Note: we should use get()/load() if we are getting record based on primary key
value, we can use uniqueResult()/uniqueResultOptional() if we are getting
record based on non-primary key value.

 */