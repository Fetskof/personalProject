/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Fetskof
 */
public class Student {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int tuitionFees;
    private ArrayList<Student> studentsList = new ArrayList<>();

    public Student() {
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public Student(String firstName, String lastName,Date dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "Student{" + "\nfirstName=" + firstName + "\nlastName=" + lastName + "\ndateOfBirth=" + dateOfBirth + "\ntuitionFees=" + tuitionFees + '}'+"\n";
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
     public void studentMain() throws Exception {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 to enter a student or use the default students:\n"
                + "Type 2 to see the students:\n");
        String f = input.next();
        while (x == false) {
            switch (f) {
                case "1":
                    setStudentList();
                    x = true;
                    break;
                case "2":
                    printStudents(studentsList);
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter a student or use the default students:\n"
                            + "Type 2 to see the students:\n");
            }

        }

    }

    public ArrayList<Student> studentsStaticData() throws Exception {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("12/07/1990");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("16/04/1991");
        Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2000");
        Student s1 = new Student("Theo", "Feskos",date1 ,2500);
        Student s2 = new Student("John", "Frag", date2,2000);
        Student s3 = new Student("Zaxos", "Tsiap",date3, 2225);
        ArrayList<Student> staticData = getStudentsList();
        staticData.add(s1);
        staticData.add(s2);
        staticData.add(s3);
        return getStudentsList();
    }

    public static void printStudents(ArrayList<Student> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public ArrayList<Student> setStudentList() throws Exception {
        Boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("to enter students Type: 1\n"
                + "to use the default students Type: 2");
        while (x == false) {
            String f = input.next();
            switch (f) {
                case "1":
                    studentsList = userStudentList();
                    x = true;
                    break;
                case "2":
                    studentsList = studentsStaticData();
                    x = true;
                    break;
                default:
                    System.out.println("Wrong Input!");
            }
        }
        return studentsList;
    }

    public ArrayList<Student> userStudentList() throws Exception {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        while (x == false) {
            System.out.println("Give the first name of the student:");
            student.setFirstName(input.next());
            System.out.println("Give the last name of the student:");
            student.setLastName(input.next());
            System.out.println("Give the date of birth of the student in the format dd/MM/yyyy:");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
            student.setDateOfBirth(date);
            System.out.println("Give the tuittion fees:");
            student.setTuitionFees(input.nextInt());
            getStudentsList().add(student);
            System.out.println("Do you want to add another student?\n"
                    + "Yes: 1   ,  No: 2 ");
            String f = input.next();
            switch ((f)) {
                case "1":
                    userStudentList();
                    x = false;
                case "2":
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        }
        System.out.println("Do you want to see the students you added?\n"
                + "Yes: 1  ,  No: 2 ");
        String f = input.next();
        switch (f) {
            case "1":
                printStudents(studentsList);
                break;
            case "2":
                break;
            default:
                System.out.println("Wrong input");
        }
        return studentsList;
    }

    public AssignmentPerStudent editAPS(AssignmentPerStudent assignmentPerStudentList,//method that creates the assignments per student
            HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList,
            HashMap<Course, ArrayList<Student>> studentPerCourseList) {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Type 1 to enter the assignments per student:\n"
                + "Type 2 to see the assignments per student:\n");
        String f = input.nextLine();
        while (x == false) {
            switch (f) {
                case "1":
                    assignmentPerStudentList = editAssignmentPerStudent(assignmentPerStudentList,
                            assignmentsPerCourseList, studentPerCourseList);
                    x = true;
                    break;
                case "2":
                    printAssignmentsPerStudent(assignmentPerStudentList.getAssignmentPerStudentList());
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter the trainers per course:\n"
                            + "Type 2 to see the trainers per course:\n");
            }
        }
        return assignmentPerStudentList;
    }

    public AssignmentPerStudent editAssignmentPerStudent(AssignmentPerStudent assignmentPerStudentList,
            HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList,
            HashMap<Course, ArrayList<Student>> studentPerCourseList) {
        System.out.println("Type the name of the student to enter the assignments");
        printStudents(studentsList);
        Scanner input = new Scanner(System.in);
        String inputStudentName = input.nextLine();
        Student student = findStudent(inputStudentName);
        if (student == null) {
            System.out.println("The student does not exist...Please try again.");
            return assignmentPerStudentList;
        }
        ArrayList<Assignment> assignmentPSL = new ArrayList<Assignment>();
        assignmentPSL = createStudentsPerCourseList(student, assignmentsPerCourseList, studentPerCourseList);//method that creates an assignment list that we put in the next line in the value of the HashMap with key an object student
        assignmentPerStudentList.getAssignmentPerStudentList().put(student, assignmentPSL);
        return assignmentPerStudentList;
    }

