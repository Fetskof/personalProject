/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalproject;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author user
 */
public class Trainer {
    private String firstName;
    private String lastName;
    private String subject;
    private  ArrayList<Trainer> trainersList;
    
    public Trainer() {
    }

    public Trainer(ArrayList<Trainer> trainersList) {
        this.trainersList = trainersList;
    }
    
    
    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Trainer> getTrainersList() {
        return trainersList;
    }

    public void setTrainersList(ArrayList<Trainer> trainerli) {
        Boolean x = false;
        Scanner input = new Scanner(System.in);
        System.out.println("to enter a trainer type: 1\n"
                + "to use the default trainers type: 2");

        while (x == false) {
            String f = input.next();
            switch (f) {
                case "1":
                    this.trainersList = userTrainerList(trainerli);
                    x = true;
                    break;
                case "2":
                    this.trainersList = trainersStaticData();
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    @Override
    public String toString() {
        return "Trainer{" + "\nfirstName=" + firstName + "\nlastName=" + lastName + "\nsubject=" + subject + '}'+"\n";
    }    
    
    
    public  ArrayList<Trainer> trainersStaticData(){
        Trainer t1 = new Trainer("George","Irakleidis","OOP");
        Trainer t2 = new Trainer("George","Rigopoulos","SQL");
        Trainer t3 = new Trainer("Spyros","Mauros","DEVOPS");
        ArrayList<Trainer> staticTrainers=new ArrayList();
        staticTrainers.add(t1);
        staticTrainers.add(t2);
        staticTrainers.add(t3);
        return staticTrainers;
    }
    
      public  ArrayList<Trainer> userTrainerList(ArrayList<Trainer> trainList) {
        Boolean x = false;        
        Scanner input = new Scanner(System.in);
        Trainer trainer = new Trainer();        
        while (x == false) {
            System.out.println("Give the first name of the trainer:");
            trainer.setFirstName(input.nextLine());
            System.out.println("Give the last name of the trainer:");
            trainer.setLastName(input.nextLine());
            System.out.println("Give the subject of the trainer:");
            trainer.setSubject(input.nextLine());            
            System.out.println("Do you want to add another trainer?\n"
                    + "Yes: 1   ,  No: 2 ");
            String f = input.next();
            switch ((f)) {
                case "1":
                    userTrainerList(trainList);
                    break;
                case "2":
                    x = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        }
        return trainList;
    }
      
      public  void trainerMain() {
        boolean x = false;
        Scanner input = new Scanner(System.in);
        ArrayList<Trainer> trainList= new ArrayList<>();        
        System.out.println("Type 1 to enter a trainer or use the default trainers:\n"
                + "Type 2 to see the trainers:\n");
        String f = input.next();
        while (x == false) {
            switch (f) {
                case "1":
                    setTrainersList(trainList);
                    x = true;
                    break;
                case "2":
                    printTrainer(getTrainersList());
                    x = true;
                    break;
                default:
                    System.out.println("Type 1 to enter a trainer or use the default trainers:\n"
                            + "Type 2 to see the trainer:\n");
            }
        }        
    }
      
      public  void printTrainer(ArrayList<Trainer> list){        
        for( int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
      
}
