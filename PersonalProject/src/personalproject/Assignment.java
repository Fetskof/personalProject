/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Fetskof
 */
public class Assignment {
    private String title;
    private String description;
    private Date subDateTime;
    private double oralMark;
    private double totalMark;
    private  ArrayList<Assignment> assignmentList = new ArrayList<>();

    public Assignment() {
        
    }

    public Assignment(String title, String description, Date subDateTime, double oralMark, double totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }

    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public ArrayList<Assignment> getAssignmentList() {
        return assignmentList;
    }

    public  void setAssignmentList() throws Exception {
        
        Boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("to enter an assignment type: 1\n"
                + "to use the default assignments type: 2");

        while (x == false) {
            String f = input.next();
            switch (f) {
                case "1":
                    assignmentList = userAssignmentList();
                    x = true;
                    break;
                case "2":
                    assignmentList = assignmentStaticData();
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input!");

            }

        }
        
    }
    
    

    @Override
    public String toString() {
        return "Assignment{" + "\ntitle=" + title + "\ndescription=" + description + "\noralMark=" + oralMark + "\ntotalMark=" + totalMark + '}'+"\n";
    }
    
    public  ArrayList<Assignment> assignmentStaticData() throws Exception {        
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("12/04/2021");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("14/04/2021");
        Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse("15/05/2021");
        Assignment a1 = new Assignment("project1","Individual project description",date1,80,90);
        Assignment a2 = new Assignment("Project2","Team project description",date2,100,87);
        Assignment a3 = new Assignment("Project3"," team project 2 description",date3,90,65);
        ArrayList<Assignment> staticAssignments=new ArrayList();
        staticAssignments.add(a1);
        staticAssignments.add(a2);
        staticAssignments.add(a3);
        return staticAssignments;
    }
    
    public  void printAssignments(ArrayList<Assignment> list){        
        for( int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    
    
    public  void assignmentMain() throws Exception{
        boolean x = false;
        Scanner input = new Scanner(System.in);                
        System.out.println("Type 1 to enter an assignment:\n"
                + "Type 2 to see the assignments:\n");
        String f = input.next();
        while (x == false) {
            switch (f) {
                case "1":
                    setAssignmentList();
                    x = true;
                    break;
                case "2":
                    printAssignments(assignmentList);
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter an assignment:\n"
                            + "Type 2 to see the courses:\n");
            }

        }
        
    }
    
     public static ArrayList<Assignment> userAssignmentList() throws Exception {
        Boolean x = false;        
        Scanner input = new Scanner(System.in);
        Assignment assignment = new Assignment();
        ArrayList<Assignment> assignList= new ArrayList<>();
        while (x == false) {
            System.out.println("Give the title of the assignment:");
            assignment.setTitle(input.nextLine());
            System.out.println("Give the description of the assignment:");
            assignment.setDescription(input.nextLine());
            System.out.println("Give the submition date of the assignment in format dd/MM/yyyy:");
            Date assignDate = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
            assignment.setSubDateTime(assignDate);
            System.out.println("Give the OralMark of the assignment:");
            assignment.setOralMark(input.nextDouble());
            System.out.println("Give the TotalMark of the assignment:");
            assignment.setTotalMark(input.nextDouble());
            assignList.add(assignment);
            System.out.println("Do you want to add another assignment?\n"
                    + "Yes: 1   ,  No: 2 ");
            String f = input.next();
            switch ((f)) {
                case "1":
                    userAssignmentList();
                    break;
                case "2":
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        }
        return assignList;
    }
}