    private Student findStudent(String studentName) {//method that checks if the name of the student exists in the ArrayList of the students
        for (Student student : getStudentsList()) {
            if (studentName.equals(student.getLastName())) {
                return student;
            }
        }
        return null;
    }

    private ArrayList<Assignment> createStudentsPerCourseList(Student student,
            HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList,
            HashMap<Course, ArrayList<Student>> studentPerCourseList) {
        Scanner input = new Scanner(System.in);
        ArrayList<Assignment> assignList = new ArrayList<>();
        for (Map.Entry assignmentEntry : assignmentsPerCourseList.entrySet()) {//loop for every assignment in a course
            ArrayList<Assignment> assignmentEntryList = (ArrayList<Assignment>) assignmentEntry.getValue();// an ArrayList which shows the reference of the value of assignment list the HashMap with key the object course
            for (Map.Entry studentEntry : studentPerCourseList.entrySet()) {//loop for every student in a course
                ArrayList<Student> studentEntryList = (ArrayList<Student>) studentEntry.getValue();// an ArrayList which shows the reference of the value of student list of the HashMap with key the object course
                for (Student studentListEntry : studentEntryList) {//loop for the studentlist inside a course
                    if (!studentListEntry.equals(student)) {//checks if the student we typed before the method started is equal to the student of the for loop above, if not it skips 1 loop
                        continue;
                    }
                    for (Assignment assignment : assignmentEntryList) {//loop for the assignment list inside a course
                        if (studentEntry.getKey().equals(assignmentEntry.getKey())) {//ckecks if the course of the student is equal to the course of the assignment
                            System.out.println("Do you want to add the "
                                    + assignment.toString() + " in this student"
                                    + "?\n" + "Yes: 1    No: 2");
                            String f = input.nextLine();
                            if (assignList.contains(assignment)) {
                                break;
                            }
                            if (f.equals("1")) {
                                assignList.add(assignment);
                            } else if (f.equals("2")) {
                                System.out.println("You did not enter the assignment\n");
                            } else {
                                System.out.println("Wrong input!\n");
                            }
                        }
                    }
                }
            }
        }

        return assignList;
    }

    public void printAssignmentsPerStudent(HashMap<Student, ArrayList<Assignment>> assignmentsPerStudentList) {
        if (assignmentsPerStudentList == null) {
            System.out.println("the list is empty");
            return;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Type the last name of the student you want to see the assignments from");
        printStudentLastName();
        String studentLastNameFromUser = input.nextLine();
        for (Map.Entry entry : assignmentsPerStudentList.entrySet()) {
            Student student = (Student) entry.getKey();
            ArrayList<Assignment> assignmentPSL = (ArrayList<Assignment>) entry.getValue();
            if (studentLastNameFromUser.equals(student.getLastName())) {
                System.out.println("For the student: " + student.getLastName() + " the assignment is: " + assignmentPSL);
            }

        }
    }

    public void printStudentLastName() {
        for (Student student : getStudentsList()) {
            System.out.println("The last name of the student is: " + student.getLastName());
        }
    }

    public void findDateOfWeek(AssignmentPerStudent assignmentPerStudent) {
        Scanner input = new Scanner(System.in);        
        System.out.println("Give the date of submission(Format: dd/MM/yyyy)\n");
        String userin = input.nextLine();
        Date date1=null;         
        Calendar cal_1 = Calendar.getInstance();//creates 2 objects calendar so we can use its methods
        Calendar cal_2 = Calendar.getInstance();
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(userin);            
        } catch (Exception ex) {
            System.out.println("The given date is wrong please try again");
            return;
        }
        cal_2.setTime(date1);
        int weekGivenDate = cal_2.get(Calendar.WEEK_OF_YEAR);//makes the given date in the specific week of the date
        ArrayList<Student> studentsWithAssignmentDue = new ArrayList<>();
        for (Student studentEntry : assignmentPerStudent.getAssignmentPerStudentList().keySet()) {//loop that gets the asignments per student
            ArrayList<Assignment> assignmentsDueList = assignmentPerStudent.getAssignmentPerStudentList().get(studentEntry);
            for (Assignment assign : assignmentsDueList) { //loop that brings every assignment in the above list               
                Date dateDue = assign.getSubDateTime();
                cal_1.setTime(dateDue);                
                int weekDueDate = cal_1.get(Calendar.WEEK_OF_YEAR);//makes the submition date of the assignment in the specific week of the date
                if (weekDueDate==weekGivenDate) {// checks if the  both weeks are the same, if yes it adds the student with that assignemnt that is due in the list
                   studentsWithAssignmentDue.add(studentEntry);

                }
            }
        }
        System.out.println("The students that have to submit their assignments this week are: "+studentsWithAssignmentDue);
    }
}
