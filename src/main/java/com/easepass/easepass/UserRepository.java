package com.easepass.easepass; //(check controller class to confirm its correct)

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByUsernameAndPassword(String username, String password);
    List<User> findByUsertype(String usertype);
  List<User> findByStatusAndUsertype(String status,String usertype);
                             
}