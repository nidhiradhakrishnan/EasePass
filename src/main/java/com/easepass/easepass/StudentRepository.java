package com.easepass.easepass; //(check controller class to confirm its correct)

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByUsername(
        String username);
    List<Student> findByUsernameAndStatus(
        String username,String status);
    List<Student> findByStatus(String status);



                     
}