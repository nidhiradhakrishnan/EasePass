package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    public String username;
    public String dateofbirth;
    public String phonenumber;
    public String admissionnumber;
    public String collegeidcard;
    public String educationalinstitution;
    public String courseofstudy;
    public String academicyearofstudy   ;
    public String startingpoint;
    public String endingpoint;
    public String startdate;
    public String enddate;


    public Student() {}

    public Student(
        String username, 
        String dateofbirth, 
        String phonenumber, 
        String admissionnumber, 
        String collegeidcard, 
        String educationalinstitution,
        String courseofstudy, 
        String academicyearofstudy, 
        String startingpoint, 
        String endingpoint,
        String startdate,
        String enddate) {
        this.username = username;
        this.dateofbirth = dateofbirth;
        this.phonenumber = phonenumber;
        this.admissionnumber = admissionnumber;
        this.collegeidcard = collegeidcard;
        this.educationalinstitution = educationalinstitution;
        this.courseofstudy = courseofstudy;
        this.academicyearofstudy = academicyearofstudy;
        this.startingpoint = startingpoint;
        this.endingpoint = endingpoint;
        this.startdate = startdate;
        this.enddate = enddate;

    }

}