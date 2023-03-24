import General.model.Group;
import General.model.Student;
import General.service.impl.GroupServiceImpl;
import General.service.impl.StudentServiceImpl;

public class Main {
    public static void main(String[] args) {

        Group group = new Group();
        Student student = new Student();
        StudentServiceImpl studentService = new StudentServiceImpl();
        GroupServiceImpl groupService = new GroupServiceImpl();

    }
}