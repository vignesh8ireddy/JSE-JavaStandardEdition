package jpaHibernate13BulkOperation.main;

import jpaHibernate13BulkOperation.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class C02SelectRecord2 {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();

        //using getResultList() to retrive the records
        try {
/*            Query query = session.createQuery("SELECT ename,esalary FROM jpaHibernate13BulkOperation.model.Employee WHERE eno>=:id1 AND eno<=:id2");
            query.setParameter("id1", 1);
            query.setParameter("id2", 10);
            List<Object[]> list = query.getResultList();
            list.forEach(row->{
                for(Object obj:row)
                    System.out.println(obj);
                System.out.println();
            });*/


            Query query = session.createQuery("SELECT ename FROM jpaHibernate13BulkOperation.model.Employee WHERE eno>=:id1 AND eno<=:id2");
            query.setParameter("id1", 1);
            query.setParameter("id2", 10);
            List<String> list = query.getResultList();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session); HibernateUtil.closeSessionFactory();
        }

    }
}
