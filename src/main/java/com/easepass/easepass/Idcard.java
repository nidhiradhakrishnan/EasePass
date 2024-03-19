package com.easepass.easepass; //(check controller.java pade to confirm its correct)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;


@Entity
public class Idcard {

    @Id
    public String username;
 @Lob
   public byte[] file;
    public String filename;
   public String filetype;

   

    public Idcard() {}

    public Idcard(
        String username, 
        byte[] file, 
        String filename,
        String filetype) 
    {
        this.username = username;
      this.file = file;
     this.filename = filename;
       this.filetype = filetype;

        
    

    }

}