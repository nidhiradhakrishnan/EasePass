package com.easepass.easepass;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;

import java.util.Date;

import java.util.TimeZone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZoneId;


 

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;






@RestController
public class Controller {

@Autowired
    private UserRepository userRepository;
@Autowired
   private StudentRepository studentRepository;
@Autowired
   private TravelRepository travelRepository;
@Autowired
   private PassRepository passRepository;
   @Autowired
   private IdcardRepository idcardRepository;




@RequestMapping("/")
public ModelAndView index() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("mainpage.html");
   return modelAndView;
}

@RequestMapping("/optionchoose")
public ModelAndView optionchoose() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("optionchoose.html");
   return modelAndView;
}

@RequestMapping("/studentlogin")
public ModelAndView studentlogin() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studentlogin.html");
   return modelAndView;
}

@RequestMapping("/studentsignupform")
public ModelAndView studentsignupform() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studentsignupform.html");
   return modelAndView;
}

@RequestMapping("/studenthome")
public ModelAndView studenthome() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studenthome.html");
   return modelAndView;
}


@RequestMapping("/studentapply")
public ModelAndView studentapply() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studentapply.html");
   return modelAndView;
}

@RequestMapping("/studentqr")
public ModelAndView studentqr() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studentqr.html");
   return modelAndView;
}

@RequestMapping("/studenttrack")
public ModelAndView studenttrack() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studenttrack.html");
   return modelAndView;
}
@RequestMapping("/studentaccount")
public ModelAndView studentaccount() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("studentaccount.html");
   return modelAndView;
}

@RequestMapping("/conductorsignupform")
public ModelAndView conductorsignupform() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("conductorsignupform.html");
   return modelAndView;
}

@RequestMapping("/conductorhome")
public ModelAndView conductorhome() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("conductorhome.html");
   return modelAndView;
}

@RequestMapping("/conductoraccount")
public ModelAndView conductoraccount() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("conductoraccount.html");
   return modelAndView;
}


@RequestMapping("/adminhome")
public ModelAndView adminhome() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("adminhome.html");
   return modelAndView;
}

@RequestMapping("/adminstudent")
public ModelAndView adminstudent() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("adminstudent.html");
   return modelAndView;
}

@RequestMapping("/adminconductor")
public ModelAndView adminconductor() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("adminconductor.html");
   return modelAndView;
}


@RequestMapping("/conductorqr")
public ModelAndView conductorqr() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("conductorqr.html");
   return modelAndView;
}

@RequestMapping("/upload")
public ModelAndView upload() {
ModelAndView modelAndView = new ModelAndView();
   modelAndView.setViewName("image.html");
   return modelAndView;
}






