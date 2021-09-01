/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Fetskof
 */
public class Course {

    private String title;
    private String stream;
    private String type;
    private Date startDate;
    private Date endDate;
    private ArrayList<Course> coursesList = new ArrayList<>();

    public Course(String title, String stream, String type,Date startDate,Date endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;

    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" + "\ntitle=" + title + "\nstream=" + stream + "\ntype=" + type + "\nstartDate=" + startDate + "\nendDate=" + endDate + '}'+"\n";
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {

        this.coursesList = coursesList;
    }

    public static ArrayList<Course> courseStaticList() throws Exception{
        Date startD1 = new SimpleDateFormat("dd/MM/yyyy").parse("15/02/2021");
        Date startD2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2022");
        Date startD3 = new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2021");
        Date endD1 = new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2021");
        Date endD2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2022");
        Date endD3 = new SimpleDateFormat("dd/MM/yyyy").parse("15/06/2021");
        Course c1 = new Course("CB13", "Java", "Part Time",startD1,endD1);
        Course c2 = new Course("CB12", "Python", "Full Time",startD2,endD2);
        Course c3 = new Course("CB14", "C#", "Part Time",startD3,endD3);
        ArrayList<Course> staticCourses = new ArrayList();
        staticCourses.add(c1);
        staticCourses.add(c2);
        staticCourses.add(c3);
        return staticCourses;
    }

    public void courseMain() throws Exception {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("type 1 to enter a course or use the default courses:\n"
                + "type 2 to see the courses:\n");
        String f = input.next();

        while (x == false) {
            switch (f) {
                case "1":
                    setCourseList();
                    x = true;
                    break;
                case "2":
                    printCourses(coursesList);
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter a course or use the default courses:\n"
                            + "Type 2 to see the courses:\n");
            }

        }

    }

