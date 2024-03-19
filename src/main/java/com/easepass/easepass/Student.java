package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity
public class Student {

    @Id
    public String username;
    public String dateofbirth;
    public String phonenumber;
    public String admissionnumber;
    public String educationalinstitution;
    public String courseofstudy;
    public String academicyearofstudy   ;
    public String startingpoint;
    public String endingpoint;
    public String startdate;
    public String enddate;
    public String status;
    //public String filename;
   //public String filetype;

    //@Lob
   // public byte[] collegeidcard;

    public Student() {}

    public Student(
        String username, 
        String dateofbirth, 
        String phonenumber, 
        String admissionnumber, 
      //  byte[] collegeidcard, 
        String educationalinstitution,
        String courseofstudy, 
        String academicyearofstudy, 
        String startingpoint, 
        String endingpoint,
        String startdate,
        String enddate,
        String status)
        //String filename,
        //String filetype) 
    {
        this.username = username;
        this.dateofbirth = dateofbirth;
        this.phonenumber = phonenumber;
        this.admissionnumber = admissionnumber;
     //   this.collegeidcard = collegeidcard;
        this.educationalinstitution = educationalinstitution;
        this.courseofstudy = courseofstudy;
        this.academicyearofstudy = academicyearofstudy;
        this.startingpoint = startingpoint;
        this.endingpoint = endingpoint;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
     //  this.filename = filename;
       // this.filetype = filetype;

        
    

    }

}