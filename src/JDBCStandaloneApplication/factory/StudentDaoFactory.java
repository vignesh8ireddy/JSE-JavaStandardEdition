package JDBCStandaloneApplication.factory;

import JDBCStandaloneApplication.dao.StudentDaoImpl;
import JDBCStandaloneApplication.dao.IStudentDao;

public class StudentDaoFactory {

    private static IStudentDao studentDao = null;

    private StudentDaoFactory() {

    }

    public static IStudentDao getStudentDao() {
        if(studentDao == null) {
            studentDao = new StudentDaoImpl();
        }

        return studentDao;
    }

}
