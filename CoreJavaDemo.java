public class CoreJavaDemo {

    public static void main(String[] args) {
       
        BCAStudent[] students = new BCAStudent[3];
       
        students[0] = new BCAStudent("Aashish", 101, 2);
        students[1] = new BCAStudent("Aarna", 102, 3);
        students[2] = new BCAStudent("Dev", 103, 1);

        System.out.println("--- Student Details ---");
        
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].getDetails());
        }

        System.out.println("\n--- Demonstrating Exception Handling ---");
      
        try {
            
            System.out.println("Attempting to access students[3]...");
            System.out.println(students[3].getDetails());
        } catch (ArrayIndexOutOfBoundsException e) {
            
            System.err.println("Exception caught!");
            System.err.println("Error: " + e.getMessage());
            System.err.println("You tried to access an element outside the array's size.");
        }

class Student {
    String name;
    int rollNo;
    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    
    public String getDetails() {
        return "Name: " + name + ", Roll No: " + rollNo;
    }
}

class BCAStudent extends Student {
    int semester;

    public BCAStudent(String name, int rollNo, int semester) {  
        super(name, rollNo);
        this.semester = semester;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Semester: " + semester;
    }
}
