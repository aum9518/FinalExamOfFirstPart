import General.Enum.Gender;
import General.model.Group;
import General.model.Student;
import General.service.impl.GroupServiceImpl;
import General.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {

        Group group = new Group(1,"Java","Beckand",2020);
        Group group1 = new Group(2,"Ali","Beckand",2021);
        Group group2 = new Group(3,"Bek","Beckand",2019);
        Group group3 = new Group(4,"Mur","Beckand",2018);
        Group group4 = new Group(5,"Nur","Beckand",2016);
        Student student = new Student(1,"Manas Abdugani uulu",27, Gender.MALE);
        Student student1 = new Student(2,"Aigul",27, Gender.FEMALE);
        Student student2 = new Student(3,"Bakyt",27, Gender.MALE);
        Student student3 = new Student(4,"Manas Abdugani uulu",27, Gender.MALE);
        StudentServiceImpl studentService = new StudentServiceImpl();
        GroupServiceImpl groupService = new GroupServiceImpl();
        System.out.println(groupService.addNewGroup(group));
        System.out.println(groupService.addNewGroup(group1));
        System.out.println(groupService.addNewGroup(group2));
        System.out.println(groupService.addNewGroup(group3));
        System.out.println(groupService.addNewGroup(group4));
        System.out.println(groupService.getGroupById(1));
        groupService.updateGroupName(1,"Java 9");
        System.out.println(groupService.getGroupById(1));
        System.out.println(groupService.filterByYear(2019, "desc"));
        System.out.println("Sort group by year: "+groupService.sortGroupByYear("desc"));
        groupService.deleteGroupById(2);
        System.out.println(studentService.addStudent(student));
        System.out.println(studentService.addStudent(student1));
        System.out.println(studentService.addStudent(student2));
        System.out.println(studentService.addStudent(student3));
        System.out.println(studentService.getStudentById(1));
        System.out.println(studentService.updateStudentFullName(1, "Manas"));
        System.out.println(studentService.filterByGender());
        studentService.deleteStudentById(1);
        System.out.println(studentService.getAllStudents());
    }
}