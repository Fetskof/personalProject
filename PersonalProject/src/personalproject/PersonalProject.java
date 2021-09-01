/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.util.Scanner;

/**
 *
 * @author Fetskof
 */
public class PersonalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        boolean enter = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Bootcamp");
        Student student = new Student();
        StudentsPerCourse studentPerCourse = new StudentsPerCourse();
        Course course = new Course();
        AssignmentsPerCourse assignmentPerCourse = new AssignmentsPerCourse();
        Assignment assignment = new Assignment();
        TrainersPerCourse trainerPerCourse = new TrainersPerCourse();
        Trainer trainer = new Trainer();
        AssignmentPerStudent assignmentPerStudent = new AssignmentPerStudent();
        while (enter == false) {
            System.out.println("Type 1 to setup or print the students:\n"
                    + "Type 2 to setup or print the courses:\n"
                    + "Type 3 to setup or print the trainers:\n"
                    + "Type 4 to setup or print the assignments:\n"
                    + "Type 5 to setup or print the students per course:\n"
                    + "Type 6 to setup or print the trainers per course:\n"
                    + "Type 7 to setup or print the assignments per course:\n"
                    + "Type 8 to setup or print the assignments per student:\n"
                    + "Type 9 to see the student in more than one course:\n"
                    + "Type 10 to see when the assignments are due:\n"
                    + "Type 0 to exit:");
            String x = input.next();
            switch (x) {
                case "1":
                    student.studentMain();
                    break;
                case "2":
                    course.courseMain();
                    break;
                case "3":
                    trainer.trainerMain();
                    break;
                case "4":
                    assignment.assignmentMain();
                    break;
                case "5":
                    studentPerCourse = course.editSPC(studentPerCourse, student);
                    break;
                case "6":
                    trainerPerCourse = course.editTPC(trainerPerCourse, trainer);
                    break;
                case "7":
                    assignmentPerCourse = course.editAPC(assignmentPerCourse, assignment);
                    break;
                case "8":
                    assignmentPerStudent = student.editAPS(assignmentPerStudent, assignmentPerCourse.getAssignmentsPerCourseList(),
                            studentPerCourse.getStudentPerCourseList());
                    break;
                case "9":
                    course.studentsInMoreThanOneCourse(studentPerCourse.getStudentPerCourseList(), student.getStudentsList());
                    break;
                case "10":
                    student.findDateOfWeek(assignmentPerStudent);
                    break;
                case "0":
                    enter = true;
                    break;
                default:
                    System.out.println("Wrong input!");                    
            }

        }

    }

}
