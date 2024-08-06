package JDBCStandaloneApplication.controller;

import JDBCStandaloneApplication.dto.Student;

public interface IStudentController {

    String save(Student student);// CREATE a record

    Student findById(Integer sid);// READ a record

    String updateById(Student student);// UPDATE a record

    String deleteById(Integer sid);// DELETE a record

}
