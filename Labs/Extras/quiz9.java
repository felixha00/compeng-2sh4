public class Course {
    private String name;
    private int code;
    private String instructor;
    private int semestersOffered;
    private int capacity;

    public void enrollAsStudent(Student enrolledStudent) {
        
    }

    public void dropAsStudent(Student droppedStudent){

    }

    public void setName(String name){
        this.name = name; 
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setSemesterOffered(int sem){
        this.semestersOffered = sem;
    }

    public void setCapacity(int cap){
        this.capacity = cap;
    }

    public void setStudents(Student[] stuList){
    }

    public Course (String name, int code, String instructor, int capacity){
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.capacity = capacity;
    }
    public Course (String name, int code, String instructor, int capacity, Student[] students){
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        this.capacity = capacity;
    }
}


public class Student {
    private String name;
    private int dob;
    private int year;
    private Course[] courses; 

    public void enrollToACourse(Course myCourse) {

    }
    public void dropACourse(Course myCourse){

    }
    public void setName(String name){
        this.name = name;
    }

    public void setDOB(int dob){
        this.dob = dob;
    }

    public void setYear (int year){
        this.year = year;
    }

    public void setCourses (Courses[] courseList){
        this.courses = new Course[2];
    }
}