    public StudentsPerCourse editSPC(StudentsPerCourse studentPerCourse, Student student) {// main method that makes the students per course
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 to enter the students per course:\n"
                + "Type 2 to see the students per course:\n");
        String f = input.nextLine();
        while (x == false) {
            switch (f) {
                case "1":
                    studentPerCourse = editStudentsPerCourse(studentPerCourse, student);
                    x = true;
                    break;
                case "2":
                    printStudentsPerCourse(studentPerCourse.getStudentPerCourseList());
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter the students per course:\n"
                            + "Type 2 to see the students per course:\n");
            }
        }
        return studentPerCourse;
    }

    public static void printCourses(ArrayList<Course> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void printCourseName() {
        for (Course course : getCoursesList()) {
            System.out.println("The name of the course is: " + course.getStream());
        }
    }

    public StudentsPerCourse editStudentsPerCourse(StudentsPerCourse studentsPerCourse, Student student) { //method that creates the HashMap list of students per course
        System.out.println("Type the course name you want to add the students in:");
        printCourseName();       
        Scanner input = new Scanner(System.in);
        String inputCourseName = input.nextLine();
        Course course = findCourse(inputCourseName);
        if (course == null) {
            System.out.println("The course does not exist...Please try again.");
            return studentsPerCourse;
        }
        ArrayList<Student> studentPCL = new ArrayList<Student>();
        studentPCL = createStudentsPerCourseList(student);
        studentsPerCourse.getStudentPerCourseList().put(course, studentPCL);//Hashmap that puts the list of student we created earlier in the course name we gave at the start of the method
        return studentsPerCourse;
    }

    private Course findCourse(String courseName) {
        for (Course course : getCoursesList()) {
            if (courseName.equals(course.getStream())) {
                return course;
            }
        }

        return null;
    }

    private ArrayList<Student> createStudentsPerCourseList(Student student) { //this method prints each student and asks if you want to add them in the course you typed
        Scanner input = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        for (Student students : student.getStudentsList()) {
            System.out.println("Do you want to add the "
                    + students + " in the Course "
                    + "?\n" + "Yes: 1    No: 2");
            String f = input.nextLine();
            if (f.equals("1")) {
                studentList.add(students);

            } else if (f.equals("2")) {

                System.out.println("You did not enter the student\n");
            } else {
                System.out.println("Wrong input!\n");

            }

        }

        return studentList; //returns the list of students for the course you typed
    }

    private ArrayList<Course> setCourseList() throws Exception { //this method asks to enter the user courses or the default courses and returns the course list of those courses
        Boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("to enter courses Type: 1\n"
                + "to use the default courses Type: 2");
        while (x == false) {
            String f = input.next();
            switch (f) {
                case "1":
                    coursesList = userCourseList(); // this method creates the user data and puts them in the course list of the object Course
                    x = true;
                    break;
                case "2":
                    coursesList = courseStaticList();// this method creates the static data and puts them in the course list of the object Course
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
        return coursesList;
    }

    public void printStudentsPerCourse(HashMap<Course, ArrayList<Student>> studentsPerCourseList) { // this method prints the students per course
        if (studentsPerCourseList == null) {
            System.out.println("the list is empty");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Type the name of the course you want to see the students from");
        printCourseName();
        String courseNameFromUser = input.nextLine();
        for (Map.Entry entry : studentsPerCourseList.entrySet()) {
            Course course = (Course) entry.getKey();
            ArrayList<Student> studentPCL = (ArrayList<Student>) entry.getValue();
            if (courseNameFromUser.equals(course.getStream())) {
                System.out.println("For the course: " + course.getStream() + " the student is: " + studentPCL);
            }
        }
    }

    public ArrayList<Course> userCourseList() throws Exception {// the user input data for the courses
        Boolean x = false;
        Scanner input = new Scanner(System.in);
        Course course = new Course();
        while (x == false) {
            System.out.println("Give the title of the course:");
            course.setTitle(input.next());
            System.out.println("Give the stream of the course:");
            course.setStream(input.next());
            System.out.println("Give the type of the course:");
            course.setType(input.next());
            System.out.println("Give the start date of the course in the format dd/MM/yyyy:");
            Date dateS = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
            course.setStartDate(dateS);
            System.out.println("Give the end date of the course in this format dd/MM/yyyy:");
            Date dateE = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
            course.setEndDate(dateE);
            getCoursesList().add(course);
            System.out.println("Do you want to add another course?\n"
                    + "Yes: 1   ,  No: 2 ");
            String f = input.next();
            switch ((f)) {
                case "1":
                    userCourseList();
                    break;
                case "2":
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
        return coursesList;
    }

    public ArrayList<Assignment> createAssignmentsPerCourseList(Assignment assign) { // method that asks if you want to add the assignment in the course you typed
        Scanner input = new Scanner(System.in);
        ArrayList<Assignment> assignmentsList = new ArrayList<>();
        for (Assignment assignment : assign.getAssignmentList()) {
            System.out.println("Do you want to add the "
                    + assignment + " in the Course?\n "
                    + "Yes: 1    No: 2");
            String f = input.nextLine();
            if (f.equals("1")) {
                assignmentsList.add(assignment);
            } else if (f.equals("2")) {
                System.out.println("You did not enter the assignment\n");
            } else {
                System.out.println("Wrong input!\n");
            }
        }
        return assignmentsList;
    }

    public AssignmentsPerCourse editAssignmentsPerCourse(AssignmentsPerCourse assignmentsPerCourse, Assignment assignment) {// method that creates the assignments per course
        System.out.println("Type the name of the course to enter the assignments");
        printCourseName();
        Scanner input = new Scanner(System.in);
        String inputCourseName = input.nextLine();
        Course course = findCourse(inputCourseName);//method that returns the name of the course you typed if it finds it in the course list
        if (course == null) {
            System.out.println("The course does not exist...Please try again.");
            return assignmentsPerCourse;
        }
        ArrayList<Assignment> assignmentPCL = new ArrayList<Assignment>();
        assignmentPCL = createAssignmentsPerCourseList(assignment);
        assignmentsPerCourse.getAssignmentsPerCourseList().put(course, assignmentPCL);
        return assignmentsPerCourse;
    }

    public void printAssignmentsPerCourse(HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList) {// method that takes the name of the course you typed and prints the assignment list of that course
        if (assignmentsPerCourseList == null) {
            System.out.println("the list is empty");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Type the name of the course you want to see the assignments from");
        printCourseName();
        String courseNameFromUser = input.nextLine();
        for (Map.Entry entry : assignmentsPerCourseList.entrySet()) {
            Course course = (Course) entry.getKey();//gets the key of the Hashmap (in this case it's the stream of the course)
            ArrayList<Assignment> assignmentPCL = (ArrayList<Assignment>) entry.getValue();
            if (courseNameFromUser.equals(course.getStream())) {//checks if the name the user gave is in the Key of the Hashmap (assignments per course)
                System.out.println("For the course: " + course.getStream() + " the assignment is: " + assignmentPCL);
            }
        }
    }

    public AssignmentsPerCourse editAPC(AssignmentsPerCourse assignmentsPerCourse, Assignment assignment) {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 to enter the assignments per course:\n"
                + "Type 2 to see the assignments per course:\n");
        String f = input.nextLine();
        while (x == false) {
            switch (f) {
                case "1":
                    assignmentsPerCourse = editAssignmentsPerCourse(assignmentsPerCourse, assignment);//method that creates the assignments per course
                    x = true;
                    break;
                case "2":
                    printAssignmentsPerCourse(assignmentsPerCourse.getAssignmentsPerCourseList());
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter the assignments per course:\n"
                            + "Type 2 to see the assignments per course:\n");
            }
        }
        return assignmentsPerCourse;
    }

    public TrainersPerCourse editTPC(TrainersPerCourse trainerPerCourseList, Trainer trainer) {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 to enter the trainers per course:\n"
                + "Type 2 to see the trainers per course:\n");
        String f = input.nextLine();
        while (x == false) {
            switch (f) {
                case "1":
                    trainerPerCourseList = editTrainersPerCourse(trainerPerCourseList, trainer);//creates the trainers per course
                    x = true;
                    break;
                case "2":
                    printTrainersPerCourse(trainerPerCourseList.getTrainerPerCourseList());
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter the trainers per course:\n"
                            + "Type 2 to see the trainers per course:\n");
            }
        }
        return trainerPerCourseList;
    }

    public TrainersPerCourse editTrainersPerCourse(TrainersPerCourse trainersPerCourseList, Trainer trainer) {
        System.out.println("Type the name of the course to enter the trainers");
        printCourseName();
        Scanner input = new Scanner(System.in);
        String inputCourseName = input.nextLine();
        Course course = findCourse(inputCourseName);
        if (course == null) {
            System.out.println("The course does not exist...Please try again.");
            return trainersPerCourseList;
        }
        ArrayList<Trainer> trainerPCL = new ArrayList<Trainer>();
        trainerPCL = createTrainersPerCourseList(trainer);
        trainersPerCourseList.getTrainerPerCourseList().put(course, trainerPCL);
        return trainersPerCourseList;
    }

    public ArrayList<Trainer> createTrainersPerCourseList(Trainer train) {
        Scanner input = new Scanner(System.in);
        ArrayList<Trainer> trainersList = new ArrayList<>();
        for (Trainer trainer : train.getTrainersList()) {
            System.out.println("Do you want to add the "
                    + trainer + " in the Course?\n "
                    + "Yes: 1    No: 2");
            String f = input.nextLine();
            if (f.equals("1")) {
                trainersList.add(trainer);
            } else if (f.equals("2")) {
                System.out.println("You did not enter the trainer\n");
            } else {
                System.out.println("Wrong input!\n");
            }
        }
        return trainersList;
    }

    public void printTrainersPerCourse(HashMap<Course, ArrayList<Trainer>> trainerPerCourseList) {
        if (trainerPerCourseList == null) {
            System.out.println("the list is empty");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Type the name of the course you want to see the trainers from");
        printCourseName();
        String courseNameFromUser = input.nextLine();
        for (Map.Entry entry : trainerPerCourseList.entrySet()) {
            Course course = (Course) entry.getKey();
            ArrayList<Trainer> trainerPCL = (ArrayList<Trainer>) entry.getValue();
            if (courseNameFromUser.equals(course.getStream())) {
                System.out.println("For the course: " + course.getStream() + " the trainer is: " + trainerPCL);
            }
        }
    }

    public void studentsInMoreThanOneCourse(HashMap<Course, ArrayList<Student>> studentPerCourseList, ArrayList<Student> studentList) {       //method that checks if a student is in more than 1 course  
        for (Student student : studentList) {// loop for all the students
               int counter=0;
            for (Course studentEntry : studentPerCourseList.keySet()) {// loop to get the value from the HashMap which in this case is a student list for a specific key course
                ArrayList<Student> studentForEachCourseList = studentPerCourseList.get(studentEntry);   //we show the reference the value list inside an ArrayList                          
                for (Student studentForEachCourse : studentForEachCourseList) {//loop for eache student in the ArrayList that has the reference of the students of a specific course
                    if (studentForEachCourse.equals(student)) {     //checks if the student from the course list exists in the HashMap list students per course             
                        counter++;
                    }
                }
                if (counter >= 2) {
                    System.out.println("The student " + student.getFirstName()+" "+student.getLastName() + " is in more than one course!");
                }
            }
            
        }
    }
}
