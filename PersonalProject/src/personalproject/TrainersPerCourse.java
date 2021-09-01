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
public class TrainersPerCourse {
    
    
    private  HashMap<Course,ArrayList<Trainer>> trainerPerCourseList;

    public TrainersPerCourse() {
        this.trainerPerCourseList= new HashMap<Course,ArrayList<Trainer>>();
    }

    
    public TrainersPerCourse(HashMap<Course, ArrayList<Trainer>> trainerPerCourseList) {
        this.trainerPerCourseList = trainerPerCourseList;
    }

    public HashMap<Course, ArrayList<Trainer>> getTrainerPerCourseList() {
        return trainerPerCourseList;
    }

    public void setTrainerPerCourseList(HashMap<Course, ArrayList<Trainer>> trainerPerCourseList) {
        this.trainerPerCourseList = trainerPerCourseList;
    }
    
}
