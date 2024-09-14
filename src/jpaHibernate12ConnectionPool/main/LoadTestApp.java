package jpaHibernate12ConnectionPool.main;

import jpaHibernate12ConnectionPool.util.HibernateUtil;
import jpaHibernate12ConnectionPool.model.InsurancePolicy;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class LoadTestApp {

	public static void main(String[] args) {

		Session session = null;
		InsurancePolicy policy = null;

		session = HibernateUtil.getSession();

		try {
			policy = session.get(InsurancePolicy.class, 3L);
			if (policy != null) {
				System.out.println("Record found and displayed....");
				System.out.println(policy);
			} else {
				System.out.println("Record not found...");
			}

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
		}

	}

}


/*

Connection pooling

> SessionFactory object holds jdbc connection pool having set of ready made jdbc
connection objects and uses them in the creation of hibernate session objects.
> By default hibernate uses built in jdbc connection pool which is not suitable
for production environment because of performance issue.
> To control hibernate build in jdbc connection pool we write the following
property in hibernate.cfg.xml
	<property name="hibernate.connection.pool_size">25</property>

> Which jdbc connection pool is best with hibernate integration?
	standalone mode -> Don't use hibernate built in jdbc connection pool use
					   Third party supplied jdbc connection pool like hikaricp(best in market),
					   proxool, viboor, agroal,c3po.....
	webapplication mode-> Don't use 3rd party supplied only, use underlying server provided
						  connection pool from servers like weblogic,tomcat,wildfly,....

Configuration of hibernate.cfg.xml file for hikaricp production
===============================================================
<!-- Hikari cp configuration -->
<property name="hibernate.connection.provider_class">org.hibernate.hikaricp.internal.HikariCPConnectionProvider</property>

<!-- Maximum waiting time for a connection from the pool (20sec)-->
<property name="hibernate.hikari.connectionTimeout">20000</property>

<!-- Minimum number of ideal connections in the pool(10 objects) -->
<property name="hibernate.hikari.minimumIdle">10</property>

<!-- Maximum number of actual connection in the pool(20objects0 -->
<property name="hibernate.hikari.maximumPoolSize">20</property>

<!-- Maximum time that a connection is allowed to sit ideal in the pool(300secs) -->
<property name="hibernate.hikari.idleTimeout">30000</property>


Note: DataSource(I)---------> jars provider should implement and give the class.

> Why are we not configuring the Datasource class directly in hibernate? why are
  configuring connection provider class name?
	Answer. hibernate f/w is designed to pickup the datasource class based on the connection provider
	that we have configured. By configuring in this style, we can restrict datasource and jdbc
	connection pool associated with hibernate.

hibernate will give support only for few third party vendors like
a. hikaricp(best) b. c3po c.proxool d. viboor e.agroal



https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.3.26.Final/hibernate-release-5.3.26.Final.zip/download
link to download hibernate orm release as zip
 */