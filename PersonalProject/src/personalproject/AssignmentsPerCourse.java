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
 * @author user
 */
public class AssignmentsPerCourse {
    private  HashMap<Course,ArrayList<Assignment>> assignmentsPerCourseList;

    public AssignmentsPerCourse() {
        this.assignmentsPerCourseList= new HashMap<Course,ArrayList<Assignment>>();
    }

    public AssignmentsPerCourse(HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList) {
        this.assignmentsPerCourseList = assignmentsPerCourseList;
    }

    public HashMap<Course, ArrayList<Assignment>> getAssignmentsPerCourseList() {
        return assignmentsPerCourseList;
    }

    public void setAssignmentsPerCourseList(HashMap<Course, ArrayList<Assignment>> assignmentsPerCourseList) {
        this.assignmentsPerCourseList = assignmentsPerCourseList;
    }
    
    
}
