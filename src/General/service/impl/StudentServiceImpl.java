package General.service.impl;

import General.Enum.Gender;
import General.db.Database;
import General.model.Group;
import General.model.Student;
import General.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    Database database = new Database(new ArrayList<>(),new ArrayList<>());
    @Override
    public String addStudent(Student student) {

            database.getStudents().add(student);

        return "Successfully added";
    }

    @Override
    public Student getStudentById(int id) {
        for (Student s:database.getStudents()) {
            if (s.getId()==id){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {

        return database.getStudents();
    }

    @Override
    public String updateStudentFullName(int id, String fullName) {
        for (Student s:database.getStudents()) {
            if (s.getId()==id){
                s.setFullName(fullName);
                return "Successfully updated";
            }
        }
        return null;
    }

    @Override
    public List<Student> filterByGender() {
      /*  for (Student s:database.getStudents()) {
            *//*if (s.getGender().equals(Gender.MALE)){
                List<Student>boys = new ArrayList<>();
                boys.add(s);
               return boys;
            }*//*
            if (s.getGender().equals(Gender.FEMALE)){
                List<Student>girls = new ArrayList<>();
                girls.add(s);
                return girls;
            }
        }*/
        System.out.println("Boys: "+database.getStudents().stream().filter(x -> x.getGender().equals(Gender.MALE)).collect(Collectors.toList()));
        System.out.println("Girls: "+database.getStudents().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).collect(Collectors.toList()));
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        for (int i = 0; i < database.getStudents().size(); i++) {
            if (database.getStudents().get(i).getId()==id){
                database.getStudents().remove(database.getStudents().get(i));
        }
        }

    }
}