@CrossOrigin(origins = "*")
   @PostMapping(path="/orderid", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> orderid(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
Order order = null;
try {
RazorpayClient razorpay = new RazorpayClient("rzp_test_8FOoAcnh1nEyjc", "ohTymlr9zcdldhryusMUjMXc");

JSONObject orderRequest = new JSONObject();
System.out.println(requestObj.getString("fare"));
String amount= requestObj.getString("fare");
orderRequest.put("amount", amount); // paisa
//orderRequest.put("amount", "400000"); // paisa

orderRequest.put("currency", "INR");
orderRequest.put("receipt", "Ease Pass");

order = razorpay.orders.create(orderRequest);
} catch (RazorpayException e) {
// Handle Exception
System.out.println(e.getMessage());
}
return new ResponseEntity<>(order.toString(), HttpStatus.OK);
}


//checklogin

@CrossOrigin(origins = "*")
   @PostMapping(path="/checkLogin", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> checkLogin(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<User> userList =  userRepository.findByUsernameAndPasswordAndStatus(
                             requestObj.getString("username"), 
                             requestObj.getString("password"),"approved");

      JSONObject responseObj = new JSONObject();
      if(null == userList || userList.size()<1) {
         //means no data
         responseObj.put("status","Invalid username and password");
      } else {
         responseObj.put("status","Login succes");
                  responseObj.put("usertype",userList.get(0).usertype);

      }
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }

//signupform
   @CrossOrigin(origins = "*")
   @PostMapping(path="/signup", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> signup(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      User user=new User(
         requestObj.getString("username"),
         requestObj.getString("phonenumber"),
         requestObj.getString("password"),
         requestObj.getString("usertype"),
         requestObj.getString("identitynumber"),
         requestObj.getString("status"));

            JSONObject responseObj = new JSONObject();
 
     try {
      User userList =  userRepository.save(user);
               responseObj.put("status","account created");

      } catch(Exception e){
         responseObj.put("status",e.getMessage());

      }
    
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }
//adminhome

   @CrossOrigin(origins = "*")
   @PostMapping(path="/listuser", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> listuser(HttpEntity<String> httpEntity) 
 {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<User> userList =  userRepository.findByStatusAndUsertype(
                             requestObj.getString("status"), 
                             requestObj.getString("usertype"));

      JSONObject responseObj = new JSONObject();
      if(null == userList || userList.size()<1) {
         //means no data
         responseObj.put("status","No pending request");
      } else {
         JSONArray ary = new JSONArray();

for(int i=0;i < userList.size();i++) {
User userObj = userList.get(i);
JSONObject jsonObj = new JSONObject();
jsonObj.put("username",userObj.username);
jsonObj.put("phonenumber",userObj.phonenumber);
jsonObj.put("identitynumber",userObj.identitynumber);



ary.put(jsonObj);
}
         responseObj.put("status","list user");
                  responseObj.put("users",ary);


      }
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }

//conductoraccount



   @CrossOrigin(origins = "*")
   @PostMapping(path="/conductoraccountdetails", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> conductoraccountdetails(HttpEntity<String> httpEntity) 
 {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<User> userList =  userRepository.findByUsername(
                             requestObj.getString("username"));

      JSONObject responseObj = new JSONObject();
      if(null == userList || userList.size()<1) {
         //means no data
         responseObj.put("status","invalid applicant");
      } else {
         JSONArray ary = new JSONArray();
User userObj = userList.get(0);
responseObj.put("username",userObj.username);
responseObj.put("phonenumber",userObj.phonenumber);
responseObj.put("identitynumber",userObj.identitynumber);

         responseObj.put("status","list user");

      }
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }


//apply
@CrossOrigin(origins = "*")
   @PostMapping(path="/apply", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
      produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> apply(HttpEntity<String> httpEntity) {
    //  String fileName = StringUtils.cleanPath(file.getOriginalFilename());

      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      Student student=new Student(
         requestObj.getString("username"),
         requestObj.getString("dateofbirth"),
         requestObj.getString("phonenumber"),
         requestObj.getString("admissionnumber"),
      //   requestObj.getString("collegeidcard"),
         requestObj.getString("educationalinstitution"),
         requestObj.getString("courseofstudy"),
         requestObj.getString("academicyearofstudy"),
         requestObj.getString("startingpoint"),
         requestObj.getString("endingpoint"),
         requestObj.getString("startDate"),
         requestObj.getString("endDate"),
         "pending"
        // fileName
         //ile.getContentType(), file.getBytes()
);


            JSONObject responseObj = new JSONObject();
 
     try {
      Student apply =  studentRepository.save(student);
               responseObj.put("status","apply success");
             List<Travel> farelist=travelRepository.findByFromAndTo( requestObj.getString("startingpoint"),
         requestObj.getString("endingpoint"));
               if(null == farelist || farelist.size()<1) {
         //means no data
         responseObj.put("status","Invalid from and to");
      } else {
         responseObj.put("status","Login succes");
                  responseObj.put("fare",farelist.get(0).fare);

      }

      } catch(Exception e){
         responseObj.put("status",e.getMessage());

      }
    
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }


//list student details


   @CrossOrigin(origins = "*")
   @PostMapping(path="/studentlistdetails", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> studentlistdetails(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<Student> studentList =  studentRepository.findByUsernameAndStatus(
                             requestObj.getString("username"),"approved");

      JSONObject responseObj = new JSONObject();
      if(null == studentList || studentList.size()<1) {
         //means no data
         responseObj.put("status","invalid applicant");
      } else {
        
                  responseObj.put("username",studentList.get(0).username);
                  responseObj.put("dateofbirth",studentList.get(0).dateofbirth);
                  responseObj.put("username",studentList.get(0).username);
                  responseObj.put("phonenumber",studentList.get(0).phonenumber);
                  responseObj.put("admissionnumber",studentList.get(0).admissionnumber);
               //   responseObj.put("collegeidcard",studentList.get(0).collegeidcard);
                  responseObj.put("educationalinstitution",studentList.get(0).educationalinstitution);
                  responseObj.put("courseofstudy",studentList.get(0).courseofstudy);
                  responseObj.put("academicyearofstudy",studentList.get(0).academicyearofstudy);
                  responseObj.put("startingpoint",studentList.get(0).startingpoint);
                  responseObj.put("endingpoint",studentList.get(0).endingpoint);
                  responseObj.put("startDate",studentList.get(0).startdate);
                  responseObj.put("endDate",studentList.get(0).enddate);


      TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
      Date dateonly=new Date();
      LocalDateTime localDateTime = dateonly.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        // Set time to midnight
        localDateTime = localDateTime.with(LocalTime.MIN);
        
        // Convert back to Date
        dateonly = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


     List<Pass> passList = passRepository.findByStudentAndOnwardtimeAfter( requestObj.getString("username"),dateonly);

      if(null == passList || passList.size()<1) 
         {

                  responseObj.put("onward","no");


          }

      else{

            responseObj.put("onward","yes");

      }


      List<Pass> passList2 = passRepository.findByStudentAndReturntimeAfter( requestObj.getString("username"),dateonly);
      if(null == passList2 || passList2.size()<1) 
         {

                  responseObj.put("return","no");


          }

      else{

            responseObj.put("return","yes");

      }
 }
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }

//mark ease pass
   @CrossOrigin(origins = "*")
   @PostMapping(path="/conductormark", 
    consumes = MediaType.APPLICATION_JSON_VALUE, 
      produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> conductormark(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());


        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
      Date dateonly=new Date();
      LocalDateTime localDateTime = dateonly.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        
        // Set time to midnight
        localDateTime = localDateTime.with(LocalTime.MIN);
        
        // Convert back to Date
        dateonly = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


     List<Pass> passList = passRepository.findByStudentAndOnwardtimeAfter( requestObj.getString("student"),dateonly);
              JSONObject responseObj = new JSONObject();

      if(null == passList || passList.size()<1) 
         { 
            Pass pass=new Pass(
         0,
         requestObj.getString("student"),
         new Date(),
         requestObj.getString("conductor"),
         null,null);

 
        try {
      Pass apply =  passRepository.save(pass);
               responseObj.put("status","apply success");
      } catch(Exception e){
         responseObj.put("status",e.getMessage());

      }
    
         }
      else {
          Pass row = passList.get(0);
          row.returntime=new Date();
          row.conductorre = requestObj.getString("conductor");
         Pass apply =  passRepository.save(row);
               responseObj.put("status","apply success");

     
      }
     
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }




//admin application



   @CrossOrigin(origins = "*")
   @PostMapping(path="/studentapplication", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> studentapplication(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<Student> studentList =  studentRepository.findByStatus(
                             requestObj.getString("status"));


  JSONObject responseObj = new JSONObject();
      if(null == studentList || studentList.size()<1) {
         //means no data
         responseObj.put("status","No pending request");
      } else {
         JSONArray ary = new JSONArray();

for(int i=0;i < studentList.size();i++) {
Student userObj = studentList.get(i);
JSONObject jsonObj = new JSONObject();
jsonObj.put("username",userObj.username);
jsonObj.put("educationalinstitution",userObj.educationalinstitution);
jsonObj.put("admissionnumber",userObj.admissionnumber);
jsonObj.put("startingpoint",userObj.startingpoint);
jsonObj.put("endingpoint",userObj.endingpoint);
jsonObj.put("startDate",userObj.startdate);
ary.put(jsonObj);
}
         responseObj.put("status","list user");
                  responseObj.put("application",ary);


   }


      
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }



//admin easepass
 @CrossOrigin(origins = "*")
   @PostMapping(path="/admineasepass", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> admineasepass(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
       List<Pass> passList;
      if (requestObj.getString("username").equals("all"))
       {
          passList =  passRepository.findAll();
  
      }
      else
      {
      passList =  passRepository.findByStudent(
                             requestObj.getString("username"));}


  JSONObject responseObj = new JSONObject();
      if(null == passList || passList.size()<1) {
         //means no data
         responseObj.put("status","No pending request");
      } else {
         JSONArray ary = new JSONArray();

for(int i=0;i < passList.size();i++) {
Pass userObj = passList.get(i);
JSONObject jsonObj = new JSONObject();
jsonObj.put("username",userObj.student);
jsonObj.put("onwardtime",userObj.onwardtime);
jsonObj.put("conductoron",userObj.conductoron);
jsonObj.put("returntime",userObj.returntime);
jsonObj.put("conductorre",userObj.conductorre);
ary.put(jsonObj);
}
         responseObj.put("status","list user");
                  responseObj.put("easepass",ary);


   }


      
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }



//adminapproveuser

@CrossOrigin(origins = "*")
   @PostMapping(path="/adminapprove", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> adminapprove(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<User> userList =  userRepository.findByUsername(
                             requestObj.getString("username"));


  JSONObject responseObj = new JSONObject();
      if(null == userList || userList.size()<1) {
         //means no data
         responseObj.put("status","No pending request");
      } else {
         JSONArray ary = new JSONArray();
       User row = userList.get(0);
      row.status= requestObj.getString("status");
      
     try {
      userRepository.save(row);
      responseObj.put("status","approved");

      } catch(Exception e){
         responseObj.put("status",e.getMessage());

      }


   }


      
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }



//adminapprove application

   @CrossOrigin(origins = "*")
   @PostMapping(path="/adminapproveapplication", consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> adminapproveapplication(HttpEntity<String> httpEntity) {
      JSONObject requestObj = new JSONObject(httpEntity.getBody());
      List<Student> studentList =  studentRepository.findByUsername(
                             requestObj.getString("username"));


  JSONObject responseObj = new JSONObject();
      if(null == studentList || studentList.size()<1) {
         //means no data
         responseObj.put("status","No pending request");
      } else {
         JSONArray ary = new JSONArray();
       Student row = studentList.get(0);
      row.status= requestObj.getString("status");
      
     try {
      studentRepository.save(row);
      responseObj.put("status","approved");

      } catch(Exception e){
         responseObj.put("status",e.getMessage());

      }


   }


      
      return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);
   }




//upload

   @CrossOrigin(origins = "*")
   @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Idcard dbFile = new Idcard("gokul",file.getBytes(),fileName,file.getContentType());

            Idcard image = idcardRepository.save(dbFile);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(image.filename)
            .toUriString();


        } catch (Exception ex) {
            //throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
        }
              return new ResponseEntity<>(responseObj.toString(), HttpStatus.OK);

    }



}