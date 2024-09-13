package jpaHibernate09Caching.main;

import jpaHibernate09Caching.model.InsurancePolicy;
import jpaHibernate09Caching.util.HibernateUtil;
import org.hibernate.Session;

public class L1CacheTest1 {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();

		try {
			policy = session.get(InsurancePolicy.class, 1L);// gets from DB and put it in L1-cache
			System.out.println("1:: " + policy);

			policy = session.get(InsurancePolicy.class, 1L);// gets from L1cache
			System.out.println("2:: " + policy);
			System.out.println("=====================");

			session.evict(policy);// remove policy object from L1 cache

			policy = session.get(InsurancePolicy.class, 1L);// gets from DB and put it in L1-cache
			System.out.println("3:: " + policy);

			policy = session.get(InsurancePolicy.class, 1L);// gets from L1 cache
			System.out.println("4:: " + policy);
			System.out.println("========================");

			session.clear(); // remove all objects from L1-cache

			policy = session.get(InsurancePolicy.class, 1L);// gets from DB and put it in L1-cache
			System.out.println("5:: " + policy);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
		}
	}
}


/*

Caching
=======

> It is a temporary memory that holds the data for temporary period of time.
> Cache at client side will hold server data and uses it across the multiple
same requests to reduce the network trip b/w client and server.
> Hibernate supports 2 levels of Cache
a. First Level Cache(L1-cache/session cache/default cache)
b. Second Level Cache(L2-cache/configurable cache)
eg: Stockmarket trading,live game score,weather report,......

Note: session.save(obj),session.saveOrUpdate(obj),session.delete(obj) methods keep the
object in L1cache until commit() is called.

session.get() will get the object and keep it in L-1 cache and same object will be
used across multiple session.get() method calls with same entity object id.

L1 Caching
a. evict(Object obj) => it will remove particular object from L1-cache
b. clear() -> it will remove all object present in L1-cache.
c. In L1-cache, duplicate objects won't be available.

2nd level cache
===============
This caching is associated with "SessionFactory", so we call it as "Global Cache".
Application will start to search for entity object in the following order
a. L1 cache of current session(if not there)
b. L2 cache of SessionFactory object(if not there)
c. Collect from db and keep in L2 cache and L1 cache then give it to application.

It is a configurable cache and we can enable or disable it.
hibernate supports L2 cache through "EHCache"

To configure EHCache in our hibernate projects we use
=====================================================
1. Add EHCache jars to the project
2. configure ehcache.xml as shown below

	<ehcache>
		<diskStore path="java.io.tmpdir"/>
		<defaultCache
			maxElementsInMemory="100"
			eternal="false"
			timeToIdleSeconds="10"
			timeToLiveSeconds="30"
			overflowToDisk="true"
		/>
	</ehcache>

	Also make changes in hibernate.cfg.xml file as shown below
	<!-- Configuring EH cache... -->
	<property name="hibernate.cache.use_second_level_cache">true</property>
	<property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
	<property name="net.sf.ehcache.configurationResourceName">ehcache.xml</property>

3. In the model class inform hibernate to use Caching strategy for Read purpose.
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)//It specifies caching Strategy
public class InsurancePolicy implements Serializable{}

 */