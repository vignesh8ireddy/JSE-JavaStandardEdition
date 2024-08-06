package JDBCStandaloneApplication.controller;

import JDBCStandaloneApplication.dto.Student;
import JDBCStandaloneApplication.factory.StudentServiceFactory;
import JDBCStandaloneApplication.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

    IStudentService studentService;

    @Override
    public String save(Student student) {
        studentService = StudentServiceFactory.getStudentService();
        return studentService.save(student);
    }

    @Override
    public Student findById(Integer sid) {
        studentService = StudentServiceFactory.getStudentService();
        return studentService.findById(sid);
    }

    @Override
    public String updateById(Student student) {
        studentService = StudentServiceFactory.getStudentService();
        return studentService.updateById(student);
    }

    @Override
    public String deleteById(Integer sid) {
        studentService = StudentServiceFactory.getStudentService();
        return studentService.deleteById(sid);
    }

}
