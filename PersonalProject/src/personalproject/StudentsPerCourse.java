/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.util.ArrayList;

import java.util.HashMap;


/**
 *
 * @author Fetskof
 */
public class StudentsPerCourse  {
   
  private  HashMap<Course,ArrayList<Student>> studentPerCourseList;

    public StudentsPerCourse() {
        this.studentPerCourseList = new HashMap<Course,ArrayList<Student>> ();
    }

    public StudentsPerCourse(HashMap<Course, ArrayList<Student>> studentPerCourseList) {
        this.studentPerCourseList = studentPerCourseList;
    }

    public HashMap<Course, ArrayList<Student>> getStudentPerCourseList() {
        return studentPerCourseList;
    }

    public void setStudentPerCourseList(HashMap<Course, ArrayList<Student>> studentPerCourseList) {
        this.studentPerCourseList = studentPerCourseList;
    }

   

    
 
            

          

   
 
    


   
}
