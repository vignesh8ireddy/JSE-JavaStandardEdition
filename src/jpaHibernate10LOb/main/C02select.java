package jpaHibernate10LOb.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import jpaHibernate10LOb.model.JobSeeker;
import jpaHibernate10LOb.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class C02select {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		int id = 1;
		JobSeeker seeker = null;
		FileOutputStream fos = null;
		FileWriter out =null;
		
		try {
			if (session != null)
				seeker = session.get(JobSeeker.class, id);

			if (seeker != null) {
				
				fos = new FileOutputStream("kyle_photo.jpg");
				fos.write(seeker.getPhoto());
				
				out = new FileWriter("new_kyle2.txt");
				out.write(seeker.getResume());
				
				fos.flush();
				out.flush();
				
				System.out.println("LOB's are retreived");
				System.out.println(seeker);
				
			} else {
				System.out.println("Employee record not found for the given id :: " + id);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
