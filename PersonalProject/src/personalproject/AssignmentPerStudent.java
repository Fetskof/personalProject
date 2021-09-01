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
public class AssignmentPerStudent {
    private HashMap<Student,ArrayList<Assignment>> assignmentPerStudentList;

    public AssignmentPerStudent() {
        this.assignmentPerStudentList =new HashMap<Student,ArrayList<Assignment>>();
    }
    

    public AssignmentPerStudent(HashMap<Student, ArrayList<Assignment>> assignmentPerStudentList) {
        this.assignmentPerStudentList = assignmentPerStudentList;
    }

    public HashMap<Student, ArrayList<Assignment>> getAssignmentPerStudentList() {
        return assignmentPerStudentList;
    }

    public void setAssignmentPerStudentList(HashMap<Student, ArrayList<Assignment>> assignmentPerStudentList) {
        this.assignmentPerStudentList = assignmentPerStudentList;
    }
    
    
}
