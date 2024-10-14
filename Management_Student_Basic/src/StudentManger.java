import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManger {
    private List<Student> students = new ArrayList<>();

    //Them sinh vien moi
    public void addStudent(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student Id: ");
        String id = input.nextLine();
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.print("Enter student age: ");
        int age = input.nextInt();

        Student student = new Student(id,name,age);
        students.add(student);
        System.out.print("Add student successfully!");
    }
    //Hiển thị danh sách
    public void displayStudents(){
        if(students.isEmpty()){
            System.out.println("No students found");
        }else{
            for(Student student : students){
                System.out.println(student);
            }
        }
    }
    //Tìm kiểm tên sinh viên theo ID
    public void findStudentID(String id){
        for(Student student : students){
            if(student.getId().equals(id)){
                System.out.print(student.getName());
                return;
            }
        }
    }
    //Xóa sinh viên theo ID
    public void removeStudent(String id){
        students.removeIf(student -> student.getId().equals(id));
        System.out.print("Remove student successfully!");
    }
    //Sửa thông tin sinh viên theo ID
    public void updateStudent(String id){
        for(Student student : students){
            if(student.getId().equals(id)){
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter student name: ");
                student.setName(sc.nextLine());
                System.out.print("Enter student age: ");
                student.setAge(sc.nextInt());
                System.out.print("Update student successfully!");
                return;
            }
        }
        System.out.print("No found student with ID");
    }
    public static void main(String[] args) {
        StudentManger studentManger = new StudentManger();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add student");
            System.out.println("2. Displays the lists of students");
            System.out.println("3. Tìm sinh viên theo ID");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("5. Sửa sinh viên theo ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    studentManger.addStudent();
                    break;
                    case 2:
                        studentManger.displayStudents();
                        break;
                        case 3:
                            System.out.print("Enter student ID: ");
                            String id = input.nextLine();
                            studentManger.findStudentID(id);
                            break;
                            case 4:
                                System.out.print("Enter student ID: ");
                                String removeId = input.nextLine();
                                studentManger.removeStudent(removeId);
                                break;
                                case 5:
                                    System.out.print("Input student ID to update: ");
                                    String updateId = input.nextLine();
                                    studentManger.updateStudent(updateId);

            }
        }while(choice != 0);
    }
}
