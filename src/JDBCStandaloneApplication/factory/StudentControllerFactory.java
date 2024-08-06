package JDBCStandaloneApplication.factory;

import JDBCStandaloneApplication.controller.IStudentController;
import JDBCStandaloneApplication.controller.StudentControllerImpl;

public class StudentControllerFactory {

    private static IStudentController studentController = null;

    private StudentControllerFactory() {

    }

    public static IStudentController getStudentController() {

        if (studentController == null) {
            studentController = new StudentControllerImpl();
        }

        return studentController;

    }


}
