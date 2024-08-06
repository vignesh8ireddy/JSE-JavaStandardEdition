package JDBCStandaloneApplication.dao;

import JDBCStandaloneApplication.dto.Student;
import JDBCStandaloneApplication.jutil.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {

    Connection conObj = null;

    @Override
    public String save(Student student) {

        String sqlInsertQuery = "INSERT INTO student001(`name`,`email`,`city`,`country`) VALUES(?,?,?,?)";
        PreparedStatement pstmt = null;
        String status = null;
        try {
            conObj = JDBCUtil.getConnection();
            if (conObj != null)
                pstmt = conObj.prepareStatement(sqlInsertQuery);
            if (pstmt != null) {
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getEmail());
                pstmt.setString(3, student.getCity());
                pstmt.setString(4, student.getCountry());
            }
            if (pstmt != null) {
                int rowAffected = pstmt.executeUpdate();
                if (rowAffected == 1) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            status = "failure";
        }
        return status;
    }

    @Override
    public Student findById(Integer sid) {

        String sqlSelectQuery = "SELECT sid,name,email,city,country FROM student001 WHERE sid=?";
        PreparedStatement pstmt = null;
        Student student = null;
        try {
            conObj = JDBCUtil.getConnection();
            if (conObj != null)
                pstmt = conObj.prepareStatement(sqlSelectQuery);
            if (pstmt != null) {
                pstmt.setInt(1, sid);
            }
            if (pstmt != null) {
                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) {
                    // copy the resultSet data to StudentDTO and transfer to the view
                    student = new Student();

                    student.setSid(resultSet.getInt(1));
                    student.setName(resultSet.getString(2));
                    student.setEmail(resultSet.getString(3));
                    student.setCity(resultSet.getString(4));
                    student.setCountry(resultSet.getString(5));
                }
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String updateById(Student student) {
        String sqlUpdateQuery = "UPDATE student001 SET name=?,email=?,city=?,country=? WHERE sid = ?";
        PreparedStatement pstmt = null;
        String status = null;
        try {
            conObj = JDBCUtil.getConnection();
            if (conObj != null)
                pstmt = conObj.prepareStatement(sqlUpdateQuery);
            if (pstmt != null) {
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getEmail());
                pstmt.setString(3, student.getCity());
                pstmt.setString(4, student.getCountry());
                pstmt.setInt(5, student.getSid());
            }
            if (pstmt != null) {
                int rowAffected = pstmt.executeUpdate();
                if (rowAffected == 1) {
                    status = "success";
                } else {
                    status = "failure";
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            status = "failure";
        }
        return status;
    }

    @Override
    public String deleteById(Integer sid) {

        String sqlDeleteQuery = "DELETE FROM student001 WHERE sid = ?";
        PreparedStatement pstmt = null;
        String status = null;
        try {
            Student student = findById(sid);
            if (student != null) {

                conObj = JDBCUtil.getConnection();
                if (conObj != null)
                    pstmt = conObj.prepareStatement(sqlDeleteQuery);
                if (pstmt != null)
                    pstmt.setInt(1, sid);

                if (pstmt != null) {
                    int rowAffected = pstmt.executeUpdate();
                    if (rowAffected == 1)
                        status = "success";
                }
            } else {
                status = "not available";
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            status = "failure";
        }
        return status;
    }

}
