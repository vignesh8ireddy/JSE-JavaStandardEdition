package JDBCStandaloneApplication.main;

import JDBCStandaloneApplication.controller.IStudentController;
import JDBCStandaloneApplication.dto.Student;
import JDBCStandaloneApplication.factory.StudentControllerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestApp {

    public static void main(String[] args) {

        IStudentController studentController = null;
        String status = null, name = null, city = null, email = null, country = null;
        Integer id = null;
        Student studentRecord = null;

        try {
            while (true) {

                BufferedReader brObj = new BufferedReader(new InputStreamReader(System.in));

                System.out.println("1. CREATE");
                System.out.println("2. READ");
                System.out.println("3. UPDATE");
                System.out.println("4. DELETE");
                System.out.println("5. EXIT");
                System.out.print("ENTER NUMBERS FROM {1,2,3,4,5} TO USE THE APPLICATION:: ");
                Integer option = Integer.parseInt(brObj.readLine());

                studentController = StudentControllerFactory.getStudentController();

                switch (option) {
                    case 1:
                        System.out.print("ENTER THE NAME OF THE STUDENT:: ");
                        name = brObj.readLine();

                        System.out.print("ENTER THE STUDENT'S EMAIL:: ");
                        email = brObj.readLine();

                        System.out.print("ENTER THE STUDENT'S CITY:: ");
                        city = brObj.readLine();

                        System.out.print("ENTER THE STUDENT'S COUNTRY:: ");
                        country = brObj.readLine();

                        Student student = new Student();
                        student.setName(name);
                        student.setCountry(country);
                        student.setCity(city);
                        student.setEmail(email);

                        status = studentController.save(student);
                        if (status.equalsIgnoreCase("success")) {
                            System.out.println("RECORD INSERTED SUCCESSFULLY.");
                        } else if (status.equalsIgnoreCase("failure")) {
                            System.out.println("FAILED TO INSERT THE RECORD.");
                        } else {
                            System.out.println("UNEXPECTED ERROR HAS OCCURRED.");
                        }
                        break;
                    case 2:
                        System.out.print("ENTER STUDENT'S ID:: ");
                        id = Integer.parseInt(brObj.readLine());
                        studentRecord = studentController.findById(id);
                        if (studentRecord != null)
                            System.out.println(studentRecord);
                        else
                            System.out.println("NO RECORD IS AVAILABLE WITH THE ID::" + id);
                        break;

                    case 3:
                        System.out.print("Enter the id of the record to be updated:: ");
                        id = Integer.parseInt(brObj.readLine());
                        studentRecord = studentController.findById(id);
                        if (studentRecord != null) {

                            Student newStudent = new Student();
                            newStudent.setSid(id);

                            System.out.print("StudentName ::[OLD NAME IS :: " + studentRecord.getName() + "]:  ");
                            String newName = brObj.readLine();
                            if (newName == null || newName.equals("")) {
                                newStudent.setName(studentRecord.getName());
                            } else {
                                newStudent.setName(newName);
                            }

                            System.out.print("StudentEmail ::[OLD EMAIL IS :: " + studentRecord.getEmail() + "]: ");
                            String newEmail = brObj.readLine();
                            if (newEmail == null || newEmail.equals("")) {
                                newStudent.setEmail(studentRecord.getEmail());
                            } else {
                                newStudent.setEmail(newEmail);
                            }

                            System.out.print("StudentCity ::[OLD CITY IS :: " + studentRecord.getCity() + "]:  ");
                            String newCity = brObj.readLine();
                            if (newCity == null || newCity.equals("")) {
                                newStudent.setCity(studentRecord.getCity());
                            } else {
                                newStudent.setCity(newCity);
                            }

                            System.out.print("StudentCountry ::[OLD COUNTRY IS :: " + studentRecord.getCountry() + "]:  ");
                            String newCountry = brObj.readLine();
                            if (newCountry == null || newCountry.equals("")) {
                                newStudent.setCountry(studentRecord.getCountry());
                            } else {
                                newStudent.setCountry(newCountry);
                            }

                            status = studentController.updateById(newStudent);
                            if (status.equalsIgnoreCase("success")) {
                                System.out.println("RECORD UPDATED SUCCESSFULLY.");
                            } else if (status.equalsIgnoreCase("failure")) {
                                System.out.println("FAILED TO UPDATE THE RECORD.");
                            } else {
                                System.out.println("UNEXPECTED ERROR HAS OCCURRED.");
                            }

                        } else
                            System.out.println("NO RECORD AVAILABLE WITH THE ID::" + id);
                        break;

                    case 4:
                        System.out.print("ENTER THE ID:: ");
                        id = Integer.parseInt(brObj.readLine());
                        status = studentController.deleteById(id);
                        if (status.equalsIgnoreCase("success")) {
                            System.out.println("RECORD DELETED SUCCESSFULLY.");
                        } else if (status.equalsIgnoreCase("failure")) {
                            System.out.println("FAILED TO DELETE THE RECORD.");
                        } else {
                            System.out.println("NO RECORD AVAILABLE WITH THE ID:: "+id);
                        }
                        break;
                    case 5:
                        System.out.println("THANK YOU FOR USING MY APPLICATION!");
                        System.exit(0);

                    default:
                        System.out.println("PLEASE ENTER NUMBERS ONLY FROM {1,2,3,4,5}.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
